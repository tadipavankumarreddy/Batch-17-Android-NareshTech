package in.nareshtech.multiplelanguages;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "PersonalDetails";
    public static final String COL_0 = "farmer_id";
    public static final String COL_1 = "farmer_name";

    public DBhelper(@Nullable Context context) {
        super(context, "Pavan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLE_NAME+"("+COL_0+" integer primary key autoincrement, "+COL_1+" text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+TABLE_NAME, null);
        onCreate(db);
    }

    // insert
    public void insertData(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }

    // Get
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("Select * from "+TABLE_NAME, null);
    }

}
