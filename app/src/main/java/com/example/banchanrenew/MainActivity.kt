package com.example.banchanrenew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.banchanrenew.addIngredientsPage.AddIngredientsActivity
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.relation.GramOfUnitCons
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.relation.IngredientsCons
import java.util.concurrent.Executors


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
            TestDatabase::class.java, "test.db3"
        ).allowMainThreadQueries().build()
        if(prefs.getString("version1234","0") == "0") {
            var testDao1: IngredientDAO = db.testDao()
            testDao1.insertGramOfUnitList(GramOfUnitCons().getData())
            testDao1.insertIngredientList(IngredientsCons().getData())
            prefs.setString("version1234","1")
        }

        var list = ArrayList<Ingredient>()
        binding.textViewTest.setOnClickListener {
            val nextIntent = Intent(this, AddIngredientsActivity::class.java)
            startActivity(nextIntent)
        }
    }





}