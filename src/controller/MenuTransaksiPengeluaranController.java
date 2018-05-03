/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class MenuTransaksiPengeluaranController implements Initializable {

    @FXML
    private Pane pane_transaksi;
    @FXML
    private AnchorPane anchorPane_pengeluaran;
    @FXML
    private JFXComboBox<?> cb_pilhPengeluaran;
    @FXML
    private JFXTextField tf_nominal_pengeluaran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
