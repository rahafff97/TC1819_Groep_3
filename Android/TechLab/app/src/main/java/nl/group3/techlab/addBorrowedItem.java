package nl.group3.techlab;
import nl.group3.techlab.database.DatabaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import nl.group3.techlab.view.ViewBorrowedItem;

public class addBorrowedItem extends AppCompatActivity {
    private static final String TAG = "BorrowItem";


    private Button vBorrow,Borrow;

    private String ItemName;
    private String Username;
    private int selectedID;

    DatabaseHelper myDB;

    @Override
    protected  void onCreate(@Nullable Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.edit_item_layout);
        vBorrow = (Button) findViewById(R.id.vBorrow);
        Borrow = (Button) findViewById(R.id.Borrow);
        myDB = new DatabaseHelper(this);


        vBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addBorrowedItem.this, ViewBorrowedItem.class);
                startActivity(intent);
            }
        });




    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
