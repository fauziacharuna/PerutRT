/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;

/**
 *
 * @author Titis
 */

import dao.implementIuranKategori;
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
import object.iuran_kategori;

public class DAOMySqlIuranKategori implements implementIuranKategori {
    
    Connection connection;
    final String insert = "INSERT INTO iuran_Kategori (iuran_Kategori_id, iuran_Kategori_Nama, iuran_id) VALUES (NULL,?,?);";
    final String update = "UPDATE iuran_Kategori SET iuran_Kategori_id=?, iuran_Kategori_Nama=?, iuran_id=? WHERE iuran_Kategori_id=?;";
    final String delete = "DELETE FROM iuran_Kategori WHERE iuran_Kategori_id=?;";
    final String select = "SELECT * FROM iuran_Kategori;";
    final String get = "SELECT * FROM iuran_Kategori WHERE iuran_Kategori_id=?;";
    final String search = "SELECT * FROM iuran_Kategori WHERE iuran_Kategori_Nama LIKE ?;";
    
    public DAOMySqlIuranKategori() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(iuran_kategori b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getIuran_Kategori_Nama());
            statement.setInt(2, b.getIuran_Kategori_id());
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
    public iuran_kategori get(Integer Iuran_Kategori_id) {
        PreparedStatement statement = null;
        iuran_kategori kategoriIuran = new iuran_kategori();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, Iuran_Kategori_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                kategoriIuran.setIuran_Kategori_id(rs.getInt("iuran_Kategori_id"));
                kategoriIuran.setIuran_Kategori_Nama(rs.getString("iuran_Kategori_Nama"));
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
        return kategoriIuran;
    }
    
    @Override
    public void update(iuran_kategori b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getIuran_Kategori_Nama());
            statement.setString(3, Integer.toString(b.getIuran_Kategori_id()));
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
    public void delete(Integer Iuran_Kategori_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, Iuran_Kategori_id);
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
    public List<iuran_kategori> getAll() {
        List<iuran_kategori> lb = null;
        try {
            lb = new ArrayList<iuran_kategori>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                iuran_kategori b = new iuran_kategori();
                b.setIuran_Kategori_id(rs.getInt("iuran_Kategori_id"));
                b.setIuran_Kategori_Nama(rs.getString("iuran_Kategori_Nama"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
     @Override
     public List<iuran_kategori> getCari(String iuran_Kategori_Nama) {
         List<iuran_kategori> lb = null;
         try {
             lb = new ArrayList<>();
             PreparedStatement st = connection.prepareStatement(search);
             st.setString(1, "%" +iuran_Kategori_Nama + "%");
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                 iuran_kategori b = new iuran_kategori();
                 b.setIuran_Kategori_id(rs.getInt("iuran_Kategori_id"));
                 b.setIuran_Kategori_Nama(rs.getString("iuran_Kategori_Nama"));
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

