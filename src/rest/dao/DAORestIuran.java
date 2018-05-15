
package rest.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import object.iuran;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import dao.implementIuran;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import object.iuran_jenis;
import object.iuran_kategori;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DAORestIuran implements implementIuran{
    
    
    private List<iuran> listIuran;
    public static String alamat = "http://localhost/perut-rest/index.php/iuran";

    public DAORestIuran() {
        populateIuran();
    }

    @Override 
    public Integer insert(iuran b) {
        int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters  = 
                    "&iuran_Nominal="+b.getIuran_Nominal()+
                    "&iuran_Nama="+b.getIuran_Nama()+
                    "&iuran_Jenis_id="+b.getIuran_Jenis_id()+
                    "&iuran_Kategori_id="+b.getIuran_Kategori_id();
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
            System.out.println("respone :"+response);
            //ini parsing data output menggunakan jsoup, diambil id nya
            Document d = Jsoup.parse(response);
            Elements tables = d.select("table > tbody > tr > td");
            Element e = tables.first();
            System.out.println(e.text());
            id = Integer.valueOf(e.text());
            
            conn.disconnect();
            populateIuran();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void populateIuran() {
        listIuran = new ArrayList<>();
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
            listIuran.clear();
            for (int i = 0; i < json.size(); i++) {
                
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                System.out.println(jo.get("iuran_Nama").toString());
//              listIuran.add(new iuran(Integer.valueOf(jo.get("iuran_id").toString()), 
////                     String.valueOf(jo.get("iuran_Nama").toString()),
////                      Integer.valueOf(jo.get("iuran_Nominal").toString()),
////                        String.valueOf(jo.get("iuran_Tanggal").toString()),
////                         Integer.valueOf(jo.get("iuran_Kategori_id").toString()), 
////                        Integer.valueOf(jo.get("iuran_Jenis_id").toString())));
//                       
                       
                        

//              
//                       jo.get("iuran_Nama").toString()),
//                       Integer.valueOf(jo.get("iuran_Jenis_id").toString()),
//                        Integer.valueOf(jo.get("iuran_Kategori_id").toString()),
//           
//                       String.valueOf(jo.get("iuran_Tanggal").toString()),
//                       Double.valueOf((String) jo.get("iuran_Total")),
//                        Double.valueOf(jo.get("iuran_Nominal").toString()));
              
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
    public void update(iuran b) {
        try {
            URL url = new URL(alamat+"?id="+b.getIuran_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");
            
            String urlParameters  = 
                    "&iuran_Nominal="+b.getIuran_Nominal()+
                    "&iuran_Nama="+b.getIuran_Nama()+
                    "&iuran_Jenis_id="+b.getIuran_Jenis_id()+
                    "&iuran_Kategori_id="+b.getIuran_Kategori_id();
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;   
            conn.setInstanceFollowRedirects( false );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
               wr.write( postData );
            }

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
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
            System.out.println("respone :"+response);
            conn.disconnect();
            populateIuran();
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
            populateIuran();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//BELUM DIISIKAN BODY OVERIDDENYA//
    
    @Override
    public List<iuran> getAll() {
        populateIuran();
        return listIuran;
    }

    @Override
    public List<iuran> getCari(String displayname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populateIuran();
        return listIuran.size();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public iuran get(Integer iuran_id) {
        populateIuran();
        iuran iuran = null;
        for (iuran _iuran : listIuran) {
            if (String.valueOf(_iuran.getIuran_id()).equals(iuran_id)) {
                iuran = _iuran;
            }
        }
        return iuran;
    }

    @Override
    public iuran_jenis getIuranJenis(iuran b) {
        DAORestIuranJenis restIuranJenis = new DAORestIuranJenis();
        iuran iuran = get(Integer.valueOf(b.getIuran_Jenis_id()));
        iuran_jenis iuranJenis = restIuranJenis.get(Integer.valueOf(iuran.getIuran_Jenis_id()));
        
        return iuranJenis;
    }

    @Override
    public iuran_kategori getIuranKategori(iuran b) {
        DAORestIuranKategori restIuranKategori = new DAORestIuranKategori();
        iuran iuran = get(Integer.valueOf(b.getIuran_Jenis_id()));
        iuran_kategori iuranKategori = restIuranKategori.get(Integer.valueOf(iuran.getIuran_Kategori_id()));
        
        return iuranKategori;
    }

}
