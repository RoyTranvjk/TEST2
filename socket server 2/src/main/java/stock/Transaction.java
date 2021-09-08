package stock;

import java.time.LocalDateTime;

public class Transaction {
    int transid;
    LocalDateTime create_time;

    public Transaction ( int transid,LocalDateTime create_time  ) {
        this.transid = transid;
        this.create_time = create_time;
    }

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }
}