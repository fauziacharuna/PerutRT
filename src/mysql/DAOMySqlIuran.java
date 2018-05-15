package mysql;
/**
 *
 * @author Titis
 */
import dao.implementIuran;
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
import object.iuran_kategori;
import object.iuran_jenis;
//import object.TotalIuran;

public class DAOMySqlIuran implements implementIuran{
    Connection connection;
    final String insert = "INSERT INTO iuran (iuran_id, iuran_Nama, iuran_Nominal, iuran_Tanggal, iuran_Kategori_id, iuran_Jenis_id, iuran_Total) VALUES (NULL, ?, ?, ?, ?, ?, ?";
    final String update = "UPDATE iuran SET iuran_Nama=?, iuran_Nominal=?, iuran_Tanggal, iuran_Kategori_id=?, iuran_Jenis_id=?, iuran_Total=? WHERE iuran_id=?;";
    final String delete = "DELETE FROM iuran WHERE iuran_id=?;";
    final String select = "SELECT * FROM iuran;";
    final String get = "SELECT * FROM iuran WHERE iuran_id=?;";
    final String getIuranJenis = "SELECT * FROM iuran_jenis WHERE iuran_jenis_id=?;";
    final String getIuranKategori = "SELECT * FROM iuran_kategori WHERE iuran_kategori_id=?;";
    final String search = "SELECT * FROM iuran WHERE iuran_nama LIKE ?;";
    final String count = "COUNT ";
    
    public DAOMySqlIuran(){
        connection = Koneksi.connection();
    }
    
    @Override 
    public Integer insert(iuran b){
        PreparedStatement statement = null;
        int inserted_id = 0;
        try {
            statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getIuran_Nama());
            statement.setDouble(2, b.getIuran_Nominal());
            statement.setString(3, b.getIuran_Tanggal());
            statement.setInt(4, b.getIuran_Kategori_id());
            statement.setInt(5, b.getIuran_Jenis_id());
//            statement.setInt(6, b.getIuranTotal());
            //statement.executeUpdate();
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows == 0){
                throw new SQLException("Creating user failed, no rows affected.");
            }
            
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()){
                inserted_id = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
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
        return inserted_id;
    }
    
    @Override
    public iuran get(Integer Iuran_id) {
        PreparedStatement statement = null;
        iuran iuran = new iuran();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, Iuran_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                iuran.setIuran_id(Integer.parseInt(rs.getString("iuran_id")));
                iuran.setIuran_Nama(rs.getString("iuran_Nama"));
                iuran.setIuran_Nominal(rs.getDouble("iuran_Nominal"));
                iuran.setIuran_Tanggal(rs.getString("iuran_Tanggal"));
                iuran.setIuran_Kategori_id(rs.getInt("iuran_Kategori_Id"));
                iuran.setIuran_Jenis_id(rs.getInt("iuran_Jenis_Id"));
//                iuran.setIuranTotal(rs.getInt("iuran_Total"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return iuran;
    }
    
    @Override
    public void update(iuran b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getIuran_Nama());
            statement.setDouble(2, b.getIuran_Nominal());
            statement.setString(3, b.getIuran_Tanggal());
            statement.setInt(4, b.getIuran_Kategori_id());
            statement.setInt(5, b.getIuran_Jenis_id());
//            statement.setInt(6, b.getIuranTotal());
            statement.setString(5, Integer.toString(b.getIuran_id()));
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
    public void delete(Integer iuran_id){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, iuran_id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
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
    }
        
        @Override
        public List<iuran> getAll() {
            List<iuran> lb = null;
            try {
                lb = new ArrayList<iuran>();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(select);
                while (rs.next()) {
                    iuran b = new iuran();
                    b.setIuran_id(rs.getInt("iuran_id"));
                    b.setIuran_Nama(rs.getString("iuran_Nama"));
                    b.setIuran_Nominal(rs.getDouble("iuran_Nominal"));
                    b.setIuran_Tanggal(rs.getString("iuran_Tanggal"));
                    b.setIuran_Kategori_id(rs.getInt("iuran_Kategori_Id"));
                    b.setIuran_Jenis_id(rs.getInt("iuran_Jenis_Id"));
//                    b.setIuranTotal(rs.getInt("iuran_Total"));
                    lb.add(b);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lb;
    }
        
        @Override
        public List<iuran> getCari(String iuran_Nama) {
            List<iuran> lb = null;
            try {
                lb = new ArrayList<>();
                PreparedStatement st = connection.prepareStatement(search);
                st.setString(1, "%" + iuran_Nama + "%");
                ResultSet rs = st.executeQuery();
                while (rs.next()); {
                iuran b = new iuran();
                b.setIuran_id(rs.getInt("iuran_id"));
                b.setIuran_Nama(rs.getString("iuran_Nama"));
                b.setIuran_Nominal(rs.getDouble("iuran_Nominal"));
                b.setIuran_Tanggal(rs.getString("iuran_Tanggal"));
                b.setIuran_Kategori_id(rs.getInt("iuran_Kategori_id"));
                b.setIuran_Jenis_id(rs.getInt("iuran_Jenis_Id"));
//                b.setIuranTotal(rs.getInt("iuran_Total"));
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
    public iuran_jenis getIuranJenis(iuran b) {
        PreparedStatement statement = null;
        iuran_jenis jenisIuran = new iuran_jenis();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, b.getIuran_Jenis_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                jenisIuran.setIuran_Jenis_id(rs.getInt("iuran_Jenis_id"));
                jenisIuran.setIuran_Jenis_Nama(rs.getString("iuran_Jenis_Nama"));
               }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jenisIuran;
    }
    
    @Override
    public iuran_kategori getIuranKategori(iuran b) {
        PreparedStatement statement = null;
        iuran_kategori kategoriIuran = new iuran_kategori();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, b.getIuran_Jenis_id());
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                kategoriIuran.setIuran_Kategori_id(rs.getInt("Iuran_Kategori_id"));
                kategoriIuran.setIuran_Kategori_Nama(rs.getString("Iuran_Kategori_Nama"));
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
}

