package com.example.loginsystem.History;

import android.support.v7.util.DiffUtil;

import com.example.loginsystem.History.HistoryItem;

import java.util.List;

public class HistoryItemDiffCallback extends DiffUtil.Callback  {

    private List<HistoryItem> mOldList;
    private List<HistoryItem> mNewList;

    public HistoryItemDiffCallback(List<HistoryItem> oldList, List<HistoryItem> newList) {
        this.mOldList = oldList;
        this.mNewList = newList;
    }
    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        // add a unique ID property on Contact and expose a getId() method
        return mOldList.get(oldItemPosition).getID() == mNewList.get(newItemPosition).getID();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        HistoryItem oldHistoryItem = mOldList.get(oldItemPosition);
        HistoryItem newHistoryItem = mNewList.get(newItemPosition);

        if (oldHistoryItem.getName() == newHistoryItem.getName() && oldHistoryItem.isAvailable() == newHistoryItem.isAvailable()) {
            return true;
        }
        return false;
    }
}