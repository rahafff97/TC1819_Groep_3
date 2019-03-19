package nl.group3.techlab.models;

public class StockItem {
    Item item;
    int stock;
    int broken;

    public StockItem(Item item, int stock, int broken){
        this.item = item;
        this.broken = broken;
        this.stock = stock;
    }

    public Item getItem() {
        return item;
    }

    public int getStock() {
        return stock;
    }

    public int getBroken() {
        return broken;
    }
}
