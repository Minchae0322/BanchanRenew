package com.example.banchanrenew

import android.content.res.AssetManager
import android.util.Log
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.banchanrenew.selectDish.RecipeDAO
import com.example.banchanrenew.relation.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.InputStream

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
            "TestDB22"
        ).build()
        testDao = db.testDao()
        recipeDAO = db.recipeDao()
        testDao.delete()
        testDao.delete2()
        testDao.delete3()
        testDao.delete4()
        testDao.delete5()
        testDao.delete6()
        testDao.insertGramOfUnitList(GramOfUnitCons().getData())
        testDao.insertIngredientList(IngredientsCons().getData())
        testDao.insertDishList(DishCons().getData())
        testDao.insertEssentialList(EssentialCons().getData())


    }

    @Test
    fun useAppContext() {
        val jsonRecipeObjectList: MutableList<JSONObject> = mutableListOf()
        jsonRecipeObjectList.add(jsonFileToJsonObject("recipe1_1000","Grid_20150827000000000228_1"))


        for(jsonFileObject in jsonRecipeObjectList) {
            val list: MutableList<Recipe> = mutableListOf()
            val jArray = jsonObjectToJsonArray(jsonFileObject,"row")
            for(row in 0 until jArray.length()) {
                val jsonRecipeObject = jArray.getJSONObject(row)
                list.add(Recipe(jsonRecipeObject.getInt("RECIPE_ID"),jsonRecipeObject.getInt("COOKING_NO"), jsonRecipeObject.getString("COOKING_DC")))
                Log.d("number", row.toString())

            }
            testDao.insertRecipeList(list)
        }


    }


    @Test
    fun test1() {
        testDao.updateTest(600,"돼지갈비")
        assertEquals("돼지갈비",testDao.selectUnitFromIngredientName("돼지갈비"))
        assertEquals(600,testDao.eee2("돼지갈비"))
        assertEquals(449, recipeDAO.getDishListWithMainIngredients()[1])
    }

    @Test
    fun test2() {
        try {
            jsonParser()
        } catch (e: JSONException) {

        }
        val ingredientDC = testDao.getIngredientDCFromDCNum(1060)
        assertEquals("물",ingredientDC.ingredientDCName)
        assertEquals(1060,ingredientDC.ingredientDCNum)
        assertEquals("부재료",ingredientDC.ingredientDCType)

    }

    private fun jsonFileToJsonObject(fileName: String, objectName: String):JSONObject {
        val assetManager: AssetManager = appContext.resources.assets
        val inputStream = assetManager.open(fileName)
        val jObject = JSONObject(inputStream.bufferedReader().use { it.readText() })
        return jObject.getJSONObject(objectName)
    }

    private fun jsonObjectToJsonArray(jObject: JSONObject, arrayName: String): JSONArray {
        return jObject.getJSONArray(arrayName)
    }

    private fun jsonParser() {
        val jsonRecipeObjectList: MutableList<JSONObject> = mutableListOf()
        jsonRecipeObjectList.add(jsonFileToJsonObject("recipe1_1000","Grid_20150827000000000228_1"))
        jsonRecipeObjectList.add(jsonFileToJsonObject("recipe1001_1996","Grid_20150827000000000228_1"))
        jsonRecipeObjectList.add(jsonFileToJsonObject("recipe1997_2993","Grid_20150827000000000228_1"))
        jsonRecipeObjectList.add(jsonFileToJsonObject("recipe2994_","Grid_20150827000000000228_1"))

        for(jsonFileObject in jsonRecipeObjectList) {
            val list: MutableList<Recipe> = mutableListOf()
            val jArray = jsonObjectToJsonArray(jsonFileObject,"row")
            for(row in 0 until jArray.length()) {
                val jsonRecipeObject = jArray.getJSONObject(row)
                list.add(Recipe(jsonRecipeObject.getInt("RECIPE_ID"),jsonRecipeObject.getInt("COOKING_NO"), jsonRecipeObject.getString("COOKING_DC")))
            }
            testDao.insertRecipeList(list)
        }

        val jsonDCObjectList: MutableList<JSONObject> = mutableListOf()
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC1","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC2","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC3","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC4","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC5","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC6","Grid_20150827000000000227_1"))
        jsonDCObjectList.add(jsonFileToJsonObject("ingredientDC7","Grid_20150827000000000227_1"))


        for(jsonFileObject in jsonDCObjectList) {
            val jArray = jsonObjectToJsonArray(jsonFileObject,"row")
            val list: MutableList<IngredientDC> = mutableListOf()
            for(row in 0 until jArray.length()) {
                val jsonDCObject = jArray.getJSONObject(row)
                list.add(IngredientDC(jsonDCObject.getInt("RECIPE_ID"),
                    jsonDCObject.getInt("IRDNT_SN"),jsonDCObject.getString("IRDNT_NM"),
                    jsonDCObject.getString("IRDNT_CPCTY"), jsonDCObject.getString("IRDNT_TY_NM")))
            }
            testDao.insertIngredientDCList(list)
        }
    }


}