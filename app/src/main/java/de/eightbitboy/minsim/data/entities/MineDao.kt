package de.eightbitboy.minsim.data.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MineDao {
	@Query("SELECT * FROM mine")
	fun getAll(): List<Mine>

	@Query(
		"SELECT * FROM mine WHERE uid IN (:mineIds)"
	)
	fun loadAllByIds(mineIds: IntArray): List<Mine>

	@Query(
		"SELECT * FROM mine WHERE level = :level LIMIT 1"
	)
	fun findByLevek(level: Int): Mine

	@Insert
	fun insertAll(vararg mines: Mine)

	@Delete
	fun delete(mine: Mine)
}
