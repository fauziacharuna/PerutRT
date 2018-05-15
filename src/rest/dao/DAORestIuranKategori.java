/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest.dao;

import static rest.dao.DAORestIuranJenis.alamat;
import dao.implementIuranKategori;
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
import object.iuran_kategori;
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
public class DAORestIuranKategori implements implementIuranKategori{
 private List<iuran_kategori> listKategoriIuran;
    public static String alamat = "http://localhost/siput-server/index.php/Iuran_kategoris";

    public DAORestIuranKategori() {
        populateIuranKategori();
    }

    @Override 
    public void insert(iuran_kategori b) {
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "iuran_Kategori_Nama=" + b.getIuran_Kategori_Nama();
//                    + "&iuran_Kategori_Interval=" + b.getIuran_Kategori_Interval();
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
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
            int id = Integer.valueOf(e.text());
            System.out.println("id created:" + id);

            conn.disconnect();
            populateIuranKategori();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateIuranKategori() {
        listKategoriIuran = new ArrayList<>();
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
            listKategoriIuran.clear();
            for (int i = 0; i < json.size(); i++) {
                
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                //System.out.println(jo.get("iuran_nama").toString());
                listKategoriIuran.add(new iuran_kategori(Integer.valueOf(jo.get("iuran_Kategori_id").toString()), 
                        String.valueOf(jo.get("iuran_Kategori_Nama").toString()),
                        Integer.valueOf(jo.get("iuran_id").toString())));
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

        public iuran_kategori getIuranKategoriId(Integer iuran_Kategori_id) {
        populateIuranKategori();
        iuran_kategori iuranKategori = null;
        for (iuran_kategori _iurankategori : listKategoriIuran) {
            if (Integer.valueOf(_iurankategori.getIuran_Kategori_id()).equals(iuran_Kategori_id)) {
               iuranKategori = _iurankategori;
            }
        }
        return iuranKategori;
    }

    @Override
    public void update(iuran_kategori b) {
        try {
            URL url = new URL(alamat+"?id="+b.getIuran_Kategori_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input =  "{"
                    + "\"iuran_Kategori_Nama\":\"" + b.getIuran_Kategori_Nama()
//                    + "\",\"iuran_Kategori_Interval\":\"" + b.getIuran_Kategori_Interval()
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
            populateIuranKategori();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer iuran_Kategori_id) {
        try {
            URL url = new URL(alamat+"?id="+iuran_Kategori_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : "+alamat+"?id="+iuran_Kategori_id);
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
            populateIuranKategori();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public iuran_kategori get(Integer iuran_Kategori_id) {
        populateIuranKategori();
        iuran_kategori iuranKategori = null;
        for (iuran_kategori _iuranKategori : listKategoriIuran) {
            if (Integer.valueOf(_iuranKategori.getIuran_Kategori_id()).equals(iuran_Kategori_id)) {
                iuranKategori = _iuranKategori;
            }
        }
        return iuranKategori;
    }

    @Override
    public List<iuran_kategori> getAll() {
        populateIuranKategori();
        return listKategoriIuran;
    }

    @Override
    public List<iuran_kategori> getCari(String iuran_Kategori_Nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populateIuranKategori();
        return listKategoriIuran.size();
    }

}
