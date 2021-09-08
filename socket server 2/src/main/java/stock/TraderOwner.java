package stock;

import java.time.LocalDateTime;

public class TraderOwner {
    String acc_id;
    String stock_id;
    Double amount;
    int stock_qty;
    LocalDateTime update_time;


    public TraderOwner( String acc_id, String stock_id, Double amount, int stock_qty, LocalDateTime update_time) {
        this.acc_id = acc_id;
        this.stock_id = stock_id;
        this.amount = amount;
        this.stock_qty = stock_qty;
        this.update_time = update_time;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
}
