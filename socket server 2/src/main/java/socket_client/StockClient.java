package socket_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class StockClient {
    public void clientStart() throws IOException {
        Socket client = new Socket("localhost", 9000);
        InputStream inputStream = client.getInputStream();
        OutputStream out = client.getOutputStream();
        out.write("Hello Server".getBytes());
        out.flush();
        inputStream.close();
        client.close();

    }

    public static void main(String[] args) throws IOException {

        StockClient client = new StockClient();
        client.clientStart();

//        ExecutorService es = Executors.newCachedThreadPool();
////        ExecutorService es = Executors.newFixedThreadPool(50);
//
//        es.execute(new Runnable() {
//            public void run() {
//                while (true) {
//                    System.out.println("Current thread: " + Thread.currentThread().getName());
//                    System.out.println("Avaialbe processor: " + Runtime.getRuntime().availableProcessors());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        es.execute(new Runnable() {
//            public void run() {
//                while (true) {
//                    System.out.println("Current thread: " + Thread.currentThread().getName());
//                    System.out.println("Avaialbe processor: " + Runtime.getRuntime().availableProcessors());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

    }
}
