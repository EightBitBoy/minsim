package de.eightbitboy.minsim.data

import androidx.room.Database
import androidx.room.RoomDatabase
import de.eightbitboy.minsim.data.entities.Mine
import de.eightbitboy.minsim.data.entities.MineDao

@Database(entities = [Mine::class], version = 1)
abstract class Db : RoomDatabase() {
	abstract fun mineDao(): MineDao
}
