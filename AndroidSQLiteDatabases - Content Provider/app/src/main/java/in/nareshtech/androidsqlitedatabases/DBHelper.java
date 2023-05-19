package in.nareshtech.androidsqlitedatabases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pavan.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "person";
    public static final String COL_1 = "person_id";
    public static final String COL_2 = "person_name";
    public static final String COL_3 = "person_age";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creates the database tables for you
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "create table "+TABLE_NAME+"("+COL_1+" integer primary key autoincrement, "+COL_2+" text, "+COL_3+" integer);";
        db.execSQL(query);
    }

    // This works when there is a version change
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table "+TABLE_NAME);
        onCreate(db);
    }

    public void insertData(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * from "+TABLE_NAME,null);
    }
}
