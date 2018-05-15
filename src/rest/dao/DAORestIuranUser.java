/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.dao;

import dao.implementIuranUser;
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
import object.iuran;
import object.iuran_user;
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
public class DAORestIuranUser implements implementIuranUser {

    private List<iuran_user> listIuranUser;
    public static String alamat = "http://localhost/siput-server/index.php/iuran_users";

    public DAORestIuranUser() {
        populateIuranUser();
    }

    @Override
    public void insert(iuran_user b) {
        int id = 0;
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters = "iuran_id=" + b.getIuran_id()
                    + "&user_id=" + b.getUser_id()
                    + "&iuran_User_Status=" + b.getIuran_User_Status();
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
            populateIuranUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public iuran_user get(Integer iuran_User_id) {
        populateIuranUser();
        iuran_user iuranUser = null;
        for (iuran_user _iuranUser : listIuranUser) {
            if (Integer.valueOf(_iuranUser.getIuran_User_id()).equals(iuran_User_id)) {
                iuranUser = _iuranUser;
            }
        }
        return iuranUser;
    }

    @Override
    public iuran_user getByUserAndIuran(user u, iuran i) {
        populateIuranUser();
        iuran_user iuranUser = null;
        for (iuran_user _iuranUser : listIuranUser) {
            if (_iuranUser.getUser_id() == u.getUser_id()
                    && _iuranUser.getIuran_id() == i.getIuran_id()) {
//                System.out.println("True lik");
                iuranUser = _iuranUser;
            }
        }
        return iuranUser;
    }

    @Override
    public void update(iuran_user b) {
        try {
            URL url = new URL(alamat + "?id=" + b.getIuran_User_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input = "{"
                    + "\"user_id\":\"" + b.getUser_id()
                    + "\",\"iuran_id\":\"" + b.getIuran_id()
                    + "\",\"iuran_User_Status\":\"" + b.getIuran_User_Status()
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
            populateIuranUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer iuran_User_id) {
        try {
            URL url = new URL(alamat + "?id=" + iuran_User_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : " + alamat + "?id=" + iuran_User_id);
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
            populateIuranUser();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<iuran_user> getAll() {
        populateIuranUser();
        return listIuranUser;
    }

    @Override
    public List<iuran_user> getCari(Integer user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public user getUser(iuran_user b) {
        DAORestUser restUser = new DAORestUser();
        iuran_user iuranUser = get(Integer.valueOf(b.getIuran_User_id()));
        user user = restUser.getUser(Integer.valueOf(iuranUser.getUser_id()));

        return user;
    }

    @Override
    public iuran getIuran(iuran_user b) {
        DAORestIuran restIuran = new DAORestIuran();
        iuran_user iuranUser = get(Integer.valueOf(b.getIuran_User_id()));
        iuran iuran = restIuran.get(Integer.valueOf(iuranUser.getIuran_id()));

        return iuran;
    }

    @Override
    public Integer getCount() {
        populateIuranUser();
        return listIuranUser.size();
    }

    private void populateIuranUser() {
        listIuranUser = new ArrayList<>();
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
            System.out.println(json.toString());
            listIuranUser.clear();
            for (int i = 0; i < json.size(); i++) {
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                System.out.println(jo.toString());
                listIuranUser.add(new iuran_user(Integer.valueOf(jo.get("iuran_User_id").toString()),
                        Integer.valueOf(jo.get("user_id").toString()),
                        Integer.valueOf(jo.get("iuran_id").toString()),
                        Integer.valueOf(jo.get("iuran_User_Status").toString())));
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
    public List<iuran_user> getBelumLunas(user b) {
    listIuranUser = new ArrayList<>();
        try {
            URL url = new URL(alamat+"?param=getBelumLunas&user_id="+b.getUser_id());
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
            System.out.println(json.toString());
            listIuranUser.clear();
            for (int i = 0; i < json.size(); i++) {
                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                System.out.println(jo.toString());
                listIuranUser.add(new iuran_user(Integer.valueOf(jo.get("iuran_user_id").toString()),
                        Integer.valueOf(jo.get("user_id").toString()),
                        Integer.valueOf(jo.get("iuran_id").toString()),
                        Integer.valueOf(jo.get("iuran_User_Status").toString())));
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listIuranUser;
    }


}
