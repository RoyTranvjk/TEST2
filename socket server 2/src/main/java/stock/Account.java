package stock;

public class Account {
    String acc_id;
    String fname;
    String lname;
    String address;
    String phone;
    String email;
    String username;
    String pass;
    String acctype;

    public Account(String id, String username) {
        this.acc_id = id;
        this.username = username;
    }

    public Account(String acc_id) {
        this.acc_id = acc_id;
    }

    public Account(String acc_id, String fname, String lname, String address, String phone,
                   String email, String username, String pass, String acctype) {
        this.acc_id = acc_id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.acctype = acctype;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_id='" + acc_id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
