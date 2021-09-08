package stock;

import java.util.concurrent.PriorityBlockingQueue;

public class TestComparable {
    public static void main(String[] args) {


        OrderSell orderSell1 = new OrderSell();
        orderSell1.setPrice(100d);
        orderSell1.setQty(200);

        OrderSell orderSell2 = new OrderSell();
        orderSell2.setPrice(90d);
        orderSell2.setQty(200);

        OrderSell orderSell3 = new OrderSell();
        orderSell3.setPrice(50d);
        orderSell3.setQty(200);

        OrderSell orderSell4 = new OrderSell();
        orderSell4.setPrice(150d);
        orderSell4.setQty(200);
        PriorityBlockingQueue<OrderSell> orderSells = new PriorityBlockingQueue<OrderSell>();

        orderSells.add(orderSell4);
        orderSells.add(orderSell2);
        orderSells.add(orderSell3);
        orderSells.add(orderSell1);
        System.out.println(orderSells);
    }
}
