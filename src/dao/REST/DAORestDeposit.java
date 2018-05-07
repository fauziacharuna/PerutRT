package dao.Rest;

import static dao.Rest.DAORestUser.alamat;
import dao.implementDeposit;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import model.DepositModel;
import object.deposit;
import object.user;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DAORestDeposit implements implementDeposit {

    private List<deposit> listDeposit;
    public static String alamat = "http://localhost/siput-server/index.php/deposits";

    public DAORestDeposit() {
        populateDeposit();
    }

    @Override
    public void insert(deposit b) {
        try {
            URL url = new URL(alamat);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String urlParameters  = "user_id="+b.getUser_id()+
                    "&deposit_Nominal="+b.getDeposit_Nominal();
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
            int id = Integer.valueOf(e.text());
            System.out.println("ID Deposit inserted:"+id);
            
            conn.disconnect();
            populateDeposit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        return id;
    }

    public void populateDeposit() {
        listDeposit = new ArrayList<>();
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
            listDeposit.clear();
            for (int i = 0; i < json.size(); i++) {

                JSONObject jo = (JSONObject) jp.parse(json.get(i).toString());
                //System.out.println(jo.get("iuran_nama").toString());
                listDeposit.add(new deposit(Integer.valueOf(jo.get("deposit_id").toString()),
                        Integer.valueOf(jo.get("user_id").toString()),
                        Double.valueOf(jo.get("deposit_Nominal").toString())));                      
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

    public deposit getDepositId(int deposit_id) {
        populateDeposit();
        deposit deposit = null;
        for (deposit _deposit : listDeposit) {
            if (String.valueOf(_deposit.getDeposit_id()).equals(deposit_id)) {
                deposit = _deposit;
            }
        }
        return deposit;
    }

    @Override
    public void update(deposit b) {
        try {
            URL url = new URL(alamat + "?id=" + b.getDeposit_id());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            String input
                    = 
                    "{"
                    + "\"user_id\":\"" + b.getUser_id()
                    + "\",\"deposit_Nominal\":\"" + b.getDeposit_Nominal()
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
            populateDeposit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer deposit_id) {
        try {
            URL url = new URL(alamat + "?id=" + deposit_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.addRequestProperty("Authorization", LoginDAOREST.user);
            System.out.println("alamat url : " + alamat + "?id=" + deposit_id);
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
            populateDeposit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<deposit> getAll() {
        populateDeposit();
        return listDeposit;
    }

  @Override
    public List<deposit> getCari(Integer user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   @Override
    public Integer getCount() {
        populateDeposit();
        return listDeposit.size();
    }

    
    @Override
    public deposit get(Integer deposit_id) {
        populateDeposit();
        deposit deposit = null;
        for (deposit _deposit : listDeposit) {
            if (String.valueOf(_deposit.getDeposit_id()).equals(deposit_id)) {
                deposit = _deposit;
            }
        }
        return deposit;
    }

    @Override
    public deposit getByUser(user b) {
        populateDeposit();
        deposit deposit = null;
        for (deposit _deposit : listDeposit) {
            if (_deposit.getUser_id() == b.getUser_id()) {
                deposit = _deposit;
            }
        }
        return deposit;
    }


    @Override
    public user getUser(deposit b) {
        populateDeposit();
        DAORestUser restUser = new DAORestUser();
        deposit deposit = null;
        user user = null;
        for (deposit _deposit : listDeposit) {
            if (_deposit.getDeposit_id() == b.getDeposit_id()) {
                user = restUser.getUser(Integer.valueOf(_deposit.getUser_id()));
            }
        }
        return user;
    }
}
