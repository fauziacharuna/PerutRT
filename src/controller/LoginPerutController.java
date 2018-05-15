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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javax.swing.JOptionPane;
import koneksi.Koneksi;
import model.UserModel;
import object.user;
import koneksi.Koneksi;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class LoginPerutController implements Initializable {

    private String username = "admin";
    private String password = "admin";

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
    UserModel userModel = new UserModel();

    @FXML
    public void Login(ActionEvent event) throws Exception {

    int loggedIn_user_id = userModel.getValidLogin(usernametext.getText(), passtext.getText());
        user loggedIn_user = userModel.getUser(loggedIn_user_id);
        if (loggedIn_user_id != 0 && !loggedIn_user.getUser_Tipe_User().equals("warga")) {
            statustext.setText("Login Sukses");
            //agar jendela login tertutup setelah berhasil login
//            ((Node) (event.getSource())).getScene().getWindow().hide();
    
    
//      int loggedIn_userId = getUserModel().getValidLogin(usernametext.getText(), passtext.getText());
//        user loggedIn_user = getUserModel().getUser((loggedIn_userId));
//        if (loggedIn_userId != 0 && !loggedIn_user.getUser_Tipe_User().equals("admin")) {
//            statustext.setText("Login sukses");
//            if(usernametext.getText().equals(username)&&passtext.getText().equals(password)){
                 ((Node) (event.getSource())).getScene().getWindow().hide();
//                 statustext.setText("Login Sukses");
                
//
//          
            //agar jendela login tertutup setelah berhasil login
           
           
            try {
//          
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Menu.fxml"));
                loader.load();
                MenuController aController = loader.getController();
//                aController.setUserName(loggedIn_user);
                Parent parent = loader.getRoot();
//               aController.btnHomeOnClick(event);
                Stage primaryStage = new Stage();
                Scene scene = new Scene(parent);
                primaryStage.setScene(scene);
//            primaryStage.setMaximized(true);
                primaryStage.setTitle("Menu Admin");
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error");
            }
////
        } else {
            statustext.setText("akun atau sandi salah");
        }
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
