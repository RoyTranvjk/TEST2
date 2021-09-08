package stock;


public class OrderSell extends Order implements Comparable<OrderSell> {
    private int id;
    private Account acc_id;
    private Stock stock;
    private int qty;
    private Double price;

    public OrderSell(int id, Account acc_id, Stock stock, int qty, Double price) {
        this.id = id;
        this.acc_id = acc_id;
        this.stock = stock;
        this.qty = qty;
        this.qty = qty;
        this.price = price;

    }

    public OrderSell() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return acc_id;
    }

    public void setAccount(Account acc_id) {
        this.acc_id = acc_id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(OrderSell o) {
//        if (this.getPrice() > o.getPrice())
        return Double.compare(this.getPrice(), o.getPrice());
//        else return 1;
    }

    @Override
    public String toString() {
        return "OrderSell{" +
                "acc_id=" + acc_id +
                ", stock=" + stock +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }


//    @Override
//    public int compare(OrderSell o1, OrderSell o2) {
//        if (o1.getPrice() > o2.getPrice()) {
//            return 1;
//        }
//        return 0;
//    }
}

