package nl.group3.techlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import nl.group3.techlab.adapters.BorrowItemAdapter;
import nl.group3.techlab.database.ItemDatabaseHelper;
import nl.group3.techlab.models.BorrowItem;
import nl.group3.techlab.models.User;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_in);
        ItemDatabaseHelper myDB = new ItemDatabaseHelper(this);

        ListView lv = findViewById(R.id.listViewBorrowItem);
        lv.setAdapter(new BorrowItemAdapter(getBaseContext(), new ArrayList<BorrowItem>(Arrays.asList(myDB.getBorrowedItems(new User(1, "John", "Doe"))))));


    }
}
