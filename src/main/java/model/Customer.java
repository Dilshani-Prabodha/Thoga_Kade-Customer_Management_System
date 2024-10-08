package model;

import javafx.scene.control.ComboBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Customer {

    private String id;
    private String title;
    private String name;
    private String address;
    private String contactNumber;
    private LocalDate dob;
    public Customer(String id, String title, String name, String address, String contactNumber, LocalDate dob) {
        this.id = id;
        this.title = title;
        this.name = title+name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dob = dob;
    }
}
