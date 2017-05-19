package de.eightbitboy.minsim.data;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import de.eightbitboy.minsim.data.Level;
import de.eightbitboy.minsim.data.LevelDao;

public class LevelTest extends AbstractDaoTestLongPk<LevelDao, Level> {

    public LevelTest() {
        super(LevelDao.class);
    }

    @Override
    protected Level createEntity(Long key) {
        Level entity = new Level();
        entity.setId(key);
        entity.setNumber();
        return entity;
    }

}
