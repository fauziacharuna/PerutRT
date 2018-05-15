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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.DepositModel;
import model.IuranModel;
import model.IuranUserModel;
import model.UserModel;
import object.deposit;
import object.iuran;
import object.iuran_user;
import object.user;
import org.controlsfx.control.CheckListView;

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
    private TableView<user> table_userName;
    @FXML
    private DatePicker dp_tglLahir;
    @FXML
    private JFXTextField tf_password;
    @FXML
    private CheckListView<iuran> clv_iuran;
     UserModel userModel = new UserModel();
    DepositModel depositModel = new DepositModel();
    IuranModel iuranModel = new IuranModel();
    IuranUserModel iuranUserModel = new IuranUserModel();
    List<iuran> listIuran;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_usertType.getItems().add("Admin");
        cb_usertType.getItems().add("Operator");
        cb_usertType.getItems().add("Warga");
        tf_saldo.setText("0");
        
        clv_iuran.setItems(generateSelectedIuranData());
        clv_iuran.setCellFactory(lv->new CheckBoxListCell<iuran>(clv_iuran::getItemBooleanProperty){
            @Override
            public void updateItem(iuran item, boolean empty){
                super.updateItem(item, empty);
                setText(item == null?" ":item.getIuran_Nama());
            }
        });
       
    }    
    private ObservableList<iuran>generateSelectedIuranData(){
        listIuran = iuranModel.getAll();
        ObservableList<iuran> allData = FXCollections.observableArrayList();
        allData.removeAll(allData);
        for (int i = 0; i < listIuran.size(); i++) {
            iuran dataRow = listIuran.get(i);
            allData.add(dataRow);
        }
        return allData;
    }

    @FXML
    private void simpanUser(ActionEvent event) {
        userModel = new UserModel();
        Date date = Date.from(dp_tglLahir.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String tanggal = dateFormat.format(date);
        int insert_id = userModel.insert(new user(tf_username.getText(),
                tf_name.getText(),
                tf_password.getText(),
                tf_address.getText(),
                tf_identity.getText(),
                cb_usertType.getValue(),
                tanggal));
        if(insert_id>0){
            depositModel = new DepositModel();
            depositModel.insert(new deposit(insert_id,Integer.valueOf(tf_saldo.getText())));
            for(iuran iuran : clv_iuran.getItems()){
                if(clv_iuran.getCheckModel().isChecked(iuran)){
                    System.out.println("Pertama true");
                    iuranUserModel.insert(new iuran_user(insert_id, iuran.getIuran_id(), 0));
                    
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"User baru ditambahkan!",ButtonType.OK);
            alert.showAndWait();
            MenuController mc=new MenuController();
            if(alert.getResult()==ButtonType.OK){
                
            }
        }
        
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
