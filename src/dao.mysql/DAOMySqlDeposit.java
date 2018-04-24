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
import dao.implementDeposit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;
import object.deposit;
import object.user;

public class DAOMySqlDeposit implements implementDeposit{
    Connection connection;
    final String insert = "INSERT INTO deposit (deposit_id,user_id,deposit_jumlah) VALUES (NULL,?,?);";
    final String update = "UPDATE deposit SET user_id=?, deposit_jumlah=? WHERE deposit_id=?;";
    final String delete = "DELETE FROM deposit WHERE deposit_id=?;";
    final String select = "SELECT * FROM deposit;";
    final String get = "SELECT * FROM deposit WHERE deposit_id=?;";
    final String getbyUser = "SELECT * FROM deposit WHERE user_id=?;";
    final String getUser = "SELECT * FROM user WHERE user_id=?;";
    final String cari = "SELECT * FROM deposit WHERE user_id LIKE ?;";

    public DAOMySqlDeposit() {
        connection = Koneksi.connection();
    }

    @Override
    public void insert(deposit b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, b.getUser_id());
            statement.setDouble(2, b.getDeposit_jumlah());
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
    public deposit get(int deposit_id) {
        PreparedStatement statement = null;
        deposit deposit = new deposit();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, deposit_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               deposit.setDeposit_id(rs.getInt("deposit_id"));
               deposit.setUser_id(rs.getInt("user_id"));
               deposit.setDeposit_jumlah(rs.getDouble("deposit_jumlah"));
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
        return deposit;
    }

    @Override
    public void update(deposit b) {
    PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setInt(1, b.getUser_id());
            statement.setDouble(2, b.getDeposit_jumlah());
            statement.setInt(3, b.getDeposit_id());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }}

    @Override
    public void delete(int deposit_id) {
    PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, deposit_id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }}

    @Override
    public List<deposit> getAll() {
    List<deposit> lb = null;
        try {
            lb = new ArrayList<deposit>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                deposit b = new deposit();
                b.setDeposit_id(rs.getInt("deposit_id"));
               b.setUser_id(rs.getInt("user_id"));
               b.setDeposit_jumlah(rs.getDouble("deposit_jumlah"));
               lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;}

    @Override
    public List<deposit> getCari(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public user getUser(deposit b) {
    PreparedStatement statement = null;
        user user = new user();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, b.getUser_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               user.setUser_id(rs.getInt("user_id"));
               user.setUser_Username(rs.getString("user_Username"));
               user.setUser_Password(rs.getString("user_Password"));
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
    public deposit getByUser(user b) {
    PreparedStatement statement = null;
        deposit deposit = new deposit();
        try {
            statement = connection.prepareStatement(getbyUser);
            statement.setInt(1, b.getUser_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               deposit.setDeposit_id(rs.getInt("deposit_id"));
               deposit.setUser_id(rs.getInt("user_id"));
               deposit.setDeposit_jumlah(rs.getDouble("deposit_jumlah"));
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
        return deposit;
    } 

    /*@Override
    public deposit get(int deposit_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int deposit_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<deposit> getCari(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
