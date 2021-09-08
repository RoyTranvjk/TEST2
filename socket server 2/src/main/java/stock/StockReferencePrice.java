package stock;

public class StockReferencePrice {
    String stock;
    String reftime;
    Double refprice;
    Double ceprice;
    Double flprice;

    public StockReferencePrice ( String stock, String reftime, Double refprice, Double ceprice, Double flprice) {
        this.stock = stock;
        this.reftime = reftime;
        this.refprice = refprice;
        this.ceprice = ceprice;
        this.flprice = flprice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getReftime() {
        return reftime;
    }

    public void setReftime(String reftime) {
        this.reftime = reftime;
    }

    public Double getRefprice() {
        return refprice;
    }

    public void setRefprice(Double refprice) {
        this.refprice = refprice;
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
