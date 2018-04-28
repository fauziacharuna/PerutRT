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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class MenuController implements Initializable {

    @FXML
    private JFXTextField tf_search;
    @FXML
    private Label label;
    @FXML
    private Pane pane_home;
    @FXML
    private JFXComboBox<?> combobox_bulan;
    @FXML
    private Pane pane_transaksi;
    @FXML
    private JFXTextField tf_nominalIuran;
    @FXML
    private JFXTextField tf_jumlahKurang;
    @FXML
    private JFXTextField tf_status;
    @FXML
    private JFXButton btn_regWarga;
    @FXML
    private JFXButton btn_beranda;
    @FXML
    private JFXButton btn_transaksi;
    @FXML
    private JFXButton btn_laporan;
    @FXML
    private Pane pane_dataWarga;
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
    private JFXTextField tf_saldo;
    @FXML
    private JFXButton btn_save;
    @FXML
    private JFXButton btn_reset;
    @FXML
    private Label btn_exit;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_add;
    @FXML
    private TableView<?> table_userName;
    @FXML
    private AnchorPane anchorPane_Pemasukan;
    @FXML
    private JFXButton btn_pengeluaran1;
    @FXML
    private JFXButton btn_pemasukan1;
    @FXML
    private AnchorPane anchorPane_pengeluaran;
    @FXML
    private JFXComboBox<?> cb_pilhPengeluaran;
    @FXML
    private JFXTextField tf_nominal_pengeluaran;
    @FXML
    private JFXButton btn_pemasukan;
    @FXML
    private JFXButton btn_pengeluaran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane_transaksi.setVisible(false);
        pane_home.setVisible(true);
        pane_dataWarga.setVisible(false);
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void regisWarga(ActionEvent event) {
        pane_home.setVisible(false);
        pane_dataWarga.setVisible(true);
        pane_transaksi.setVisible(false);
//         try{
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuRegistrasiWarga.fxml"));
//            Parent root1 = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initStyle(StageStyle.UNDECORATED);
//            stage.setScene(new Scene(root1));  
//            stage.show();
//          }catch(Exception ex){
//              ex.printStackTrace();
//              System.out.println("Error");
//          }
       
    }

    @FXML
    private void beranda(ActionEvent event) {
        pane_home.setVisible(true);
        pane_transaksi.setVisible(false);
        pane_dataWarga.setVisible(false);
    }

    @FXML
    private void transaksi(ActionEvent event) {
        pane_home.setVisible(false);
        pane_transaksi.setVisible(true);
        pane_dataWarga.setVisible(false);
    }

    @FXML
    private void laporan(ActionEvent event) {
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

    @FXML
    private void call_pengeluaran(ActionEvent event) {
        anchorPane_pengeluaran.setVisible(true);
        anchorPane_Pemasukan.setVisible(false);
    }

    @FXML
    private void call_pemasukan(ActionEvent event) {
        anchorPane_pengeluaran.setVisible(false);
        anchorPane_Pemasukan.setVisible(true);
    }
    
}
