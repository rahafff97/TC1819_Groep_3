package nl.group3.techlab.models;


/*class of item*/
public class Item {
    private String ItemName;
    private String ItemCategorie;
    private String ItemDescription;
    private int ItemQuantity;

    /*giving short names to the names to return when called */
    public Item(String fItem, String fCat, String fDes, int fQuan){
        ItemName = fItem;
        ItemCategorie = fCat;
        ItemDescription = fDes;
        ItemQuantity = fQuan;

    }
    /*get and return the chosen items*/
    public String getItem() {
        return ItemName;
    }

    public String getItemCategorie() {
        return ItemCategorie;
    }

    public String getItemDescription() {
        return ItemDescription;
    }


    public int getItemQuantity() {
        return ItemQuantity;
    }
}
