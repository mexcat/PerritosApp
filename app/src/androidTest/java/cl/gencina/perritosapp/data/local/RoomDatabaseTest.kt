package cl.gencina.perritosapp.data.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import com.google.common.truth.Truth.assertThat

//test unitario
class RoomDatabaseTest {

        @get:Rule
        var instantExecutorRule = InstantTaskExecutorRule()

        private lateinit var breedsDao: RazaDao
        private lateinit var db: RazaDatabase

        @Before
        fun setUp() {
            val context = ApplicationProvider.getApplicationContext<Context>()
            db = Room.inMemoryDatabaseBuilder(context, RazaDatabase::class.java).build()
            breedsDao = db.RazaDao()
        }

        @After
        fun tearDown() {
            db.close()
        }

        @Test
        fun insertBreeds_empty() = runBlocking {
            // Given
            val breedList = listOf<RazaEntity>()

            // When
            breedsDao.insertList(breedList)

            // Then A
            val it = breedsDao.getAll().getOrAwaitValue()
                assertNotEquals(it, null)
            //o
                assertThat(it).isNotNull()

                assertEquals(it.size, 0)
            //o
                assertThat(it).isEmpty()

            // Then B
            breedsDao.getAll().observeForever {
                assertThat(it).isNotNull()
                assertThat(it).isEmpty()
            }
        }

        @Test
        fun insertBreeds_happyCase_1element() = runBlocking {
            // Given
            val breedList = listOf(RazaEntity("breed1"))

            // When
            breedsDao.insertList(breedList)

            // Then
            breedsDao.getAll().observeForever {
                assertThat(it).isNotNull()
                assertThat(it).isNotEmpty()
                assertThat(it).hasSize(1)
            }
        }

        @Test
        fun insertBreeds_happyCase_3elements() = runBlocking {
            // Given
            val breedList = listOf(RazaEntity("breed1"), RazaEntity("breed2"), RazaEntity("breed3"))

            // When
            breedsDao.insertList(breedList)

            // Then
            breedsDao.getAll().observeForever {
                assertThat(it).isNotNull()
                assertThat(it).isNotEmpty()
                assertThat(it).hasSize(3)
            }
        }
    }


    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(value: T) {
                data = value
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        try {
            afterObserve.invoke()

            // Don't wait indefinitely if the LiveData is not set.
            if (!latch.await(time, timeUnit)) {
                throw TimeoutException("LiveData value was never set.")
            }

        } finally {
            this.removeObserver(observer)
        }

        @Suppress("UNCHECKED_CAST")
        return data as T


}