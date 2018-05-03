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
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class RegistrasiWargaController implements Initializable {

    @FXML
    private AnchorPane RegistrasiWarga;
    @FXML
    private Pane pane_dataWarga;
    @FXML
    private JFXTextField tf_name;
    @FXML
    private JFXTextField tf_birthDate;
    @FXML
    private JFXTextField tf_username;
    @FXML
    private JFXTextField tf_address;
    @FXML
    private JFXTextField tf_identity;
    @FXML
    private JFXComboBox<String> cb_usertType;
    @FXML
    private JFXTextField tf_saldo;
    @FXML
    private JFXButton btn_save;
    @FXML
    private JFXButton btn_reset;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_add;
    @FXML
    private TableView<?> table_userName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_usertType.getItems().add("Admin");
        cb_usertType.getItems().add("Operator");
       
    }    

    @FXML
    private void simpanUser(ActionEvent event) {
    }

    @FXML
    private void resetAll(ActionEvent event) {
    }

    @FXML
    private void editUser(ActionEvent event) {
    }

    @FXML
    private void hapusUser(ActionEvent event) {
    }

    @FXML
    private void addUser(ActionEvent event) {
    }
    
}
