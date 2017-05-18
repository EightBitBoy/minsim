package de.eightbitboy.minsim.database;

import android.content.Context;

final public class Database {

    private static Database INSTANCE;
    private static boolean initialized = false;

    private Database() {
    }

    public static void initialize(Context context) {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new Database();
    }

    public static Database getDB() {
        if (INSTANCE == null) {
            throw new IllegalStateException("The database is not initialized!");
        }
        return INSTANCE;
    }
}
