package com.example.loginsystem.History;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loginsystem.R;

import java.util.List;

public class HistoryItemsAdapter extends
        RecyclerView.Adapter<HistoryItemsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
        }
    }

    // Store a member variable for the contacts
    private List<HistoryItem> mHistoryItems;

    // Pass in the contact array into the constructor
    public HistoryItemsAdapter(List<HistoryItem> items) {
        mHistoryItems = items;
    }
    // Usually involves inflating a layout from XML and returning the holder
//    @NonNull
    @Override
    public HistoryItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View HistoryView = inflater.inflate(R.layout.history_item_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(HistoryView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(HistoryItemsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        HistoryItem histItem = mHistoryItems.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(histItem.getName());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mHistoryItems.size();
    }
    public void swapItems(List<HistoryItem> contacts) {
        // compute diffs
        final HistoryItemDiffCallback diffCallback = new HistoryItemDiffCallback(this.mHistoryItems, contacts);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        // clear contacts and add
        this.mHistoryItems.clear();
        this.mHistoryItems.addAll(contacts);

        diffResult.dispatchUpdatesTo(this); // calls adapter's notify methods after diff is computed
    }
}

