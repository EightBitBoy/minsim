package de.eightbitboy.minsim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import de.eightbitboy.minsim.BuildConfig;
import de.eightbitboy.minsim.data.DaoMaster;
import de.eightbitboy.minsim.data.DaoSession;
import de.eightbitboy.minsim.data.Level;
import de.eightbitboy.minsim.data.LevelDao;
import timber.log.Timber;

final public class Database {

    public static  String DATABASE_NAME = "minsim-db";

    private static DaoSession SESSION;

    private Database(Context context) {
        //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "minsim-db", null);

        DaoMaster.OpenHelper helper;
        if(BuildConfig.DEBUG){
            helper = new DebugOpenHelper(context, DATABASE_NAME);
            Timber.w("Using a DEBUG database!");
        }else{
            helper = new ReleaseOpenHelper(context, DATABASE_NAME);
            Timber.w("Using a RELEASE database!");
        }

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

    public static void seed(SQLiteDatabase db){
        DaoMaster seedMaster = new DaoMaster(db);
        DaoSession seedSession = seedMaster.newSession();

        LevelDao levelDao = seedSession.getLevelDao();

        Level level1 = new Level();
        level1.setNumber(1);
	    level1.setHealth(10);
        levelDao.insert(level1);
    }

    //TODO Close DB when closing the app?
}
