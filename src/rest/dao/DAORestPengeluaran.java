/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.dao;

import dao.implementPengeluaran;
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
import object.pengeluaran;
import object.pengeluaran;
import object.pengeluaran_jenis;
import object.pengeluaran_kategori;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DAORestPengeluaran implements implementPengeluaran {

    private List<pengeluaran> listPengeluaran;

    public static String alamat = "http://localhost/siput-server/index.php/pengeluarans";

    public DAORestPengeluaran() {
        populatePengeluaran();
    }

    @Override
    public void insert(pengeluaran b) {
        int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "pengeluaran_Nama=" + b.getPengeluaran_Nama()
                    + "&pengeluaran_Jenis_id=" + b.getPengeluaran_Jenis_id()
//                    + "&pengeluaran_keterangan=" + b.getPengeluaran_keterangan()
                    + "&pengeluaran_Kategori_id=" + b.getPengeluaran_Kategori_id();
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
            populatePengeluaran();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populatePengeluaran() {
        listPengeluaran = new ArrayList<>();
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
            listPengeluaran.clear();
            for (int i = 0; i < json.size(); i++) {
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                //System.out.println(jo.get("iuran_Nama").toString());
                listPengeluaran.add(new pengeluaran(Integer.valueOf(jo.get("pengeluaran_id").toString()),
                        Integer.valueOf(jo.get("pengeluaran_Jenis_id").toString()),
                        Integer.valueOf(jo.get("pengeluaran_Kategori_id").toString()),
                        String.valueOf(jo.get("pengeluaran_Nama").toString()),
                        String.valueOf(jo.get("pengeluaran_Tanggal").toString()),
                        Double.valueOf(jo.get("pengeluaran_Nominal").toString())));
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

    public pengeluaran get(String pengeluaran_id) {
        populatePengeluaran();
        pengeluaran pengeluaran = null;
        for (pengeluaran _pengeluaran : listPengeluaran) {
            if (Integer.valueOf(_pengeluaran.getPengeluaran_id()).equals(pengeluaran_id)) {
                pengeluaran = _pengeluaran;
            }
        }
        return pengeluaran;
    }

    @Override
    public void update(pengeluaran b) {
        try {
            URL url = new URL(alamat + "?id=" + b.getPengeluaran_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input
                    = "{"
                    + "\"pengeluaran_Nama\":\"" + b.getPengeluaran_Nama()
                    + "\",\"pengeluaran_Jenis_id\":\"" + b.getPengeluaran_Jenis_id()
                    + "\",\"pengeluaran_Kategori_id\":\"" + b.getPengeluaran_Kategori_id()
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
            populatePengeluaran();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer pengeluaran_id) {
        try {
            URL url = new URL(alamat + "?id=" + pengeluaran_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : " + alamat + "?id=" + pengeluaran_id);
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
            populatePengeluaran();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<pengeluaran> getAll() {
        populatePengeluaran();
        return listPengeluaran;
    }

    @Override
    public List<pengeluaran> getCari(String pengeluaran_Nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCount() {
        populatePengeluaran();
        return listPengeluaran.size();
    }

    @Override
    public pengeluaran get(Integer pengeluaran_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pengeluaran_jenis getPengeluaranJenis(pengeluaran b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pengeluaran_kategori getPengeluaranKategori(pengeluaran b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
