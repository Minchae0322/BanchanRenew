package com.example.banchanrenew

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.relation.*
import com.example.banchanrenew.selectDish.RecipeActivity
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
            TestDatabase::class.java, "test.db14"
        ).allowMainThreadQueries().build()
        if(prefs.getString("version32","0") == "0") {
            var testDao1: IngredientDAO = db.testDao()
            testDao1.insertGramOfUnitList(GramOfUnitCons().getData())
            testDao1.insertIngredientList(IngredientsCons().getData())
            testDao1.insertDishList(DishCons().getData())
            testDao1.insertEssentialList(EssentialCons().getData())
            try {
                jsonParser()
            } catch (e: JSONException) {

            }
            prefs.setString("version32","1")
            testDao1.updateTest(600,"돼지갈비")
            testDao1.updateTest(600,"소고기")
            testDao1.updateTest(600,"돼지고기")
            testDao1.updateTest(600,"양고기")
            testDao1.updateTest(600,"소세지")
        }










        var list = ArrayList<Ingredient>()
        binding.textViewTest.setOnClickListener {
            val nextIntent = Intent(this, RecipeActivity::class.java)
            startActivity(nextIntent)
        }


    }

     private fun jsonParser() {
        val jsonStringArr: Array<String> = arrayOf(
            assets.open("recipe1_1000").reader().readText(),
            assets.open("recipe1001_1996").reader().readText(),
            assets.open("recipe1997_2993").reader().readText(),
            assets.open("recipe2994_").reader().readText()
        )


        for(element in jsonStringArr) {
            try {
                val jObject = JSONObject(element)
                val grid: JSONObject = jObject.getJSONObject("Grid_20150827000000000228_1")
                val jArray = grid.getJSONArray("row")
                for(row in 0..jArray.length()) {
                    val jsonObject = jArray.getJSONObject(row)
                    db.testDao().insertRecipe(Recipe(jsonObject.getInt("RECIPE_ID"),jsonObject.getInt("COOKING_NO"), jsonObject.getString("COOKING_DC")))
                }
            } catch (e: JSONException) {

            }
        }
    }





}