/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author fauziachmadharuna
 */
public class MenuController implements Initializable {

    private Pane pane_transaksi;
    private AnchorPane anchorPane_Pemasukan;
    private AnchorPane anchorPane_pengeluaran;
    AnchorPane home, pemasukan, pengeluaran, data_warga, laporan, pengaturan_iuran;
    @FXML
    private StackPane sp_pane_holder;
    @FXML
    private Label lbl_exit;
    @FXML
    private Pane Admin;
    @FXML
    private MenuButton menuButton_user;
    @FXML
    private MenuItem item_admin;
    @FXML
    private MenuItem item_operator;
    @FXML
    private ImageView avatar_user;
    @FXML
    private Pane pane_navigation;
    @FXML
    private JFXButton btn_beranda;
    @FXML
    private JFXButton btn_pemasukan;
    @FXML
    private JFXButton btn_pengeluaran;
    @FXML
    private JFXButton btn_regWarga;
    @FXML
    private JFXButton btn_laporan;
    @FXML
    private JFXButton btn_pengaturan_iuran;
    @FXML
    private JFXButton btn_website;
    @FXML
    private AnchorPane HolderPane;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

//        pane_transaksi.setVisible(false);
//        pane_home.setVisible(true);
//        pane_dataWarga.setVisible(false);
        // TODO
//        MenuItem option1=new MenuItem("Admin");
//        MenuItem option2=new MenuItem("Operator");
//       try {
//            home = FXMLLoader.load(getClass().getResource("/view/Beranda.fxml"));
//            pemasukan = FXMLLoader.load(getClass().getResource("/view/TransaksiPemasukan.fxml"));
//            pengeluaran = FXMLLoader.load(getClass().getResource("/view/TransaksiPengeluaran.fxml"));
//            data_warga = FXMLLoader.load(getClass().getResource("/view/RegistrasiWarga.fxml"));
//            laporan = FXMLLoader.load(getClass().getResource("/view/Laporan.fxml"));
//            pengaturan_iuran = FXMLLoader.load(getClass().getResource("/view/Pengaturan_iuran.fxml"));
//            setNode(home);
//       } catch (IOException ex) {
//          Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    private void setNode(Node node) {
//        pane_holder.getChildren().clear();
//        pane_holder.getChildren().add((Node) node);
//
//        FadeTransition ft = new FadeTransition(Duration.millis(1000));
//        ft.setNode(node);
//        ft.setFromValue(0.1);
//        ft.setToValue(1);
//        ft.setCycleCount(1);
//        ft.setAutoReverse(false);
//        ft.play();



    }


    @FXML
    private void regisWarga(ActionEvent event) throws Exception{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/view/RegistrasiWarga.fxml"));
       loader.load();
       AnchorPane acBeranda=loader.getRoot();
       sp_pane_holder.getChildren().clear();
       sp_pane_holder.getChildren().add(acBeranda);

    }

    @FXML
    private void beranda(ActionEvent event) throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Beranda.fxml"));
//        HolderPane = 
        loader.load();
        AnchorPane root = loader.getRoot();
        sp_pane_holder.getChildren().clear();
        sp_pane_holder.getChildren().add(root);
    }



    @FXML
    private void operatorItem(ActionEvent event) {
    }

    @FXML
    private void transaksiPemasukan(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/TransaksiPemasukan.fxml"));
        loader.load();
        AnchorPane root=loader.getRoot();
        sp_pane_holder.getChildren().clear();
        sp_pane_holder.getChildren().add(root);
    }

    @FXML
    private void transaksiPengeluaran(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/TransaksiPengeluaran.fxml"));
        loader.load();
        AnchorPane root=loader.getRoot();
        sp_pane_holder.getChildren().clear();
        sp_pane_holder.getChildren().add(root);
    }

    @FXML
    private void buatLaporan(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Cetak.fxml"));
        loader.load();
        AnchorPane root=loader.getRoot();
        sp_pane_holder.getChildren().clear();
        sp_pane_holder.getChildren().add(root);
        
    }

    @FXML
    private void mengatur_iuran(ActionEvent event) {
    }

    @FXML
    private void open_website(ActionEvent event) {
    }


}
