package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.util.Iterator;
import java.util.List;

public class DeleteCustomerFormController extends SearchCustomerFormController{

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

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        searchByCustomerID();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtSearcheId.getText();
        if(id.isEmpty()){
            new Alert(Alert.AlertType.WARNING, "No Customer ID to Delete").show();
            return;
        }

        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        Iterator<Customer> iterator = customerList.iterator();
        boolean customerDeleted = false;

        while (iterator.hasNext()){
            Customer customer = iterator.next();
            if(id.equals(customer.getId())){
                iterator.remove();
                new Alert(Alert.AlertType.INFORMATION, id+" Customer deleted Successfully").show();
                clearFeild();
                customerDeleted = true;
                break;
            }
        }
        if(!customerDeleted){
            new Alert(Alert.AlertType.ERROR, id+" Customer not Found...Please Check Again...");
        }
    }
}
