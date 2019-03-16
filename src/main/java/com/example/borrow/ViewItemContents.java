package com.example.borrow;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewItemContents extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<Item> itemList;
    ListView listView;
    Item item;
    private static final String TAG = "FourColumn_ListAdapter";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);


        myDB = new DatabaseHelper(this);

        itemList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if (numRows == 0){
            Toast.makeText(ViewItemContents.this, "Database is empty", Toast.LENGTH_LONG).show();
        }else{

            while(data.moveToNext()){
                item = new Item( data.getString(1),data.getString(2),data.getString(3),data.getInt(4) );
                itemList.add(item);
            }
            FourColumn_ListAdapter adapter = new FourColumn_ListAdapter(this, R.layout.content_adapter_view,itemList);
            listView =  findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {


                 Item item  = (Item)adapterView.getItemAtPosition(i);
                 String itemText = item.getItem();

                Toast.makeText(view.getContext(), "clicked on item[" + itemText + "]",

                        Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onItemClick You clicked on " + itemText);

                Cursor data = myDB.getItemID(itemText);
                int ID = -1;


                while(data.moveToNext()){
                    ID = data.getInt(0);
                }
                if (ID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + ID);
                    Intent editScreenIntent = new Intent(ViewItemContents.this, EditItemContents.class);
                    editScreenIntent.putExtra("id", ID);
                    editScreenIntent.putExtra("ITEM", itemText);
                    startActivity(editScreenIntent);

                }
                else{
                    Toast.makeText(view.getContext(), "no ID associated with that name",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
