package com.example.loginsystem.History;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.loginsystem.History.HistoryItem;
import com.example.loginsystem.History.HistoryItemsAdapter;
import com.example.loginsystem.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<HistoryItem> historyItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_history);

    // Lookup the recyclerview in activity layout
    RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

    // Initialize contacts
    historyItems = HistoryItem.createContactsList(20);
    // Create adapter passing in the sample user data
    HistoryItemsAdapter adapter = new HistoryItemsAdapter(historyItems);
    // Attach the adapter to the recyclerview to populate items
    rvContacts.setAdapter(adapter);
    // Set layout manager to position the items
    rvContacts.setLayoutManager(new LinearLayoutManager(this));
    // That's all!
    }
}

