/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class LapTransaksiController implements Initializable {

    @FXML
    private AnchorPane acPane_LapTransaksi;
    @FXML
    private TableView<?> tv_TableLaporan;
    @FXML
    private TableColumn<?, ?> tColumn_tgl;
    @FXML
    private TableColumn<?, ?> tColumn_NamaTransaksi;
    @FXML
    private TableColumn<?, ?> tColumn_NominalTransaksi;
    @FXML
    private TableColumn<?, ?> tColumn_TipeTransaksi;
    @FXML
    private TableColumn<?, ?> tColumn_NamaUser;
    @FXML
    private DatePicker datePicker_akhir;
    @FXML
    private JFXButton btn_cetakLaporan;
    @FXML
    private DatePicker datePicker_awal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cetakLaporanPDF(ActionEvent event) {
    }
    
}
