/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest.dao;


import static rest.dao.DAORestIuranJenis.alamat;
import dao.implementPengeluaranPerubahan;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.pengeluaran_perubahan;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import object.user;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Setyawati
 */


public class DAORestPengeluaranPerubahan implements implementPengeluaranPerubahan{
    
    private List<pengeluaran_perubahan> listPengeluaranPerubahan;
    public static String alamat = "http://localhost/siput-server/index.php/pengeluaran_perubahans";

    public DAORestPengeluaranPerubahan() {
        populatePengeluaranPerubahan();
    }

    @Override 
    public void insert(pengeluaran_perubahan b) {
           int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "pengeluaran_Perubahan_Nominal=" + b.getPengeluaran_Perubahan_Nominal()
                    + "&pengeluaran_Perubahan_Tanggal=" + b.getPengeluaran_Perubahan_Tanggal()
                    + "&pengeluaran_id=" + b.getPengeluaran_id();
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
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
                response = response + output;
            }

            //ini parsing data output menggunakan jsoup, diambil id nya
            Document d = Jsoup.parse(response);
            Elements tables = d.select("table > tbody > tr > td");
            Element e = tables.first();
            System.out.println(e.text());
            id = Integer.valueOf(e.text());
            System.out.println("id created:" + id);

            conn.disconnect();
            populatePengeluaranPerubahan();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populatePengeluaranPerubahan() {
        listPengeluaranPerubahan = new ArrayList<>();
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
            listPengeluaranPerubahan.clear();
            for (int i = 0; i < json.size(); i++) {
                
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                //System.out.println(jo.get("user_username").toString());
                listPengeluaranPerubahan.add(new pengeluaran_perubahan(Integer.valueOf(jo.get("pengeluaran_Perubahan_id").toString()), 
                        Double.valueOf(jo.get("pengeluaran_Perubahan_Nominal").toString()),
                        String.valueOf(jo.get("pengeluaran_Perubahan_Tanggal").toString()),
                        String.valueOf(jo.get("pengeluaran_Perubahan_Nama").toString()),
                        Integer.valueOf(jo.get("pengeluaran_id").toString())));
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
    public pengeluaran_perubahan get(Integer pengeluaran_Perubahan_id) {
        populatePengeluaranPerubahan();
        pengeluaran_perubahan pengeluaranperubahan = null;
        for (pengeluaran_perubahan _pengeluaranperubahan : listPengeluaranPerubahan) {
            if (String.valueOf(_pengeluaranperubahan.getPengeluaran_Perubahan_id()).equals(pengeluaran_Perubahan_id)) {
                pengeluaranperubahan = _pengeluaranperubahan;
            }
        }
        return pengeluaranperubahan;
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
            populatePengeluaranPerubahan();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void update(pengeluaran_perubahan b) {
        try{
            URL url = new URL(alamat+"?id="+b.getPengeluaran_Perubahan_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            String input ="{"
                    + "\"pengeluaran_Perubahan_Tanggal\":\""+b.getPengeluaran_Perubahan_Tanggal()
                    +"\"pengeluaran_Perubahan_Nominal\":\""+b.getPengeluaran_Perubahan_Nominal()
                    +"\"pengeluaran_id\":\""+b.getPengeluaran_id()
                    +"\"}";
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<pengeluaran_perubahan> getAll() {
        populatePengeluaranPerubahan();
        return listPengeluaranPerubahan;
    }

    @Override
    public List<pengeluaran_perubahan> getCari(String PengeluaranPerubahanNama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populatePengeluaranPerubahan();
        return listPengeluaranPerubahan.size();
    }


}
