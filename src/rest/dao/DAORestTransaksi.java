/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.dao;

import dao.implementTransaksi;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.iuran;
import object.pengeluaran;
import object.transaksi;
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
 * @author fauziachmadharuna
 */
public class DAORestTransaksi implements implementTransaksi{
    private List<transaksi> listTransaksi;
    public static String alamat = "http://localhost/perut-server/index.php/Transaksi";
    @Override
    public void insert(transaksi b) {
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "transaksi_Nama=" + b.getTransaksi_Nama()
                    + "&transaksi_Tanggal=" + b.getTransaksi_Tanggal()
                    + "&transaksi_Nominal=" + b.getTransaksi_Nominal()
                    + "&user_id=" + b.getUser_id()
                    + "&transaksi_tipe=" + b.getTransaksi_tipe()
                    + "&iuran_id=" + b.getIuran_id()
                    + "&pengeluaran_id=" + b.getPengeluaran_id();
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
            int id = Integer.valueOf(e.text());
            System.out.println("Added id :"+id);
            conn.disconnect();
            populateTransaksi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public transaksi get(Integer transaksi_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(transaksi b) {
         try {
            URL url = new URL(alamat + "?id=" + b.getTransaksi_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input
                    = "{"
                    + "\"transaksi_Tanggal\":\"" + b.getTransaksi_Tanggal()
                    + "\",\"transaksi_Nama\":\"" + b.getTransaksi_Nama()
                    + "\",\"transaksi_Nominal\":\"" + b.getTransaksi_Nominal()
                    + "\",\"user_id\":\"" + b.getUser_id()
                    + "\",\"transaksi_tipe\":\"" + b.getTransaksi_tipe()
                    + "\",\"pengeluaran_id\":\"" + b.getPengeluaran_id()
                    + "\",\"iuran_id\":\"" + b.getIuran_id()
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
            populateTransaksi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer transaksi_id) {
        try {
            URL url = new URL(alamat + "?id=" + transaksi_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : " + alamat + "?id=" + transaksi_id);
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
            populateTransaksi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<transaksi> getAll() {
        populateTransaksi();
        return listTransaksi;
    }

    @Override
    public List<transaksi> getCari(String user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public user getUser(transaksi b) {
        DAORestUser restUser = new DAORestUser();
        transaksi transaksi = get(Integer.valueOf(b.getTransaksi_id()));
        user user = restUser.getUser(transaksi.getUser_id());

        return user;
    }

    @Override
    public iuran getIuran(transaksi b) {
        DAORestIuran restIuran = new DAORestIuran();
        transaksi transaksi = get(Integer.valueOf(b.getTransaksi_id()));
        iuran iuran = restIuran.get(Integer.valueOf(transaksi.getIuran_id()));
        return iuran;
    }

    @Override
    public pengeluaran getPengeluaran(transaksi b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getJumlahKas() {
       return getJumlahIuran() - getJumlahPengeluaran();

    }

    @Override
    public Integer getJumlahIuran() {
        int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=jumlahIuran");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
                response = output;
            }

            JSONParser jp = new JSONParser();
            JSONArray json = (JSONArray) jp.parse(response);
            JSONObject jo = (JSONObject) json.get(0);
            jumlah = Integer.valueOf(jo.get("Jumlah").toString());

            conn.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }

    @Override
    public Integer getJumlahPengeluaran() {
         int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=jumlahPengeluaran");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
                response = output;
            }

            JSONParser jp = new JSONParser();
            JSONArray json = (JSONArray) jp.parse(response);
            JSONObject jo = (JSONObject) json.get(0);
            jumlah = jo.get("Jumlah") == null ? 0 : Integer.valueOf(jo.get("Jumlah").toString());
            System.out.println("jumlah : " + jumlah);

            conn.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }

    @Override
    public Integer getJumlahTransaksi() {
         int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=jumlahTransaksi");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
                response = response + output;
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
            JSONObject jo = (JSONObject) jp.parse(json.get(0).toString());
            jumlah = Integer.valueOf(jo.get("Jumlah").toString());
            System.out.println(jo.get("Jumlah").toString());

            conn.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAORestTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }

    @Override
    public Integer getUtang(Integer user_id, Integer iuran_id) {
         int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=getUtang&user_id="+user_id+"&iuran_id="+iuran_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
    public Integer getTotalBayar(Integer user_id, Integer iuran_id) {
        int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=getTotalBayar&user_id="+user_id+"&iuran_id="+iuran_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
    public Integer getTotalDibayar(Integer user_id, Integer iuran_id) {
        int jumlah = 0;
        try {
            URL url = new URL(alamat + "?param=getTotalDibayar&user_id="+user_id+"&iuran_id="+iuran_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
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
    public transaksi getTransaksiPertama(Integer user_id, Integer iuran_id) {
        transaksi transaksi = null;
        try {
            URL url = new URL(alamat + "?param=transaksiPertama&user_id=" + user_id + "&iuran_id=" + iuran_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
//            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//            }
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
            JSONObject jo = (JSONObject) json.get(0);
            listTransaksi.clear();
            transaksi = new transaksi(Integer.valueOf(jo.get("transaksi_id").toString()),
                        Double.valueOf(jo.get("transaksi_Nominal").toString()),
                        Double.valueOf(jo.get("transaksi_Saldo").toString()),
                        Integer.valueOf(jo.get("user_id").toString()),
                        Integer.valueOf(jo.get("iuran_id") == null ? null : jo.get("iuran_id").toString()),
                        Integer.valueOf(jo.get("pengeluaran_id") == null ? null : jo.get("pengeluaran_id").toString()),
                        String.valueOf(jo.get("transaksi_Tanggal").toString()),
                        String.valueOf(jo.get("transaksi_Nama").toString()),
                        String.valueOf(jo.get("transaksi_tipe").toString()),
                        String.valueOf(jo.get("user_Username").toString()));
        
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return transaksi;
    }

    @Override
    public Integer getCount() {
        populateTransaksi();
        return listTransaksi.size();
    }

    private void populateTransaksi() {
    }
    
}
