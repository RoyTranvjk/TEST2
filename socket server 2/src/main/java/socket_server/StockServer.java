package socket_server;

import auction.Auction;
import datasource.StockDatasource;
import model.ClientModelThread;
import pool.ThreadPools;

import stock.Stock;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

public class StockServer implements Runnable {

    static ExecutorService es = ThreadPools.getThreadPool();

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            System.out.println("Waiting for connection!");
            Socket client = server.accept();
            System.out.println("Connected!");

            ClientModelThread clientThread = new ClientModelThread(client, server, Stock.getQueueSell(), Stock.getQueueBuy());

            es.execute(clientThread);


        }
    }

    public static void main(String[] args) throws IOException {

        StockServer server = new StockServer();
        es.execute(server);
        Auction auction = new Auction(Stock.getQueueSell(), Stock.getQueueBuy());
        es.execute(auction);
    }

    public void run() {
        try {
            startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
