package model;

import datasource.StockDatasource;

import stock.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

public class ClientModelThread implements Runnable {

    private Socket client;
    private ServerSocket server;
    private InputStream inputStream;
    private OutputStream outputStream;


    private Map<String, PriorityBlockingQueue<OrderSell>> queueSell = new HashMap<String, PriorityBlockingQueue<OrderSell>>();
    private Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy = new HashMap<String, PriorityBlockingQueue<OrderBuy>>();

    private String account;
    private String id;

    private boolean isSell;

    public ClientModelThread(Socket client, ServerSocket server, Map<String, PriorityBlockingQueue<OrderSell>> queueSell, Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy) {
        this.client = client;
        this.server = server;
        this.queueBuy = queueBuy;
        this.queueSell = queueSell;
    }


    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void run() {
        //ket noi den db de login
        int maxOrder = 0;
        Connection con = null;
        String query = "select acc_username,acc_id from account_info";
        Statement stmt = null;
        List<Account> accounts = new ArrayList<Account>();
        try {
            con = StockDatasource.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String account = rs.getString(1);
                String id = rs.getString(2);
                Account queryAccount = new Account(id, account);

                accounts.add(queryAccount); // luu cac thang lay ra tu db

            }
//            System.out.println(accounts);
            int accAmount = accounts.size();

            int randomNumber = (int) (Math.random() * accAmount); // random
//            System.out.println("random Number: " + randomNumber);
            this.account = accounts.get(randomNumber).getUsername();
            this.id = accounts.get(randomNumber).getAcc_id();

//            System.out.println("List la: " + accounts);
//            System.out.println("random: " + accounts.get(randomNumber));

            while (maxOrder < 6) {

                isSell = System.currentTimeMillis() % 2 == 0;

                if (isSell) {
                    sell(accounts.get(randomNumber));
                } else {
                    buy(accounts.get(randomNumber));
                }
                maxOrder++;

                Thread.sleep(200);
            }
//            action(queueSell, queueBuy);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {

                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finish");
        }

    }


    public void sell(Account acc) {
        Connection con = null;

        try {

            con = StockDatasource.getConnection();
            OrderSell orderSell = (OrderSell) generateOrder(new OrderSell(), con, acc, "sell");

            if (this.queueSell.get(orderSell.getStock().getStock()) != null) {
                PriorityBlockingQueue<OrderSell> queue = this.queueSell.get(orderSell.getStock().getStock());
                queue.add(orderSell);
                this.queueSell.put(orderSell.getStock().getStock(), queue);
            } else {
                PriorityBlockingQueue<OrderSell> queue = new PriorityBlockingQueue<OrderSell>();
                queue.add(orderSell);
                this.queueSell.put(orderSell.getStock().getStock(), queue);
            }

            System.out.println("[ " + orderSell.getStock().getStock() + ", queue sell]: " + queueSell);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {

                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        //insert db

        //dua vao queue

    }

    public void buy(Account acc) {
        //insert db
        Connection con = null;

        try {
            con = StockDatasource.getConnection();
            OrderBuy orderBuy = (OrderBuy) generateOrder(new OrderBuy(), con, acc, "buy");
            if (this.queueBuy.get(orderBuy.getStock().getStock()) != null) {
                PriorityBlockingQueue<OrderBuy> queue = this.queueBuy.get(orderBuy.getStock().getStock());
                queue.add(orderBuy);
                this.queueBuy.put(orderBuy.getStock().getStock(), queue);

            } else {
                PriorityBlockingQueue<OrderBuy> queue = new PriorityBlockingQueue<OrderBuy>();
                queue.add(orderBuy);
                this.queueBuy.put(orderBuy.getStock().getStock(), queue);
            }

            System.out.println("[ " + orderBuy.getStock().getStock() + ", queue buy]: " + queueBuy);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
//                    con.commit();
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // dua vao queue

    }

    public Order generateOrder(Order order, Connection con, Account acc, String action) throws SQLException {
        //query stock
        String queryStock = "select stock_id,auc_price,ce_price,fl_price from stock where 1=1";

        List<Stock> stocks = new ArrayList<Stock>();

//        con = StockDatasource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(queryStock);
        while (rs.next()) {

            String stockId = rs.getString(1);
            Double aucPrice = rs.getDouble(2);
            Double cePrice = rs.getDouble(3);
            Double flPrice = rs.getDouble(4);

            Stock stock = new Stock(stockId, aucPrice, cePrice, flPrice);

            stocks.add(stock); // luu cac thang lay ra tu db

        }

        int stockAmount = stocks.size();

        int randomNumber = (int) (Math.random() * stockAmount); // random
        Stock sellStock = stocks.get(randomNumber);
        int gapMoney = (int) (sellStock.getFlprice() - sellStock.getCeprice());
        double randomMoney = sellStock.getCeprice() + (Math.random() * gapMoney);

        int randomQty = System.currentTimeMillis() % 2 == 0 ? 100 : 200;

//        Order orderSell = new OrderSell();
        order.setAccount(acc);
        order.setStock(sellStock);
        order.setPrice(randomMoney);
        order.setQty(randomQty);

        //insert db
//        con.setAutoCommit(false);
//        String sql = null;
//        if (acc.equals("buy")) {
//            sql = "insert into trader_buy_order(acc_id,stock_id,time_create,trade_qty,trade_price) values(?,?,?,?,?)";
//        } else {
//            sql = "insert into trader_sell_order(acc_id,stock_id,time_create,trade_qty,trade_price) values(?,?,?,?,?)";
//        }
//        PreparedStatement preparedStmt = con.prepareStatement(sql);
//        preparedStmt.setInt(1, 1992);
//        preparedStmt.setString(2, "FPT");
//        preparedStmt.setDate(3, Date.valueOf(LocalDate.now()));
//        preparedStmt.setInt(4, 5000);
//        preparedStmt.setInt(5, 5000);
//        preparedStmt.execute();
//        con.commit();

        return order;
    }


}
