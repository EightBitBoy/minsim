package de.eightbitboy.minsim.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mine(
	@PrimaryKey var uid: Int,
	@ColumnInfo(name = "level") val level: Int
)
