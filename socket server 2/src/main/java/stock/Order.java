package stock;

import java.util.Comparator;

public abstract class Order {

    public abstract void setStock(Stock stock);

    public abstract void setPrice(double randomMoney);

    public abstract void setQty(int randomQty);

    public abstract void setAccount(Account acc);

}
