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

    //TODO handle migrations
    //http://stackoverflow.com/questions/13373170/greendao-schema-update-and-data-migration
    //https://dzone.com/articles/how-to-set-up-database-migrations-with-greendao
    //https://piercezaifman.com/how-to-setup-database-migrations-with-greendao/
    //search: sqlite database migration

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

    //TODO Close DB when closing the app?
}
