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
/* list adapter borrowed while made is the same as the fourcollumn adapter and connects with the borrowed_items xml
 at the moment its not initialized because its the return of items that has already been made.*/
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
            TextView IDName = (TextView) convertView.findViewById(R.id.ID);
//            TextView UserName = (TextView) convertView.findViewById(R.id.UserName);




            if(IDName != null){
                IDName.setText((borrowItem.getID()));

            }
//            if(UserName != null){
//                UserName.setText((borrowItem.getFirstName()));
//
//            }
        }
        return convertView;
    }

}
