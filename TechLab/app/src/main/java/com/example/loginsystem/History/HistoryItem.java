package com.example.loginsystem.History;

import java.util.ArrayList;
import java.util.UUID;

public class HistoryItem{
    private String mName;
    private boolean mAvailable;
    UUID mID;

    private HistoryItem(String name, boolean available) {
        mName = name;
        mAvailable = available;
        mID = UUID.randomUUID();
    }

    public String getName() {
        return mName;
    }

    public boolean isAvailable() {
        return mAvailable;
    }

    public UUID getID(){
        return mID;
    }

    private static int lastItemId = 0;

    public static ArrayList<HistoryItem> createContactsList(int numItems) {
        ArrayList<HistoryItem> items = new ArrayList<HistoryItem>();
        for (int i = 1; i <= numItems; i++) {
            items.add(new HistoryItem("History Item " + ++lastItemId, i <= numItems / 2));
        }
        return items;
    }
}
