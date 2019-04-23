package com.example.borrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.borrow.BorrowItem;
import com.example.borrow.MainActivity;
import com.example.borrow.models.Item;
import com.example.borrow.database.DatabaseHelper;
//import com.example.borrow.models.User;


public class EditItemContents extends AppCompatActivity {
    private static final String TAG = "EditItemContents";

    private Button btnSave, btnDelete, vBorrow, Borrow;
    private EditText eItem, eItemq;
    private TextView ID;

    DatabaseHelper myDB;
    private String selectedName;
    private int selectedID;
    private int selectedquan;


    @Override
    protected void onCreate(@Nullable Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.edit_item_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
//        vBorrow = (Button) findViewById(R.id.vBorrow);
        Borrow = (Button) findViewById(R.id.Borrow);
        eItem = (EditText) findViewById(R.id.eItem);
        eItemq = (EditText) findViewById(R.id.eItemq);

        myDB = new DatabaseHelper(this);
        ID = (TextView) findViewById(R.id.ID);

        Intent receivedIntent = getIntent();

        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("ITEM");
        selectedquan = receivedIntent.getIntExtra("quantity", 0);


        eItem.setText(selectedName);
//
//        vBorrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EditItemContents.this, ViewBorrowedItem.class);
//                startActivity(intent);
//            }
//        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = eItem.getText().toString();
                if (!item.equals("")) {
                    myDB.updateName(item, selectedID, selectedName);
                } else {
                    toastMessage("you must enter a name");
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteName(selectedID, selectedName);
                eItem.setText("");
                toastMessage("removed from database");
            }
        });

        Borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (selectedquan >= 1) {
                    myDB.addBorrow(selectedID,selectedquan);

                    toastMessage("Item has been borrowed");
                }
                else{
                    toastMessage("Item is not available");

                }



            }
        });



    }
        private void toastMessage (String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }