package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UpdateCustomerFormController extends SearchCustomerFormController{

    public ComboBox cmbTitle;
    @FXML
    private JFXTextField txtSearchHere;

    @FXML
    private TextField txtSearcheId;

    @FXML
    private TextField txtSearchedAddress;

    @FXML
    private TextField txtSearchedContatcNo;

    @FXML
    private TextField txtSearchedDob;

    @FXML
    private TextField txtSearchedName;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clearFeild();
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
    void btnSearchOnAction(ActionEvent event) {
        searchByCustomerID();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        updateCustomerDetails();

    }

    private void updateCustomerDetails() {
        String id = txtSearcheId.getText();
        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        boolean customerFound = false;

        for (Customer customer : customerList){
            if(id.equals(customer.getId())){
                customer.setId(txtSearcheId.getText());
                customer.setTitle((String) cmbTitle.getValue());
                customer.setName(txtSearchedName.getText());
                customer.setAddress(txtSearchedAddress.getText());
                customer.setContactNumber(txtSearchedContatcNo.getText());
                customer.setDob(LocalDate.parse(txtSearchedDob.getText()));
                customerFound = true;

                new Alert(Alert.AlertType.INFORMATION, "Customer details updated successfully!").show();
                break;
            }
        }

        if(!customerFound){
            new Alert(Alert.AlertType.ERROR, id+" Customer not Found...Please Check Again.").show();
        }
        clearFeild();
    }
}
