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
import dao.implementTransaksi;
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
import object.iuran;
import object.pengeluaran;
import object.transaksi;
import object.user;

public class DAOMySqlTransaksi implements implementTransaksi {
    Connection connection;
    final String insert = "INSERT INTO transaksi (transaksi_id,transaksi_date,transaksi_nama,"
            + "transaksi_nominal,user_id,transaksi_tipe,iuran_id,pengeluaran_id) "
            + "VALUES (NULL,?,?,?,?,?,?,?);";
    final String update = "UPDATE transaksi SET transaksi_date=?, transaksi_nama=?, transaksi_nominal=?, "
            + "user_id=?, transaksi_tipe=?, iuran_id=?, pengeluaran_id=?  WHERE transaksi_id=?;";
    final String delete = "DELETE FROM transaksi WHERE transaksi_id=?;";
    final String select = "SELECT * FROM transaksi;";
    final String get = "SELECT * FROM transaksi WHERE transaksi_id=?;";
    final String getUser = "SELECT * FROM user WHERE user_id=?;";
    final String getIuran = "SELECT * FROM iuran WHERE iuran_id=?;";
    final String getPengeluaran = "SELECT * FROM pengeluaran WHERE pengeluaran_id=?;";
    final String cari = "SELECT * FROM transaksi WHERE transaksi_nama LIKE ?;";
    final String jumlahtransaksi = "SELECT sum(transaksi_nominal) as Jumlah FROM transaksi;";
    final String jumlahiuran = "SELECT sum(transaksi_nominal) as Jumlah FROM transaksi WHERE transaksi_tipe='iuran';";
    final String jumlahpengeluaran = "SELECT sum(transaksi_nominal) as Jumlah FROM transaksi WHERE transaksi_tipe='pengeluaran';";
    final String transaksiawal = "SELECT * FROM transaksi WHERE transaksi_date IN (SELECT MIN(transaksi_date) FROM transaksi WHERE user_id=? AND iuran_id=?) AND user_id=? AND iuran_id=?;";
    

    public DAOMySqlTransaksi() {
        connection = Koneksi.connection();
    }
    @Override
    public void insert(transaksi b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getTransaksi_Tanggal().toString());
            statement.setString(2, b.getTransaksi_Nama());
            statement.setDouble(3, b.getTransaksi_Nominal());
            statement.setInt(4, b.getUser_id());
            statement.setString(5, b.getTransaksi_tipe());
            statement.setInt(6, b.getIuran_id());
            statement.setInt(7, b.getPengeluaran_id());
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
    public transaksi get(int transaksi_id) {
        PreparedStatement statement = null;
        transaksi transaksi = new transaksi();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, transaksi_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               transaksi.setTransaksi_id(rs.getInt("transaksi_id"));
               transaksi.setTransaksi_Tanggal(rs.getString("transaksi_Tanggal"));
               transaksi.setTransaksi_Nama(rs.getString("transaksi_Nama"));
               transaksi.setTransaksi_Nominal(rs.getDouble("transaksi_Nominal"));
               transaksi.setUser_id(rs.getInt("user_id"));
               transaksi.setTransaksi_tipe(rs.getString("transaksi_tipe"));
               transaksi.setIuran_id(rs.getInt("iuran_id"));
               transaksi.setPengeluaran_id(rs.getInt("pengeluaran_id"));
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
        return transaksi;

    }

    @Override
    public void update(transaksi b) {
    PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getTransaksi_Tanggal().toString());
            statement.setString(2, b.getTransaksi_Nama());
            statement.setDouble(3, b.getTransaksi_Nominal());
            statement.setInt(4, b.getUser_id());
            statement.setString(5, b.getTransaksi_tipe());
            statement.setInt(6, b.getIuran_id());
            statement.setInt(7, b.getPengeluaran_id());
            statement.setInt(8, b.getTransaksi_id());
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
    public void delete(int transaksi_id) {
    PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, transaksi_id);
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
    public List<transaksi> getAll() {
    List<transaksi> lb = null;
        try {
            lb = new ArrayList<transaksi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
               transaksi b = new transaksi();
               b.setTransaksi_id(rs.getInt("transaksi_id"));
               b.setTransaksi_Tanggal(rs.getString("transaksi_Tanggal"));
               b.setTransaksi_Nama(rs.getString("transaksi_Nama"));
               b.setTransaksi_Nominal(rs.getDouble("transaksi_Nominal"));
               b.setUser_id(rs.getInt("user_id"));
               b.setTransaksi_tipe(rs.getString("transaksi_tipe"));
               b.setIuran_id(rs.getInt("iuran_id"));
               b.setPengeluaran_id(rs.getInt("pengeluaran_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;}

    @Override
    public List<transaksi> getCari(String Iuran_Nama) {
    List<transaksi> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + Iuran_Nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               transaksi b = new transaksi();
               b.setTransaksi_id(rs.getInt("transaksi_id"));
               b.setTransaksi_Tanggal(rs.getString("transaksi_Tanggal"));
               b.setTransaksi_Nama(rs.getString("transaksi_Nama"));
               b.setTransaksi_Nominal(rs.getDouble("transaksi_Nominal"));
               b.setUser_id(rs.getInt("user_id"));
               b.setTransaksi_tipe(rs.getString("transaksi_tipe"));
               b.setIuran_id(rs.getInt("iuran_id"));
               b.setPengeluaran_id(rs.getInt("pengeluaran_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;}

    @Override
    public user getUser(transaksi b) {
    PreparedStatement statement = null;
        user user = new user();
        try {
            statement = connection.prepareStatement(getUser);
            statement.setInt(1, b.getUser_id());
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
    public iuran getIuran(transaksi b) {
        PreparedStatement statement = null;
        iuran iuran = new iuran();
        try {
            statement = connection.prepareStatement(getIuran);
            statement.setInt(1, b.getIuran_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               iuran.setIuran_id(Integer.parseInt(rs.getString("iuran_id")));
               iuran.setIuran_Nama(rs.getString("iuran_Nama"));
               iuran.setIuran_Nominal(rs.getDouble("iuran_Nominal"));
               iuran.setIuran_Jenis_id(rs.getInt("iuran_Jenis_id"));
               iuran.setIuran_Kategori_id(rs.getInt("iuran_Kategori_id"));
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
        return iuran;
    }

    @Override
    public pengeluaran getPengeluaran(transaksi b) {
    PreparedStatement statement = null;
        pengeluaran pengeluaran = new pengeluaran();
        try {
            statement = connection.prepareStatement(getPengeluaran);
            statement.setInt(1, b.getPengeluaran_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               pengeluaran.setPengeluaran_id(rs.getInt("pengeluaran_id"));
               pengeluaran.setPengeluaran_Jenis_id(rs.getInt("pengeluaran_Jenis_id"));
               pengeluaran.setPengeluaran_Kategori_id(rs.getInt("pengeluaran_Kategori_id"));
               pengeluaran.setPengeluaran_Nama(rs.getString("pengeluaran_Nama"));
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
    public int getJumlahKas() {
        return getJumlahIuran() - getJumlahPengeluaran();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getJumlahIuran() {
        int iuran = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(jumlahiuran);
            rs.last();
            iuran = rs.getInt("Jumlah");
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iuran;
    }

    @Override
    public int getJumlahPengeluaran() {
        int pengeluaran = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(jumlahpengeluaran);
            rs.last();
            pengeluaran = rs.getInt("Jumlah");
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pengeluaran;
    }

    @Override
    public int getJumlahTransaksi() {
        int transaksi = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(jumlahtransaksi);
            rs.last();
            transaksi = rs.getInt("Jumlah");
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaksi;
        
    }
    
    @Override
    public transaksi getTransaksiPertama(String user_id, String iuran_id){
        PreparedStatement statement = null;
        transaksi transaksi = new transaksi();
        try {
            statement = connection.prepareStatement(transaksiawal);
            statement.setString(1, user_id);
            statement.setString(2, iuran_id);
            statement.setString(3, user_id);
            statement.setString(4, iuran_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               transaksi.setTransaksi_id(rs.getInt("transaksi_id"));
               transaksi.setTransaksi_Tanggal(rs.getString("transaksi_Tanggal"));
               transaksi.setTransaksi_Nama(rs.getString("transaksi_Nama"));
               transaksi.setTransaksi_Nominal(rs.getDouble("transaksi_Nominal"));
               transaksi.setUser_id(rs.getInt("user_id"));
               transaksi.setTransaksi_tipe(rs.getString("transaksi_tipe"));
               transaksi.setIuran_id(rs.getInt("iuran_id"));
               transaksi.setPengeluaran_id(rs.getInt("pengeluaran_id"));
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
        return transaksi;
    }

    @Override
    public int getUtang(int user_id, int iuran_id) {
        return 0;
    }

    @Override
    public int getTotalBayar(int user_id, int iuran_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTotalDibayar(int user_id, int iuran_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
   // public transaksi get(int transaksi_id) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
}

    

