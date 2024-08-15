package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class ThogaKadePOS {
    private ThogaKadePOS() {
        connection = new ArrayList<>();
    }
    private static ThogaKadePOS instance;
    private List <Customer> connection;

    public static ThogaKadePOS getInstance() {
        return null == instance?instance=new ThogaKadePOS():instance;
//        if(null == instance){
//            return instance = new ThogaKadePOS();
//        }
//        return instance;
    }
    public List<Customer> getConnection(){
        return connection;
    }
}
