
package nl.group3.techlab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "items.db";
    public static final String TABLE_NAME = "items_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM";
    public static final String COL3 = "ITEMCATEGORIE";
    public static final String COL4 = "ITEMDESCRIPTION";
    public static final String COL5 = "ITEMQUANTITY";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    private static final String TAG = "DatabaseHelper";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM TEXT, ITEMCATEGORIE TEXT, ITEMDESCRIPTION TEXT, ITEMQUANTITY INT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String fItem, String fcat, String fdes, int fQuan ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, fItem);
        contentValues.put(COL3, fcat);
        contentValues.put(COL4, fdes);
        contentValues.put(COL5, fQuan);




        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }



    public Cursor getItemID(String ITEM){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + "FROM" + TABLE_NAME +
                "WHERE" + COL2 + " = " + ITEM + "'";
        Cursor data = db.rawQuery(query, null);
        return data;

    }

    public void updateName(String newName, int ID, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + ID + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }
    public void deleteName(int ID, String ITEM){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + ID + "'" +
                " AND " + COL2 + " = '" + ITEM + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + ITEM + " from database.");
        db.execSQL(query);
    }

}


