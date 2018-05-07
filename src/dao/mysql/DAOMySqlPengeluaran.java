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
import dao.implementPengeluaran;
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
import object.pengeluaran;
import object.pengeluaran_jenis;
import object.pengeluaran_kategori;

public class DAOMySqlPengeluaran implements implementPengeluaran{
    Connection connection;
    final String insert = "INSERT INTO pengeluaran (pengeluaran_id, pengeluaran_Nama, pengeluaran Nominal, pengeluaran_Tanggal, pengeluaran_Kategori_id, pengeluaran_Jenis_id) VALUES (NULL, ?, ?, ?, ?, ?);";
    final String update = "UPDATE pengeluaran SET pengeluaran_Nama=?, pengeluaran_Nominal=?, pengeluaran_Tanggal=?, pengeluaran_Kategori_id=?, pengeluaran_Jenis_id=? WHERE pengeluaran_id=?;";
    final String delete = "DELETE FROM pengeluaran WHERE pengeluaran_id;";
    final String select = "SELECT * FROM pengeluaran;";
    final String get = "SELECT * FROM pengeluaran WHERE pengeluaran_id=?;";
    final String getPengeluaranKategori = "SELECT * FROM pengeluaran WHERE pengeluaran_Kategori_id=?;";
    final String getPengeleuaranJenis = "SELECT * FROM pengeluaran WHERE pengeluaran_Jenis-id=?;";
    final String search = "SELECT * FROM pengeluaran WHERE pengeluaran_Nama LIKE ?;";
    
    public DAOMySqlPengeluaran() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(pengeluaran b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getPengeluaran_Nama());
            statement.setDouble(2, b.getPengeluaran_Nominal());
            statement.setInt(3, b.getPengeluaran_Kategori_id());
            statement.setInt(4, b.getPengeluaran_Jenis_id());
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
    public pengeluaran get(Integer pengeluaran_id ) {
        PreparedStatement statement = null;
        pengeluaran pengeluaran = new pengeluaran();
        try { 
            statement = connection.prepareStatement(get);
            statement.setInt(1, pengeluaran_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                pengeluaran.setPengeluaran_id(Integer.parseInt(rs.getString("pengeluaran_id")));
                pengeluaran.setPengeluaran_Nama(rs.getString("pengeluaran_Nama"));
                pengeluaran.setPengeluaran_Nominal(rs.getDouble("pengeluaran_Nominal"));
                pengeluaran.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                pengeluaran.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
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
        return pengeluaran;
    }
    
    @Override
    public void update(pengeluaran b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getPengeluaran_Nama());
            statement.setDouble(2, b.getPengeluaran_Nominal());
            statement.setInt(3, b.getPengeluaran_Kategori_id());
            statement.setInt(4, b.getPengeluaran_Jenis_id());
            statement.setString(5, Integer.toString(b.getPengeluaran_id()));
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
    public void delete(Integer Pengeluaran_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, Pengeluaran_id);
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
    public List<pengeluaran> getAll() {
        List<pengeluaran> lb = null;
        try {
            lb = new ArrayList<pengeluaran>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                pengeluaran b = new pengeluaran();
                b.setPengeluaran_id(rs.getInt("pengeluaran_id"));
                b.setPengeluaran_Nama(rs.getString("pengeluaran_Nama"));
                b.setPengeluaran_Nominal(rs.getDouble("pengeluaran_Nominal"));
                b.setPengeluaran_Tanggal(rs.getString("pengeluaran_Tanggal"));
                b.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                b.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName());
        }
        return lb;
    }
    
    @Override
    public List<pengeluaran> getCari(String pengeluaran_Nama) {
        List<pengeluaran> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(search);
            st.setString(1, "%" + pengeluaran_Nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pengeluaran b = new pengeluaran();
                b.setPengeluaran_id(rs.getInt("pengeluaran_id"));
                b.setPengeluaran_Nama(rs.getString("pengeluaran_Nama"));
                b.setPengeluaran_Nominal(rs.getDouble("pengeluaran_Nominal"));
                b.setPengeluaran_Tanggal(rs.getString("pengeluaran_Tanggal"));
                b.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                b.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
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
        
        @Override
        public pengeluaran_jenis getPengeluaranJenis(pengeluaran b) {
            PreparedStatement statement = null;
            pengeluaran_jenis jenisPengeluaran = new pengeluaran_jenis();
            try {
                statement = connection.prepareStatement(get);
                statement.setInt(1, b.getPengeluaran_Jenis_id());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    jenisPengeluaran.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
                    jenisPengeluaran.setPengeluaran_Jenis_Nama(rs.getString("pengeluaran_Nama"));
                    jenisPengeluaran.setPengeluaran_id(rs.getInt("pengeluaran_id"));
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
            return jenisPengeluaran;
        }
        
        @Override
        public pengeluaran_kategori getPengeluaranKategori(pengeluaran b) {
            PreparedStatement statement = null;
            pengeluaran_kategori kategoriPengeluaran = new pengeluaran_kategori();
            try {
                statement = connection.prepareStatement(get);
                statement.setInt(1, b.getPengeluaran_Jenis_id());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    kategoriPengeluaran.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                    kategoriPengeluaran.setPengeluaran_Kategori_Nama(rs.getString("pengeluaran_Kategori_Nama"));
                    kategoriPengeluaran.setPengeluaran_id(rs.getInt("pengeluaran_id"));
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
            return kategoriPengeluaran;
        }

    private int pengeluaran_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
