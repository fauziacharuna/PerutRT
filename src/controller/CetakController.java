/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class CetakController implements Initializable {

    @FXML
    private AnchorPane HolderPane;
    @FXML
    private Button btnLaporan;
    @FXML
    private Button btnUndangan;
    @FXML
    private StackPane sp_cetak;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LaporanView(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/LapTransaksi.fxml"));
        loader.load();
        AnchorPane root=loader.getRoot();
        sp_cetak.getChildren().clear();
        sp_cetak.getChildren().add(root);
    }

    @FXML
    private void UndanganView(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/CetakUndangan.fxml"));
        loader.load();
        AnchorPane root=loader.getRoot();
        sp_cetak.getChildren().clear();
        sp_cetak.getChildren().add(root);
    }
    
}
