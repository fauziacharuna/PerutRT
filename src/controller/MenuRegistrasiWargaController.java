/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class MenuRegistrasiWargaController implements Initializable {

    @FXML
    private Label btn_exit;
    @FXML
    private JFXTextField tf_birthDate;
    @FXML
    private JFXTextField tf_username;
    @FXML
    private JFXTextField tf_address;
    @FXML
    private JFXTextField tf_identity;
    @FXML
    private JFXTextField tf_name;
    @FXML
    private JFXComboBox<?> cb_usertType;
    @FXML
    private TableView<?> table_userName;
    @FXML
    private JFXButton btn_save;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void handleButtonAction(MouseEvent event) {
      System.exit(0);
    }
    
    private void tutupBtn(ActionEvent event) {
        Stage stage = (Stage)btn_exit .getScene().getWindow();
        stage.close();
    }

    @FXML
    private void simpanUser(ActionEvent event) {
    }

    @FXML
    private void editUser(ActionEvent event) {
    }

    @FXML
    private void hapusUser(ActionEvent event) {
    }

    @FXML
    private void tambahUser(ActionEvent event) {
    }
    
}