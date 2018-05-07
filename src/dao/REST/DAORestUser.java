/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Rest;

import dao.implementUser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.user;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Setyawati
 */
public class DAORestUser implements implementUser {
    
    private List<user> listUser;
    public static String alamat = "http://localhost/siput-server/index.php/users";

    public DAORestUser() {
        populateUser();
    }

    @Override
    public Integer getValidLogin(String username, String password){
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
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }
    @Override 
    public Integer insert(user b) {
        int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters  = "username="+b.getUser_Username()+
//                    "&displayname="+b.getUser_displayname()+
                    "&password="+b.getUser_Password()+
                    "&alamat="+b.getUser_Alamat()+
                    "&ktp="+b.getUser_KTP()+
                    "&tgl_lahir="+b.getUser_Tanggal_lahir()+
                    "&tipe="+b.getUser_Tipe_User();
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;   
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
               wr.write( postData );
            }

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
            //ini ambil output data lalu dimasukkan ke string response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            String response = null;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                response = response+output;
            }
            
            //ini parsing data output menggunakan jsoup, diambil id nya
            Document d = Jsoup.parse(response);
            Elements tables = d.select("table > tbody > tr > td");
            Element e = tables.first();
            System.out.println(e.text());
            id = Integer.valueOf(e.text());
            
            conn.disconnect();
            populateUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return id;
    }

    public void populateUser() {
        listUser = new ArrayList<>();
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            char[] buffer = new char[1024];
            StringBuilder sb = new StringBuilder();
            Reader in = new InputStreamReader(conn.getInputStream());
            while (true) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0) {
                    break;
                }
                sb.append(buffer, 0, rsz);
            }
            JSONParser jp = new JSONParser();
            JSONArray json = (JSONArray) jp.parse(sb.toString());
            listUser.clear();
            for (int i = 0; i < json.size(); i++) {
                
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                System.out.println(jo.get("user_username").toString());
                listUser.add(new user(Integer.valueOf(jo.get("user_id").toString()), 
                        Integer.valueOf(jo.get("deposit_id").toString()),
                        String.valueOf(jo.get("user_Username").toString()),
                        String.valueOf(jo.get("user_Nama_Lengkap").toString()), 
                        String.valueOf(jo.get("user_Password").toString()),
                        String.valueOf(jo.get("user_Gender").toString()),
                        String.valueOf(jo.get("user_Tipe_User").toString()),
                        String.valueOf(jo.get("user_KTP").toString()),
                        String.valueOf(jo.get("user_Alamat").toString()),
                        String.valueOf(jo.get("user_email").toString()),
                        String.valueOf(jo.get("user_NoHP").toString()),
                        String.valueOf(jo.get("user_Tanggal_lahir").toString())));
        }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public user getUser(Integer user_id) {
        populateUser();
        user user = null;
        for (user _user : listUser) {
            if (Integer.valueOf(_user.getUser_id()).equals(user_id)) {
                user = _user;
            }
        }
        return user;
    }

    @Override
    public void update(user b) {
        try {
            URL url = new URL(alamat+"?id="+b.getUser_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input = "{"
                    + "\"username\":\"" + b.getUser_Username()
                    + "\",\"password\":\"" + b.getUser_Password()
                    + "\",\"tipe\":\"" + b.getUser_Tipe_User()
                    + "\",\"alamat\":\"" + b.getUser_Alamat()
                    + "\",\"ktp\":\"" + b.getUser_KTP()
                    + "\",\"tgl_lahir\":\"" + b.getUser_Tanggal_lahir()
                    + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer user_id) {
        try {
            URL url = new URL(alamat+"?id="+user_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : "+alamat+"?id="+user_id);
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<user> getAll() {
        populateUser();
        return listUser;
    }

    @Override
    public List<user> getCari(String displayname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populateUser();
        return listUser.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
