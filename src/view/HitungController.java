/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class HitungController implements Initializable {
    int jumlah,bilangan1,bilangan2;

    @FXML
    private JFXTextField tf_bil1;
    @FXML
    private JFXTextField tf_bil2;
    @FXML
    private Label label_result;
    @FXML
    private JFXButton btn_jumlah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hitungJumlah(ActionEvent event) {
       
        
    }
    
}
