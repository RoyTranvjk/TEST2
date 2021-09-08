package stock;


public class OrderBuy extends Order implements Comparable<OrderBuy> {
    private int id;
    private Account acc_id;
    private Stock stock;
    private int qty;
    private double price;

    public OrderBuy(int id, Account acc_id, Stock stock, int qty, double price) {
        this.id = id;
        this.acc_id = acc_id;
        this.stock = stock;
        this.qty = qty;
        this.price = price;
    }

    public OrderBuy() {
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

    @Override
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(OrderBuy o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.qty > o.getQty()) {
            return 1;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "OrderBuy{" +
                "acc_id=" + acc_id +
                ", stock=" + stock +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }



}
