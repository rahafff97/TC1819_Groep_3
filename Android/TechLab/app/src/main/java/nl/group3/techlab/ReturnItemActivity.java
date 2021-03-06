package nl.group3.techlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import nl.group3.techlab.adapters.ReturnItemAdapter;
import nl.group3.techlab.database.ItemDatabaseHelper;
import nl.group3.techlab.models.BorrowItem;
import nl.group3.techlab.models.StockItem;
import nl.group3.techlab.models.User;

public class ReturnItemActivity extends AppCompatActivity {
    ArrayList<BorrowItem> borrowedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_in);

        LoadDatabaseData();

        ListView lv = findViewById(R.id.listViewBorrowItem);
        lv.setAdapter(new ReturnItemAdapter(getBaseContext(), borrowedItems));

    }
    public void LoadDatabaseData(){
        ItemDatabaseHelper myDB = new ItemDatabaseHelper(this);
        borrowedItems = new ArrayList<BorrowItem>(Arrays.asList(myDB.getBorrowedItems(new User(1, "John", "Doe"), false)));
        for(BorrowItem item : borrowedItems){
            ArrayList<StockItem> stock = new ArrayList<StockItem>(Arrays.asList(myDB.getStockItem(item.getItem())));
            Log.d("ReturnItemActivity", stock.get(0).getItem().getName() + " - " + stock.get(0).getStock() + " - " + stock.get(0).getBroken());
        }

    }

}
