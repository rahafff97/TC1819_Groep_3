package com.example.borrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditItemContents extends AppCompatActivity {
    private static final String TAG = "EditItemContents";

    private Button btnSave,btnDelete;
    private EditText eItem;

    DatabaseHelper myDB;

    private String selectedName;
    private int selectedID;



    @Override
    protected  void onCreate(@Nullable Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.edit_item_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        eItem = (EditText) findViewById(R.id.eItem);
        myDB = new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");

        eItem.setText(selectedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = eItem.getText().toString();
                if(!item.equals("")){
                    myDB.updateName(item,selectedID,selectedName);
                }else {
                    toastMessage("you must enter a name");
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteName(selectedID,selectedName);
                eItem.setText("");
                toastMessage("removed from database");
            }
        });


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
