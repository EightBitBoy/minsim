package de.eightbitboy.minsim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import de.eightbitboy.minsim.data.DaoMaster;


public class DebugOpenHelper extends DaoMaster.DevOpenHelper{
    public DebugOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
    }
}
