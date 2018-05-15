/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.dao;

import static rest.dao.DAORestIuranUser.alamat;
import dao.implementIuranJenis;
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
import object.iuran_jenis;
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
public class DAORestIuranJenis implements implementIuranJenis {

    private List<iuran_jenis> listIuranJenis;
    public static String alamat = "http://localhost/siput-server/index.php/iuran_jeniss";

    public DAORestIuranJenis() {
        populateIuranJenis();
    }

    @Override
    public void insert(iuran_jenis b) {
        int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "iuran_Jenis_Nama=" + b.getIuran_Jenis_Nama();
//                    + "&iuran_jenis_keterangan=" + b.getIuranJenisKeterangan();
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
            id = Integer.valueOf(e.text());
            System.out.println("id created:" + id);

            conn.disconnect();
            populateIuranJenis();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateIuranJenis() {
        listIuranJenis = new ArrayList<>();
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
            listIuranJenis.clear();
            for (int i = 0; i < json.size(); i++) {

                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                //System.out.println(jo.get("user_pengeluaran_Kategori_Nama").toString());
                listIuranJenis.add(new iuran_jenis(Integer.valueOf(jo.get("iuran_Jenis_id").toString()),
                        String.valueOf(jo.get("iuran_Jenis_Nama").toString()),
                        Integer.valueOf(jo.get("iuran_Jenis_Interval").toString())));
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

    public iuran_jenis getIuranJenis(String iuran_Jenis_id) {
        populateIuranJenis();
        iuran_jenis iuranJenis = null;
        for (iuran_jenis _iuranJenis : listIuranJenis) {
            if (String.valueOf(_iuranJenis.getIuran_Jenis_id()).equals(iuran_Jenis_id)) {
                iuranJenis = _iuranJenis;
            }
        }
        return iuranJenis;
    }

    @Override
    public void update(iuran_jenis b) {
        try {
            URL url = new URL(alamat + "?id=" + b.getIuran_Jenis_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input
                    = "{"
                    + "\"iuran_Jenis_Nama\":\"" + b.getIuran_Jenis_Nama()
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
            populateIuranJenis();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer iuran_Jenis_id) {
        try {
            URL url = new URL(alamat + "?id=" + iuran_Jenis_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : " + alamat + "?id=" + iuran_Jenis_id);
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
            populateIuranJenis();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public iuran_jenis get(Integer iuran_Jenis_id) {
        populateIuranJenis();
        iuran_jenis iuranJenis = null;
        for (iuran_jenis _iuranJenis : listIuranJenis) {
            if (Integer.valueOf(_iuranJenis.getIuran_Jenis_id()).equals(iuran_Jenis_id)) {
                iuranJenis = _iuranJenis;
            }
        }
        return iuranJenis;
    }

    @Override
    public List<iuran_jenis> getAll() {
        populateIuranJenis();
        return listIuranJenis;
    }

    @Override
    public List<iuran_jenis> getCari(String Iuran_Jenis_Nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populateIuranJenis();
        return listIuranJenis.size();
    }
}
