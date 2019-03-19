package nl.group3.techlab.models;

import java.util.Date;

public class BorrowItem {

    Item item;
    User user;
    Date startDate;
    Date endDate;

    public BorrowItem(Item item, User user, Date startDate, Date endDate){
        this.item = item;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Item getItem() {
        return item;
    }

    public User getUser() {
        return user;
    }

    public Date getBorrowDate() {
        return startDate;
    }

    public Date getReturnDate() {
        return endDate;
    }
}
