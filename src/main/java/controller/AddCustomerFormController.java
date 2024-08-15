package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogaKadePOS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

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

        Customer customer = new Customer(id, title, name, address, contactNumber, dob);
        System.out.println(customer);

        List<Customer> customerList = ThogaKadePOS.getInstance().getConnection();
        customerList.add(customer);

        Clear();

    }

    public void Clear(){
        txtId.setText("");
        cmbTitle.setValue("Title");
        txtName.setText("");
        txtAddress.setText("");
        txtContactNumber.setText("");
       // dateDob.setValue("");
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }
}
