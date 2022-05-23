package com.example.banchanrenew

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.banchanrenew.relation.GramOfUnitCons
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.relation.IngredientsCons

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
class Test2 {
    var appContext = InstrumentationRegistry.getInstrumentation().targetContext
    lateinit var testDao : IngredientDAO

    @Before
    fun createDB() {
        val db = Room.databaseBuilder(
            appContext,
            TestDatabase::class.java,
            "TestDB7"
        ).build()
        testDao = db.testDao()
        testDao.delete()
        testDao.delete2()
        testDao.insertGramOfUnitList(GramOfUnitCons().getData())
        testDao.insertIngredientList(IngredientsCons().getData())
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals(1, testDao.selectIdFromIngredientWhereId(1))
        assertEquals("돼지고기", testDao.selectNameFromIngredientWhereId(1))
        assertEquals("근", testDao.selectUnitFromIngredient(1))
        assertEquals(2, testDao.selectIdFromIngredientWhereId(2))
        assertEquals("소고기", testDao.selectNameFromIngredientWhereId(2))
        assertEquals("근", testDao.selectUnitFromIngredient(2))
        assertEquals("com.example.banchanrenew", appContext.packageName)

    }
}