/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.mysql;
import dao.implementPengeluaranKategori;
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
import object.pengeluaran_kategori;
/**
 *
 * @author Setyawati
 */
public class DAOMySqlPengeluaranKategori implements implementPengeluaranKategori {
    Connection connection;
    final String insert = "INSERT INTO pengeluaran_kategori (pengeluaran_kategori_id,pengeluaran_nama,pengeluaran_waktu) VALUES (NULL,?,?);";
    final String update = "UPDATE pengeluaran_kategori SET pengeluaran_kategori_id=?, pengeluaran_nama=?, pengeluaran_waktu=? WHERE pengeluaran_kategori_id=?;";
    final String delete = "DELETE FROM pengeluaran_kategori WHERE pengeluaran_kategori_id=?;";
    final String select = "SELECT * FROM pengeluaran_kategori;";
    final String get = "SELECT * FROM pengeluaran_kategori WHERE pengeluaran_kategori_id=?;";
    final String cari = "SELECT * FROM pengeluaran_kategori WHERE pengeluaran_nama LIKE ?;";

    public DAOMySqlPengeluaranKategori() {
        connection = Koneksi.connection();
    }
    @Override
    public void insert(pengeluaran_kategori b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getPengeluaran_Kategori_Nama());
            //statement.setString(2, Integer.toString(b.getPengeluaran_kategori_waktu()));
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
    public pengeluaran_kategori get(int pengeluaran_Kategori_id) {
        PreparedStatement statement = null;
        pengeluaran_kategori kategoriIuran = new pengeluaran_kategori();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, pengeluaran_Kategori_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               kategoriIuran.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
               kategoriIuran.setPengeluaran_Kategori_Nama(rs.getString("pengeluaran_Kategori_Nama"));
               //kategoriIuran.setPengeluaran_kategori_waktu(rs.getInt("pengeluaran_kategori_waktu"));
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
    public void update(pengeluaran_kategori b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getPengeluaran_Kategori_Nama());
            //statement.setString(2, Integer.toString(b.getPengeluaran_kategori_waktu()));
            statement.setString(3, Integer.toString(b.getPengeluaran_Kategori_id()));
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
    public void delete(int pengeluaran_Kategori_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, pengeluaran_Kategori_id);
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
    public List<pengeluaran_kategori> getAll() {
        List<pengeluaran_kategori> lb = null;
        try {
            lb = new ArrayList<pengeluaran_kategori>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                pengeluaran_kategori b = new pengeluaran_kategori();
                b.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                b.setPengeluaran_Kategori_Nama(rs.getString("pengeluaran_Kategori_Nama"));
                //b.setPengeluaran_kategori_waktu(rs.getInt("pengeluaran_kategori_waktu"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<pengeluaran_kategori> getCari(String pengeluaran_Kategori_Nama) {
        List<pengeluaran_kategori> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + pengeluaran_Kategori_Nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pengeluaran_kategori b = new pengeluaran_kategori();
                b.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
                b.setPengeluaran_Kategori_Nama(rs.getString("pengeluaran_Kategori_Nama"));
                //b.setPengeluaran_kategori_waktu(rs.getInt("pengeluaran_kategori_waktu"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
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

    /*@Override
    public pengeluaran_kategori get(int pengeluaran_Kategori_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int pengeluaran_Kategori_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}


