package com.example.banchanrenew

import android.content.res.AssetManager
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.banchanrenew.Ingredient.IngredientsFragment
import com.example.banchanrenew.dao.IngredientDAO
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.fridge.FridgeFragment
import com.example.banchanrenew.recipeMenu.SelectDishFragment
import com.example.banchanrenew.relation.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragmentRunningNum: Int = 0
    companion object {
        lateinit var db: TestDatabase
        lateinit var prefs: PreferenceUtil
        var DISPLAY_WITH = 0
        var DISPLAY_HEIGHT = 0

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = PreferenceUtil(applicationContext)
        db = Room.databaseBuilder(
            applicationContext,
            TestDatabase::class.java, "test.db25"
        ).allowMainThreadQueries().build()
        if(prefs.getString("version43","0") == "0") {
            var testDao1: IngredientDAO = db.testDao()
            testDao1.insertGramOfUnitList(GramOfUnitData().getData())
            testDao1.insertIngredientList(IngredientData().getData())
            testDao1.insertDishList(RecipeData().getData())
            testDao1.insertEssentialList(MainIngredientData().getData())
            try {
                jsonParser()
            } catch (e: JSONException) {
            }
            prefs.setString("version43","1")
            testDao1.updateRemainGramOfIngredient(600,"돼지갈비")
            testDao1.updateRemainGramOfIngredient(600,"소고기")
            testDao1.updateRemainGramOfIngredient(600,"돼지고기")
            testDao1.updateRemainGramOfIngredient(600,"양고기")
            testDao1.updateRemainGramOfIngredient(600,"소세지")
        }

        var list = ArrayList<Ingredient>()
        bindViews()
        initTabLayout()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SelectDishFragment())
            .commit()
    }

    private fun updateUnClicked(clickedFragmentNum: Int) {
        if(clickedFragmentNum != fragmentRunningNum) {
            when(fragmentRunningNum) {
                0 -> {
                    binding.ivTabChangeToRecipeActivity.setImageResource(R.drawable.recipe_unclicked)
                    binding.tvTabChangeToRecipeActivity.setTextColor(Color.parseColor("#8C8C8C"))
                }
                1 -> {
                    binding.ivTabChangeToAddIngredientActivity.setImageResource(R.drawable.ingrdtfinal_uncliked)
                    binding.tvTabChangeToAddIngredientActivity.setTextColor(Color.parseColor("#8C8C8C"))
                }
                2 -> {
                    binding.ivTabChangeToFridgeActivity.setImageResource(R.drawable.fridge_uncliked)
                    binding.tvTabChangeToFridgeActivity.setTextColor(Color.parseColor("#8C8C8C"))
                }
            }
        }
    }

    private fun updateClicked(clickedFragmentNum: Int) {
        if(clickedFragmentNum != fragmentRunningNum) {
            when(clickedFragmentNum) {
                0 -> {
                    binding.ivTabChangeToRecipeActivity.setImageResource(R.drawable.recipe2222)
                    binding.tvTabChangeToRecipeActivity.setTextColor(Color.parseColor("#CD1818"))
                }
                1 -> {
                    binding.ivTabChangeToAddIngredientActivity.setImageResource(R.drawable.ingrdtfinal)
                    binding.tvTabChangeToAddIngredientActivity.setTextColor(Color.parseColor("#CD1818"))
                }
                2 -> {
                    binding.ivTabChangeToFridgeActivity.setImageResource(R.drawable.fridge)
                    binding.tvTabChangeToFridgeActivity.setTextColor(Color.parseColor("#CD1818"))
                }
            }
        }
    }

    private fun bindViews() {
        binding.ivTabChangeToRecipeActivity.setImageResource(R.drawable.recipe2222)
        binding.tvTabChangeToRecipeActivity.setTextColor(Color.parseColor("#CD1818"))
        binding.ivTabChangeToAddIngredientActivity.setImageResource(R.drawable.ingrdtfinal_uncliked)
        binding.tvTabChangeToAddIngredientActivity.setTextColor(Color.parseColor("#8C8C8C"))
        binding.ivTabChangeToFridgeActivity.setImageResource(R.drawable.fridge_uncliked)
        binding.tvTabChangeToFridgeActivity.setTextColor(Color.parseColor("#8C8C8C"))
    }

    private fun initTabLayout() {
        binding.constraintLayoutRecipe.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SelectDishFragment())
                .commit()
            updateUnClicked(0)
            updateClicked(0)
            fragmentRunningNum = 0
        }

        binding.constraintLayoutAddIngredient.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, IngredientsFragment())
                .commit()
            updateUnClicked(1)
            updateClicked(1)
            fragmentRunningNum = 1
        }

        binding.constraintLayoutFridge.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FridgeFragment())
                .commit()
            updateUnClicked(2)
            updateClicked(2)
            fragmentRunningNum = 2
        }
    }



    private fun jsonFileToJsonObject(fileName: String, objectName: String):JSONObject {
        val assetManager: AssetManager = applicationContext.resources.assets
        val inputStream = assetManager.open(fileName)
        val jObject = JSONObject(inputStream.bufferedReader().use { it.readText() })
        return jObject.getJSONObject(objectName)
    }

    fun setDisplaySize() {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        MainActivity.DISPLAY_WITH = size.x
        MainActivity.DISPLAY_HEIGHT = size.y
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
             val list: MutableList<RecipeDescription> = mutableListOf()
             val jArray = jsonObjectToJsonArray(jsonFileObject,"row")
             for(row in 0 until jArray.length()) {
                 val jsonRecipeObject = jArray.getJSONObject(row)
                 list.add(RecipeDescription(jsonRecipeObject.getInt("RECIPE_ID"),jsonRecipeObject.getInt("COOKING_NO"), jsonRecipeObject.getString("COOKING_DC")))
             }
             db.recipeDao().insertRecipeDCList(list)
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

}