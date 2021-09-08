package auction;

import datasource.StockDatasource;

import stock.OrderBuy;
import stock.OrderSell;
import stock.Stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Auction implements Runnable {


    Map<String, PriorityBlockingQueue<OrderSell>> queueSell = new HashMap<String, PriorityBlockingQueue<OrderSell>>();
    Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy = new HashMap<String, PriorityBlockingQueue<OrderBuy>>();

    public Auction(Map<String, PriorityBlockingQueue<OrderSell>> queueSell, Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy) {
        this.queueSell = queueSell;
        this.queueBuy = queueBuy;
    }

    //    public void action(PriorityBlockingQueue<OrderSell> queueSell, PriorityBlockingQueue<OrderBuy> queueBuy) {
    public void action() {

        String queryStock = "select stock_id,auc_price,ce_price,fl_price from stock where 1=1";

        List<Stock> stocks = new ArrayList<Stock>();

        Connection con = null;
        try {
            con = StockDatasource.getConnection();
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

//            for (Map.Entry<String, PriorityBlockingQueue<OrderSell>> entry : queueSell.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//
//            for (Map.Entry<String, PriorityBlockingQueue<OrderBuy>> entry : queueBuy.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }



        } catch (Exception e) {

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }


    public void run() {
        while (true) {
            action();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

