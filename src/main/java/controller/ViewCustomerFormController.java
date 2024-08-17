package controller;

import db.ThogaKadePOS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNumber;
    public TableColumn colDob;
    @FXML
    private ComboBox<?> cmbViewTitle;

    @FXML
    private DatePicker dateViewDob;

    @FXML
    private TextField txtViewAddress;

    @FXML
    private TextField txtViewContactNumber;

    @FXML
    private TextField txtViewId;

    @FXML
    private TextField txtViewName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        loardTable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            setTextToValue((Customer) newValue);
        });
    }

    private void setTextToValue(Customer newValue){
        txtViewId.setText(newValue.getId());
        //cmbViewTitle.setValue(newValue.getTitle());
        txtViewName.setText(newValue.getName());
        txtViewAddress.setText(newValue.getAddress());
        txtViewContactNumber.setText(newValue.getContactNumber());
        dateViewDob.setValue(newValue.getDob());
    }

    @FXML
    void btnReloardOnAction(ActionEvent event) {
        loardTable();
    }

    public void loardTable(){
        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        ObservableList<Customer> customerObsevableList = FXCollections.observableArrayList();
        customerList.forEach(obj->{
            customerObsevableList.add(obj);
        });
        tblCustomer.setItems(customerObsevableList);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/dash_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING, "Error : "+e);
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }


}
