package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Mrs.");
        titles.add("Miss.");
        cmbTitle.setItems(titles);
    }

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDob;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String title = cmbTitle.getValue();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNumber = txtContactNumber.getText();
        LocalDate dob = dateDob.getValue();

        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        boolean isExistsId = customerList.stream().anyMatch(customer -> customer.getId().equals(id));

        if(isExistsId){
            new Alert(Alert.AlertType.WARNING, "Customer ID "+id+" already exists. Please use a different ID.").show();
            txtId.setText("");
        }else {
            Customer customer = new Customer(id, title, name, address, contactNumber, dob);
            System.out.println(customer);

            customerList.add(customer);

            new Alert(Alert.AlertType.INFORMATION, id+" Customer added successfully...").show();
            clear();
        }
    }

    public void clear(){
        txtId.setText("");
        cmbTitle.setValue("Title");
        txtName.setText("");
        txtAddress.setText("");
        txtContactNumber.setText("");
       // dateDob.setValue("");
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clear();
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
}
