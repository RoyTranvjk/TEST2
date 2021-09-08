package stock;


import java.util.ArrayDeque;

public class Admin extends Account {
/*
 * To do list: kết nối với System Server để thực hiện những công việc sau 1.
 * Quản lý danh mục người dùng: thêm người dùng, sửa thông tin người dùng 2.
 * Quản lý doanh nghiệp: thêm doanh nghiệp, sửa thông tin doanh nghiệp 3. Quản
 * lý cổ phiếu: thêm cổ phiếu, sửa thông tin cổ phiếu 4. Các thao tác thống kê
 */
    public Admin(String acc_id, String fname, String lname, String address, String phone, String email, String username, String pass, String acctype) {
        super(acc_id, fname, lname, address, phone, email, username, pass, acctype);
    }
}
