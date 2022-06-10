package com.example.banchanrenew

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.banchanrenew.addIngredientsPage.AddIngredientsActivity
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.fridge.FridgeActivity
import com.example.banchanrenew.relation.*
import com.example.banchanrenew.selectDish.RecipeActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var db: TestDatabase
        lateinit var prefs: PreferenceUtil


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = PreferenceUtil(applicationContext)
        db = Room.databaseBuilder(
            applicationContext,
            TestDatabase::class.java, "test.db18"
        ).allowMainThreadQueries().build()
        if(prefs.getString("version36","0") == "0") {
            var testDao1: IngredientDAO = db.testDao()
            testDao1.insertGramOfUnitList(GramOfUnitCons().getData())
            testDao1.insertIngredientList(IngredientsCons().getData())
            testDao1.insertDishList(DishCons().getData())
            testDao1.insertEssentialList(EssentialCons().getData())
            try {
                jsonParser()
            } catch (e: JSONException) {
            }
            prefs.setString("version36","1")
            testDao1.updateTest(600,"돼지갈비")
            testDao1.updateTest(600,"소고기")
            testDao1.updateTest(600,"돼지고기")
            testDao1.updateTest(600,"양고기")
            testDao1.updateTest(600,"소세지")
        }










        var list = ArrayList<Ingredient>()
        initTabLayout()



    }

    fun initTabLayout() {
        binding.constraintLayoutRecipe.setOnClickListener {
            val nextIntent = Intent(this, RecipeActivity::class.java)
            startActivity(nextIntent)
        }

        binding.constraintLayoutAddIngredient.setOnClickListener {
            val nextIntent = Intent(this, AddIngredientsActivity::class.java)
            startActivity(nextIntent)
        }

        binding.constraintLayoutFridge.setOnClickListener {
            val nextIntent = Intent(this, FridgeActivity::class.java)
            startActivity(nextIntent)
        }
    }



    private fun jsonFileToJsonObject(fileName: String, objectName: String):JSONObject {
        val assetManager: AssetManager = applicationContext.resources.assets
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
             db.testDao().insertRecipeList(list)
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
             db.testDao().insertIngredientDCList(list)
         }
    }

    private fun insertJsonObjectToDB() {

    }





}