package nl.group3.techlab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import nl.group3.techlab.R;
import nl.group3.techlab.models.BorrowItem;

public class BorrowItemAdapter extends ArrayAdapter<BorrowItem> {
    public BorrowItemAdapter(Context context, ArrayList<BorrowItem> borrowItems) {
        super(context, 0, borrowItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BorrowItem borrowItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_borrow_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);

        tvName.setText(borrowItem.getItem().getName());
        tvEmail.setText(borrowItem.getUser().getFirstName() + " " + borrowItem.getUser().getLastName());
        tvPhone.setText(borrowItem.getBorrowDate().toString());
        // Populate the data into the template view using the data object
        // Return the completed view to render on screen
        return convertView;
    }
}