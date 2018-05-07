/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.implementIuranJenis;
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
import object.iuran_jenis;

/**
 *
 * @author Setyawati
 */
public class DAOMySqlIuranJenis implements implementIuranJenis{

    Connection connection;
    final String insert = "INSERT INTO iuran_jenis (iuran_Jenis_id,iuran_Jenis_Nama) VALUES (NULL,?,?);";
    final String update = "UPDATE iuran_jenis SET iuran_Jenis_id=?, iuran_Jenis_Nama=? WHERE iuran_Jenis_id=?;";
    final String delete = "DELETE FROM iuran_jenis WHERE iuran_Jenis_id=?;";
    final String select = "SELECT * FROM iuran_jenis;";
    final String get = "SELECT * FROM iuran_jenis WHERE iuran_Jenis_id=?;";
    final String cari = "SELECT * FROM iuran_jenis WHERE iuran_Jenis_Nama LIKE ?;";

    public DAOMySqlIuranJenis() {
        connection = Koneksi.connection();
    }
    @Override
    public void insert(iuran_jenis b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getIuran_Jenis_Nama());
//            statement.setString(2, b.getIuran_JenisKeterangan());
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
    public iuran_jenis get(Integer iuran_Jenis_id) {
        PreparedStatement statement = null;
        iuran_jenis jenisIuran = new iuran_jenis();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, iuran_Jenis_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               jenisIuran.setIuran_Jenis_id(rs.getInt("iuran_Jenis_id"));
               jenisIuran.setIuran_Jenis_Nama(rs.getString("iuran_Jenis_Nama"));
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
    public void update(iuran_jenis b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getIuran_Jenis_Nama());
            statement.setString(3, Integer.toString(b.getIuran_Jenis_id()));
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
    public void delete(Integer iuran_Jenis_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, iuran_Jenis_id);
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
    public List<iuran_jenis> getAll() {
        List<iuran_jenis> lb = null;
        try {
            lb = new ArrayList<iuran_jenis>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                iuran_jenis b = new iuran_jenis();
                b.setIuran_Jenis_id(rs.getInt("iuran_Jenis_id"));
                b.setIuran_Jenis_Nama(rs.getString("iuran_Jenis_Nama"));
//                b.setIuranJenisKeterangan(rs.getString("iuran_jenis_keterangan"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<iuran_jenis> getCari(String iuran_Jenis_Nama) {
        List<iuran_jenis> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + iuran_Jenis_Nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                iuran_jenis b = new iuran_jenis();
                b.setIuran_Jenis_id(rs.getInt("iuran_Jenis_id"));
                b.setIuran_Jenis_Nama(rs.getString("iuran_Jenis_Nama"));
//                b.setIuranJenisKeterangan(rs.getString("iuran_jenis_keterangan"));
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
