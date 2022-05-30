package com.example.banchanrenew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.banchanrenew.addIngredientsPage.AddIngredientsActivity
import com.example.banchanrenew.selectDish.SelectDishActivity
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.fridge.FridgeActivity
import com.example.banchanrenew.fridge.FridgeAdapter
import com.example.banchanrenew.relation.*


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
            TestDatabase::class.java, "test.db5"
        ).allowMainThreadQueries().build()
        if(prefs.getString("version23","0") == "0") {
            var testDao1: IngredientDAO = db.testDao()
            testDao1.insertGramOfUnitList(GramOfUnitCons().getData())
            testDao1.insertIngredientList(IngredientsCons().getData())
            testDao1.insertDishList(DishCons().getData())
            testDao1.insertEssentialList(EssentialCons().getData())
            prefs.setString("version23","1")
            testDao1.updateTest(600,"돼지갈비")
            testDao1.updateTest(600,"소고기")
            testDao1.updateTest(600,"돼지고기")
            testDao1.updateTest(600,"양고기")
            testDao1.updateTest(600,"소세지")
        }



        var list = ArrayList<Ingredient>()
        binding.textViewTest.setOnClickListener {
            val nextIntent = Intent(this, AddIngredientsActivity::class.java)
            startActivity(nextIntent)
        }
    }





}