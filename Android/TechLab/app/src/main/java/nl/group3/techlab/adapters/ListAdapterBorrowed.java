package nl.group3.techlab.adapters;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;


        import nl.group3.techlab.BorrowItem;
        import nl.group3.techlab.R;

        import java.util.ArrayList;

public class ListAdapterBorrowed extends ArrayAdapter<BorrowItem> {

    private LayoutInflater mInflater;
    private ArrayList<BorrowItem> borrowItemArrayList;
    private int mViewResourceID;

    public ListAdapterBorrowed(Context context, int textViewResourceId, ArrayList<BorrowItem> items){
        super(context,textViewResourceId,items);
        this.borrowItemArrayList = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceID = textViewResourceId;

    }
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mInflater.inflate(mViewResourceID,null);

        BorrowItem borrowItem = borrowItemArrayList.get(position);

        if(borrowItem != null){
            TextView ItemName = (TextView) convertView.findViewById(R.id.eItem);
            TextView UserName = (TextView) convertView.findViewById(R.id.UserName);




            if(ItemName != null){
                ItemName.setText((borrowItem.getItem()));

            }
            if(UserName != null){
                UserName.setText((borrowItem.getFirstName()));

            }
        }
        return convertView;
    }

}
