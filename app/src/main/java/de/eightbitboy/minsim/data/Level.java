package de.eightbitboy.minsim.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Level {
    @Id
    public Long id;
    public int number;
}
