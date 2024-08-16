package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCustomerFormController extends SearchCustomerFormController{

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

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        searchByCustomerID();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
