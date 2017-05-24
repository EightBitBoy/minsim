package de.eightbitboy.minsim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import de.eightbitboy.minsim.data.DaoMaster;


public class DebugOpenHelper extends DaoMaster.DevOpenHelper{
    public DebugOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
        Database.seed(db);
    }

    @Override
    public void onUpgrade(org.greenrobot.greendao.database.Database db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
        DaoMaster.dropAllTables(db, true);
        onCreate(db);
    }
}
