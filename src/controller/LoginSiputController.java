/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class LoginSiputController implements Initializable {
    private String username="admin";
    private String password="admin";


    @FXML
    private Label statustext;

    @FXML
    private JFXTextField usernametext;

    @FXML
    private JFXPasswordField passtext;

    @FXML
    private JFXButton btlbtn;
    @FXML
    private AnchorPane bg1;
    @FXML
    private JFXButton loginbtn;
    @FXML
    private Label versi;


    @FXML
    public void Login(ActionEvent event) throws Exception {
      
       // if (usernametext.equals(username) && passtext.equals(password)) {
            statustext.setText("Login Sukses");
            //agar jendela login tertutup setelah berhasil login
            ((Node) (event.getSource())).getScene().getWindow().hide();

            //memanggil jendela menu admins
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/view/Menu.fxml"));
//            loader.load();
      try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.show();
          }catch(Exception ex){
              ex.printStackTrace();
              System.out.println("Error");
          }
            
        //} else {
         //   statustext.setText("akun atau sandi salah");
       // }
    }

    @FXML
    private void tutupBtn(ActionEvent event) {
        Stage stage = (Stage) btlbtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
