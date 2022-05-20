package com.example.banchanrenew

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var appContext = InstrumentationRegistry.getInstrumentation().targetContext
    lateinit var testDao : IngredientDAO

    @Before
    fun createDB() {
        val db = Room.databaseBuilder(
            appContext,
            TestDatabase::class.java,
            "historyDB"
        ).build()
        testDao = db.testDao()
        testDao.delete()
        testDao.delete2()
        testDao.insertGramOfUnit(GramOfUnit("바보야",615))
        testDao.insertIngredient(Ingredient(3, "야채", "바보야", 1234567891,"Meat"))

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals(3, testDao.find1Ingredient(3))
        assertEquals(615, testDao.findJoinIngredient(3))
        assertEquals("com.example.banchanrenew", appContext.packageName)

    }
}