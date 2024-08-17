package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class SearchCustomerFormController {

    public TextField txtSearcheId;
    @FXML
    private JFXTextField txtSearchHere;

    @FXML
    private TextField txtSearchedAddress;

    @FXML
    private TextField txtSearchedContatcNo;

    @FXML
    private TextField txtSearchedDob;

    @FXML
    private TextField txtSearchedName;

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        searchByCustomerID();
    }

    public void searchByCustomerID() {
        String id = txtSearchHere.getText();
        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        boolean customerFound = false;

        for(Customer customer : customerList) {
            if (id.equals(customer.getId())) {
                System.out.println(customer);
                txtSearcheId.setText(customer.getId());
                txtSearchedName.setText(customer.getName());
                txtSearchedAddress.setText(customer.getAddress());
                txtSearchedContatcNo.setText(customer.getContactNumber());
                txtSearchedDob.setText(String.valueOf(customer.getDob()));
                customerFound = true;
                break;
            }
        }

        if(!customerFound){
                new Alert(Alert.AlertType.ERROR, id+" Customer Not Found...Please Check Again.").show();
                clearFeild();
        }
            txtSearchHere.setText("");
    }

    public void clearFeild(){
        txtSearcheId.setText("");
        txtSearchedName.setText("");
        txtSearchedAddress.setText("");
        txtSearchedAddress.setText("");
        txtSearchedContatcNo.setText("");
        txtSearchedDob.setText("");
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
        clearFeild();
    }
}
