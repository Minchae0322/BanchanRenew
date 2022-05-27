package com.example.banchanrenew

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.banchanrenew.selectDish.RecipeDAO
import com.example.banchanrenew.relation.*

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
    lateinit var recipeDAO : RecipeDAO

    @Before
    fun createDB() {
        val db = Room.databaseBuilder(
            appContext,
            TestDatabase::class.java,
            "TestDB18"
        ).build()
        testDao = db.testDao()
        recipeDAO = db.recipeDao()
        testDao.delete()
        testDao.delete2()
        testDao.delete3()
        testDao.delete4()
        testDao.insertGramOfUnitList(GramOfUnitCons().getData())
        testDao.insertIngredientList(IngredientsCons().getData())
        testDao.insertDishList(DishCons().getData())
        testDao.insertEssentialList(EssentialCons().getData())

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("돼지고기", testDao.selectNameFromIngredientWhereId(0))
        assertEquals("근", testDao.selectUnitFromIngredient(0))
        assertEquals(1, testDao.selectIdFromIngredientWhereId(1))
        assertEquals("소고기", testDao.selectNameFromIngredientWhereId(1))
        assertEquals("근", testDao.selectUnitFromIngredient(1))
        assertEquals("com.example.banchanrenew", appContext.packageName)

    }

    @Test
    fun test1() {
        testDao.updateTest(600,"돼지갈비")
        assertEquals("돼지갈비",testDao.selectUnitFromIngredientName("돼지갈비"))
        assertEquals(600,testDao.eee2("돼지갈비"))
        assertEquals(449, recipeDAO.getDishListWithMainIngredients()[1])
    }
}