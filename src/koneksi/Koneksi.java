/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

/**
 *
 * @author PC-14
 */
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Koneksi {

    static Connection con;
    private final static String DB_HOST = "localhost";
    private final static String DB_NAME = "perut_rt";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "root";
 
    public static Connection connection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName(DB_NAME);
            data.setUser(DB_USER);
            data.setPassword(DB_PASS);
            try {
                con = data.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }
    
    public static int isLogin(String user, String pass) {

        try {
//            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
//            Connection conn = DriverManager.
//                                getConnection("jdbc:mysql://"+DB_HOST+":3306/"
//                                        +DB_NAME+"?"
//                                        +"user="+DB_USER
//                                        +"&password="+DB_PASS);
            con = Koneksi.connection();
            PreparedStatement pst = con.prepareStatement("select * from user where user_Username=? and user_Password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}

