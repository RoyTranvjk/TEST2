package stock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

public class Stock {
    String stock;
    String comp;
    Double aucprice;
    Double ceprice;
    Double flprice;

    private static Map<String, PriorityBlockingQueue<OrderSell>> queueSell = new HashMap<String, PriorityBlockingQueue<OrderSell>>();
    private static Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy = new HashMap<String, PriorityBlockingQueue<OrderBuy>>();

    public Stock(String stock) {
        this.stock = stock;
    }

    public Stock(String stock, String comp, Double aucprice, Double ceprice, Double flprice) {
        this.stock = stock;
        this.comp = comp;
        this.aucprice = aucprice;
        this.ceprice = ceprice;
        this.flprice = flprice;
    }

    public Stock(String stockId, Double aucPrice, Double cePrice, Double flPrice) {
        this.stock = stockId;
        this.aucprice = aucPrice;
        this.ceprice = cePrice;
        this.flprice = flPrice;
    }

    public static Map<String, PriorityBlockingQueue<OrderSell>> getQueueSell() {
        return queueSell;
    }

    public static Map<String, PriorityBlockingQueue<OrderBuy>> getQueueBuy() {
        return queueBuy;
    }

    public static void setQueueBuy(Map<String, PriorityBlockingQueue<OrderBuy>> queueBuy) {
        Stock.queueBuy = queueBuy;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock='" + stock + '\'' +
                ", aucprice=" + aucprice +
                ", ceprice=" + ceprice +
                ", flprice=" + flprice +
                '}';
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public Double getAucprice() {
        return aucprice;
    }

    public void setAucprice(Double aucprice) {
        this.aucprice = aucprice;
    }

    public Double getCeprice() {
        return ceprice;
    }

    public void setCeprice(Double ceprice) {
        this.ceprice = ceprice;
    }

    public Double getFlprice() {
        return flprice;
    }

    public void setFlprice(Double flprice) {
        this.flprice = flprice;
    }


}
