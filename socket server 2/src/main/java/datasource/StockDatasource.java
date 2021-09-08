package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class StockDatasource {

    private static final String url = "jdbc:mysql://localhost:3306/stockexchange";
    private static final String pass = "Hanoi2021@";
    private static final String user = "root";
    private static Connection con;


    public StockDatasource() {
    }


    public static Connection getConnection() {
        try {

            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            }


//            System.out.println("connection success");

        } catch (ClassNotFoundException e) {
            System.out.println("loi");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }


    // Select du lieu do ra ArrayList
//    public ArrayList<SinhVien> ResultArrList(String sql){
//        ArrayList<SinhVien> arrL = new ArrayList<SinhVien>();
//        try {
//            if(con == null || con.isClosed()){
//                ketNoi();
//            }
//            ResultSet kq = stmt.executeQuery(sql);
//            try{
//                while(kq.next()){
//                    arrL.add(new SinhVien(kq.getString("tenSV"),kq.getString("ngaysinh"),kq.getString("quequan"),kq.getFloat("diemTb")));
//                }
//            } catch(Exception e){
//                System.out.println(e);
//            }
//            return arrL;
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//        return null;
//    }
//    // Insert
//    public boolean addSinhVien(SinhVien a){
//        String sql = "insert into sinhvien values(\""+ a.getHoTen()+"\",\""+a.getNgaySinh()+"\",\""+a.getQueQuan()+"\","+a.getDiemTB()+")";
//        //System.out.println(sql);
//        try{
//            if(con == null || con.isClosed()){
//                ketNoi();
//            }
//            stmt.execute(sql);
//        }catch(Exception e){
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
//    public boolean deleteSV(String name){
//        String sql = "delete from sinhvien where tensv =\""+name+"\"";
//        // System.out.println(sql);
//        try{
//            if(con == null || con.isClosed()){
//                ketNoi();
//            }
//            stmt.execute(sql);
//        }catch(Exception e){
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
//
//    public boolean suaSV(SinhVien a){
//        String sql = "update sinhvien set ngaysinh= \""+a.getNgaySinh()+"\" ,quequan = \""+a.getQueQuan()+"\" ,DiemTB = \""+a.getDiemTB()+"\" where tensv = \""+a.getHoTen()+"\"";
//        try{
//            if(con == null || con.isClosed()){
//                ketNoi();
//            }
//            stmt.execute(sql);
//            return true;
//        } catch(SQLException e){
//            System.out.println(e);
//        }
//        return false;
//    }


    public void closeConnect() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
            ;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
