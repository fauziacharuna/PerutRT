/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class UndanganController implements Initializable {

    @FXML
    private ScrollPane spp1;
    @FXML
    private JFXTextField tfPerihal;
    @FXML
    private JFXTextField tfLampiran;
    @FXML
    private JFXDatePicker dpTgl;
    @FXML
    private JFXTextField tfWaktu;
    @FXML
    private JFXTextField tfTempat;
    @FXML
    private JFXTextField tfAcara;
    @FXML
    private JFXButton btnCetak;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CetakUndangan(ActionEvent event) {
    }
    
}
