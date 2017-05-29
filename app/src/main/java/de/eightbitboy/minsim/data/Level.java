package de.eightbitboy.minsim.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Level extends RealmObject {
    @PrimaryKey
    public long id;
    public int number;
    public long health;

    public boolean isMined() {
        return health <= 0;
    }
}
