/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;

import dao.implementPengeluaranJenis;
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
import object.pengeluaran_jenis;
/**
 *
 * @author Setyawati
 */
public class DAOMySqlPengeluaranJenis implements implementPengeluaranJenis{
    Connection connection;
    final String insert = "INSERT INTO pengeluaran_jenis (pengeluaran_Jenis_id,pengeluaran_nama) VALUES (NULL,?,?);";
    final String update = "UPDATE pengeluaran_jenis SET pengeluaran_Jenis_id=?, pengeluaran_nama=?, WHERE pengeluaran_Jenis_id=?;";
    final String delete = "DELETE FROM pengeluaran_jenis WHERE pengeluaran_Jenis_id=?;";
    final String select = "SELECT * FROM pengeluaran_jenis;";
    final String get = "SELECT * FROM pengeluaran_jenis WHERE pengeluaran_Jenis_id=?;";
    final String cari = "SELECT * FROM pengeluaran_jenis WHERE pengeluaran_Nama LIKE ?;";

    public DAOMySqlPengeluaranJenis() {
        connection = Koneksi.connection();
    }
    @Override
    public void insert(pengeluaran_jenis b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getPengeluaran_Jenis_Nama());
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
    public pengeluaran_jenis get(Integer pengeluaran_Jenis_id) {
        PreparedStatement statement = null;
        pengeluaran_jenis jenisIuran = new pengeluaran_jenis();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, pengeluaran_Jenis_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               jenisIuran.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
               jenisIuran.setPengeluaran_Jenis_Nama(rs.getString("pengeluaran_Jenis_Nama"));
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
        return jenisIuran;
    }

    @Override
    public void update(pengeluaran_jenis b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getPengeluaran_Jenis_Nama());
            statement.setString(3, Integer.toString(b.getPengeluaran_Jenis_id()));
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
    public void delete(Integer pengeluaran_Jenis_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, pengeluaran_Jenis_id);
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
    public List<pengeluaran_jenis> getAll() {
        List<pengeluaran_jenis> lb = null;
        try {
            lb = new ArrayList<pengeluaran_jenis>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                pengeluaran_jenis b = new pengeluaran_jenis();
                b.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
                b.setPengeluaran_Jenis_Nama(rs.getString("pengeluaran_Jenis_Nama"));
                //b.setPengeluaran_keterangan(rs.getString("pengeluaran_keterangan"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<pengeluaran_jenis> getCari(String pengeluaran_Jenis_Nama) {
        List<pengeluaran_jenis> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + pengeluaran_Jenis_Nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pengeluaran_jenis b = new pengeluaran_jenis();
                b.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
                b.setPengeluaran_Jenis_Nama(rs.getString("pengeluaran_Jenis_Nama"));
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


