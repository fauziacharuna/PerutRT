/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

/**
 *
 * @author Titis
 */

import dao.implementIuranPerubahan;
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
import object.iuran_perubahan;

public class DAOMySqlIuranPerubahan implements implementIuranPerubahan {
    
    Connection connection;
    final String insert = "INSERT INTO iuran_perubahan (iuran_Perubahan_id, iuran_Perubahan_Nama, iuran_id) VALUES (NULL,?,?);";
    final String update = "UPDATE iuran_perubahan SET iuran_Perubahan_id=?, iuran_Perubahan_Nama=?, iuran_id=? WHERE iuran_Perubahan_id=?;";
    final String delete = "DELETE FROM iuran_perubahan WHERE iuran_Perubahan_id=?;";
    final String select = "SELECT * FROM iuran_perubahan;";
    final String get = "SELECT * FROM iuran_perubahan WHERE iuran_Perubahan_id=?;";
    final String search = "SELECT * FROM iuran_perubahan WHERE iuran_Perubahan_Nama LIKE ?;";
    
    public DAOMySqlIuranPerubahan() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(iuran_perubahan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getIuran_Perubahan_Nama());
            statement.setInt(2, b.getIuran_Perubahan_id());
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
    public iuran_perubahan get(Integer Iuran_Perubahan_id) {
        PreparedStatement statement = null;
        iuran_perubahan perubahanIuran = new iuran_perubahan();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, Iuran_Perubahan_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                perubahanIuran.setIuran_Perubahan_id(rs.getInt("iuran_Perubahan_id"));
                perubahanIuran.setIuran_Perubahan_Nama(rs.getString("iuran_Perubahan_Nama"));
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
        return perubahanIuran;
    }
    
    @Override
    public void update(iuran_perubahan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getIuran_Perubahan_Nama());
            statement.setString(3, Integer.toString(b.getIuran_Perubahan_id()));
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
    public void delete(Integer Iuran_Perubahan_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, Iuran_Perubahan_id);
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
    public List<iuran_perubahan> getAll() {
        List<iuran_perubahan> lb = null;
        try {
            lb = new ArrayList<iuran_perubahan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                iuran_perubahan b = new iuran_perubahan();
                b.setIuran_Perubahan_id(rs.getInt("iuran_Perubahan_id"));
                b.setIuran_Perubahan_Nama(rs.getString("iuran_Perubahani_Nama"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
     @Override
     public List<iuran_perubahan> getCari(String iuran_Perubahan_Nama) {
         List<iuran_perubahan> lb = null;
         try {
             lb = new ArrayList<>();
             PreparedStatement st = connection.prepareStatement(search);
             st.setString(1, "%" +iuran_Perubahan_Nama + "%");
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                 iuran_perubahan b = new iuran_perubahan();
                 b.setIuran_Perubahan_id(rs.getInt("iuran_Perubahan_id"));
                 b.setIuran_Perubahan_Nama(rs.getString("iuran_Perubahan_Nama"));
                 lb.add(b);
             }
         } catch (SQLException ex) {
             Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lb;
     }
     
     @Override
     public Integer getCount() {
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

}
