/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.dao;

import dao.implementUser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.user;

/**
 *
 * @author fauziachmadharuna
 */
public class DAORestUser implements implementUser{
    private List<user> listUser;
    public static String alamat = "http://localhost/perut-server/index.php/user";

    public DAORestUser() {
//        populateUser();
    }

    @Override
    public Integer insert(user b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public user getUser(Integer user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(user b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<user> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<user> getCari(String user_Username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getValidLogin(String username, String password) {
int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=getLogin&username="+username+"&password="+password);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
//            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//            }

            //ini ambil output data lalu dimasukkan ke string response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            String response = null;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                response = output;
            }

            jumlah = Integer.valueOf(response.replace(" ", ""));
            //System.out.println("Jumlah utang: "+jumlah);

            conn.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(dao.Rest.DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(dao.Rest.DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dao.Rest.DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;   
    }

  
}
