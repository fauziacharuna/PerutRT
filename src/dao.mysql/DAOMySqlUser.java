/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.mysql;

/**
 *
 * @author Setyawati
 */
import dao.implementUser;
import koneksi.Koneksi;
import object.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMySqlUser implements implementUser{
    Connection connection;
    final String insert = "INSERT INTO user (user_id,user_Username,user_displayname,user_Password,user_Tipe_User) VALUES (NULL,?,?,?,?);";
    final String update = "UPDATE user SET user_Username=?, user_displayname=?, user_password=?, user_tipe=? WHERE user_id=?;";
    final String delete = "DELETE FROM user WHERE user_id=?;";
    final String select = "SELECT * FROM user;";
    final String get = "SELECT * FROM user WHERE user_id=?;";
    final String cari = "SELECT * FROM user WHERE user_displayname LIKE ?;";

    public DAOMySqlUser() {
        connection = Koneksi.connection();
    }

    @Override
    public int insert(user b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getUser_Username());
            statement.setString(3, b.getUser_Password());
            statement.setString(4, b.getUser_Tipe_User());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 1;
    }
    
    @Override
    public void update(user b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getUser_Username());
            statement.setString(3, b.getUser_Password());
            statement.setString(4, b.getUser_Tipe_User());
            statement.setString(5, Integer.toString(b.getUser_id()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int user_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, user_id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<user> getAll() {
        List<user> lb = null;
        try {
            lb = new ArrayList<user>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                user b = new user();
                b.setUser_id(Integer.parseInt(rs.getString("user_id")));
                b.setUser_Username(rs.getString("user_Username"));
                b.setUser_Password(rs.getString("user_Password"));
                b.setUser_Tipe_User(rs.getString("user_Tipe_User"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<user> getCari(String user_id) {
        List<user> lb = null;
        try {
            lb = new ArrayList<user>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + user_id + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user b = new user();
                b.setUser_id(Integer.parseInt(rs.getString("user_id")));
                b.setUser_Username(rs.getString("user_Username"));
                b.setUser_Password(rs.getString("user_Password"));
                b.setUser_Tipe_User(rs.getString("user_Tipe_User"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public user getUser(int user_id) {
    PreparedStatement statement = null;
    user user = new user();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, user_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               user.setUser_id(Integer.parseInt(rs.getString("user_id")));
               user.setUser_Username(rs.getString("user_Username"));
               user.setUser_Password(rs.getString("user_Password"));
               user.setUser_Tipe_User(rs.getString("user_Tipe_User"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
        return user;
    }

    @Override
    public int getCount() {
        int lb = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            rs.last();
            lb = rs.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public int getValidLogin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public user getUser(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

