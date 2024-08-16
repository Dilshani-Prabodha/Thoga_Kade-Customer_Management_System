package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

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
                txtSearcheId.setText("");
                txtSearchedName.setText("");
                txtSearchedAddress.setText("");
                txtSearchedAddress.setText("");
                txtSearchedContatcNo.setText("");
                txtSearchedDob.setText("");
        }
            txtSearchHere.setText("");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }
}
