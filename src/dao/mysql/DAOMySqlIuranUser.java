/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.implementIuranUser;
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
import object.iuran_user;
import object.user;

/**
 *
 * @author Setyawati
 */
public class DAOMySqlIuranUser implements implementIuranUser{
    Connection connection;
    final String insert = "INSERT INTO iuran_user (iuran_user_id,iuran_User_Status,user_id,iuran_id) VALUES (NULL,?,?,?);";
    final String update = "UPDATE iuran_user SET iuran_User_Status=?, user_id=?, iuran_id=? WHERE iuran_user_id=?;";
    final String delete = "DELETE FROM iuran_user WHERE iuran_user_id=?;";
    final String select = "SELECT * FROM iuran_user;";
    final String get = "SELECT * FROM iuran_user WHERE iuran_user_id=?;";
    final String getByUserAndIuran = "SELECT * FROM iuran_user WHERE user_id=? AND iuran_id=?;";
    final String getUser = "SELECT * FROM user WHERE user_id=?;";
    final String getIuran = "SELECT * FROM iuran WHERE iuran_id=?;";
    final String cari = "SELECT * FROM iuran_user WHERE user_id LIKE ?;";

    public DAOMySqlIuranUser() {
        connection = Koneksi.connection();
    }

    @Override
    public void insert(iuran_user b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, b.getIuran_User_Status());
            statement.setInt(2, b.getUser_id());
            statement.setInt(3, b.getIuran_id());
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
    public iuran_user get(Integer iuran_User_id) {
        PreparedStatement statement = null;
        iuran_user iuranUser = new iuran_user();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, iuran_User_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               iuranUser.setIuran_User_id(rs.getInt("iuran_User_id"));
               iuranUser.setIuran_User_Status(rs.getInt("iuran_User_Status"));
               iuranUser.setUser_id(rs.getInt("user_id"));
               iuranUser.setIuran_id(rs.getInt("iuran_id"));
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
        return iuranUser;
    }

    @Override
    public void update(iuran_user b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setInt(1, b.getIuran_User_Status());
            statement.setInt(2, b.getUser_id());
            statement.setInt(3, b.getIuran_id());
            statement.setString(4, Integer.toString(b.getIuran_User_id()));
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
    public void delete(Integer iuran_User_id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, iuran_User_id);
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
    public List<iuran_user> getAll() {
        List<iuran_user> lb = null;
        try {
            lb = new ArrayList<iuran_user>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                iuran_user b = new iuran_user();
                b.setIuran_User_id(rs.getInt("iuran_User_id"));
                b.setIuran_User_Status(rs.getInt("iuran_User_Status"));
                b.setUser_id(rs.getInt("user_id"));
                b.setIuran_id(rs.getInt("iuran_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<iuran_user> getCari(Integer user_id) {
        List<iuran_user> lb = null;
        try {
            lb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + user_id + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                iuran_user b = new iuran_user();
                b.setIuran_User_id(rs.getInt("iuran_User_id"));
                b.setIuran_User_Status(rs.getInt("iuran_User_Status"));
                b.setUser_id(rs.getInt("user_id"));
                b.setIuran_id(rs.getInt("iuran_id"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMySqlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public user getUser(iuran_user b) {
        PreparedStatement statement = null;
        user user = new user();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, b.getUser_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               user.setUser_id(rs.getInt("user_id"));
               user.setUser_Username(rs.getString("user_Username"));
//               user.setUser_displayname(rs.getString("user_displayname"));
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
    public iuran getIuran(iuran_user b) {
        PreparedStatement statement = null;
        iuran iuran = new iuran();
        try {
            statement = connection.prepareStatement(get);
            statement.setInt(1, b.getIuran_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               iuran.setIuran_id(rs.getInt("iuran_id"));
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
    public iuran_user getByUserAndIuran(user u, iuran i) {
        PreparedStatement statement = null;
        iuran_user iuranUser = new iuran_user();
        try {
            statement = connection.prepareStatement(getByUserAndIuran);
            statement.setInt(1, u.getUser_id());
            statement.setInt(2, i.getIuran_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               iuranUser.setIuran_User_id(rs.getInt("iuran_User_id"));
               iuranUser.setIuran_User_Status(rs.getInt("iuran_User_Status"));
               iuranUser.setUser_id(rs.getInt("user_id"));
               iuranUser.setIuran_id(rs.getInt("iuran_id"));
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
        return iuranUser;
    }

    @Override
    public List<iuran_user> getBelumLunas(user b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
