package nl.group3.techlab;

import java.util.Date;

public class BorrowItem {
    public String firstName;
    public String ItemName;



    public BorrowItem(String fItem, String user){
        ItemName = fItem;
        firstName = user;

    }
    public String getItem() {
        return ItemName;
    }

    public String getFirstName() {
        return firstName;
    }

}