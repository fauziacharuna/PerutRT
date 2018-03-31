/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    
}
