package de.eightbitboy.minsim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import de.eightbitboy.minsim.data.DaoMaster;
import de.eightbitboy.minsim.data.DaoSession;

final public class Database {

    private static DaoSession SESSION;

    private Database(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "minsim-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        SESSION = master.newSession();
    }

    public static void initialize(Context context) {
        if (SESSION != null) {
            return;
        }
        new Database(context);
    }

    public static DaoSession getSession() {
        if (SESSION == null) {
            throw new IllegalStateException("The database is not initialized!");
        }
        return SESSION;
    }
}
