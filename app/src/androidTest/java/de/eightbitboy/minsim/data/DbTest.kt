package de.eightbitboy.minsim.data

import android.content.Context
import androidx.room.Room
import de.eightbitboy.minsim.data.entities.MineDao
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
	private lateinit var mineDao: MineDao
	private lateinit var db: Db

	@Before
	fun createDb() {
		val context = ApplicationProvider.getApplicationContext<Context>()
		db = Room.inMemoryDatabaseBuilder(context, Db::class.java).build()
		mineDao = db.mineDao()
	}

	/*
	@After
	@Throws(IOException::class)
	fun closeDb() {
		db.close()
	}

	@Test
	@Throws(Exception::class)
	fun writeUserAndReadInList() {
		val user: User = TestUtil.createUser(3).apply {
			setName("george")
		}
		userDao.insert(user)
		val byName = userDao.findUsersByName("george")
		assertThat(byName.get(0), equalTo(user))
	}
	*/
}
