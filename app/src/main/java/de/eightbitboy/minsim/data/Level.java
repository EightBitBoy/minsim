package de.eightbitboy.minsim.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Level extends RealmObject {

    @PrimaryKey
    private long id;
    private long health;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public boolean isMined() {
        return health <= 0;
    }
}
