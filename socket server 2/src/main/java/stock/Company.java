package stock;

public class Company {
    String comabbr;
    String comname;
    String comaddress;
    String comphone;
    String comemail;
    String stkreleasedate;
    String stkreleaseprice;
    String chartercapital;


    public Company(    String comabbr, String comname, String comaddress, String comphone,
                       String comemail, String stkreleasedate,
                       String stkreleaseprice,
                       String chartercapital) {
        this.comabbr = comabbr;
        this.comname = comname;
        this.comaddress = comaddress;
        this.comphone = comphone;
        this.comemail = comemail;
        this.stkreleasedate = stkreleasedate;
        this.stkreleaseprice = stkreleaseprice;
        this.chartercapital = chartercapital;
    }

    public String getComabbr() {
        return comabbr;
    }

    public void setComabbr(String comabbr) {
        this.comabbr = comabbr;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone;
    }

    public String getComemail() {
        return comemail;
    }

    public void setComemail(String comemail) {
        this.comemail = comemail;
    }

    public String getStkreleasedate() {
        return stkreleasedate;
    }

    public void setStkreleasedate(String stkreleasedate) {
        this.stkreleasedate = stkreleasedate;
    }

    public String getStkreleaseprice() {
        return stkreleaseprice;
    }

    public void setStkreleaseprice(String stkreleaseprice) {
        this.stkreleaseprice = stkreleaseprice;
    }

    public String getChartercapital() {
        return chartercapital;
    }

    public void setChartercapital(String chartercapital) {
        this.chartercapital = chartercapital;
    }
}
