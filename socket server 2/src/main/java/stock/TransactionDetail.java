package stock;

public class TransactionDetail {
    int transid;
    int ordersellid;
    int orderbuyid;
    int stock_qty;
    double auc_price;

    public TransactionDetail (int transid, int ordersellid, int orderbuyid, int stock_qty, double auc_price ){
        this.transid = transid;
        this.ordersellid = ordersellid;
        this.orderbuyid = orderbuyid;
        this.stock_qty = stock_qty;
        this.auc_price = auc_price;
    }

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    public int getOrdersellid() {
        return ordersellid;
    }

    public void setOrdersellid(int ordersellid) {
        this.ordersellid = ordersellid;
    }

    public int getOrderbuyid() {
        return orderbuyid;
    }

    public void setOrderbuyid(int orderbuyid) {
        this.orderbuyid = orderbuyid;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public double getAuc_price() {
        return auc_price;
    }

    public void setAuc_price(double auc_price) {
        this.auc_price = auc_price;
    }
}
