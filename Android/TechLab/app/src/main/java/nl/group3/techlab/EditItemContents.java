package nl.group3.techlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import nl.group3.techlab.database.DatabaseHelper;
import nl.group3.techlab.view.ViewBorrowedItem;

/*edit the items/ delete/save/borrow*/
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
        /*this is from the viewitem contents listview that takes data directly from the database making the defaultvalue obsolete*/
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("ITEM");
        selectedquan = receivedIntent.getIntExtra("quantity", 0);

        /*get the text you selected*/
        eItem.setText(selectedName);
//
//        vBorrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EditItemContents.this, ViewBorrowedItem.class);
//                startActivity(intent);
//            }
//        });

        /*update function that updates the name when pressed save*/
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

        /*delete function deletes the chosen row when pressed*/
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteName(selectedID, selectedName);
                eItem.setText("");
                toastMessage("removed from database");
            }
        });
        /*borrow function only borrows when the item has above 0 quantity only 1 borrow for each time you try*/
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

        Borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int fQuan = Integer.parseInt(eItemq.getText().toString());

//                if (fQuan != 0) {
//                    myDB.insertBorrow(selectedID);
                myDB.addBorrow(selectedID);

                toastMessage("Item has been borrowed");
//                }
//                else{
//                    toastMessage("Item is not available");
//
//                }



            }
        });



        /*short statement for toast to create quick toast*/
    }
    private void toastMessage (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
