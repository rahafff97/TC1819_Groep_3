
package com.example.borrow;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;


        import java.util.ArrayList;

public class ViewBorrowedItem extends ArrayAdapter<Item> {

    private LayoutInflater mInflater;
    private ArrayList<Item> items;
    private int mViewResourceID;

    public ViewBorrowedItem(Context context, int textViewResourceId, ArrayList<Item> items){
        super(context,textViewResourceId,items);
        this.items = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceID = textViewResourceId;

    }
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mInflater.inflate(mViewResourceID,null);

        Item item = items.get(position);

        if(item != null){
            TextView ItemName = (TextView) convertView.findViewById(R.id.eItem);
            TextView UserName = (TextView) convertView.findViewById(R.id.UserName);




            if(ItemName != null){
                ItemName.setText((item.getItem()));

            }
            if(UserName != null){
                UserName.setText((item.getItemCategorie()));

            }
        }
        return convertView;
    }

}
