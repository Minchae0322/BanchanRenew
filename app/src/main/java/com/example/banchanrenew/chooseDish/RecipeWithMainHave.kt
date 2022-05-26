package com.example.banchanrenew.chooseDish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivitySelectedBinding
import com.example.banchanrenew.relation.Dish
import com.example.banchanrenew.relation.EssentialIngredients
import com.example.banchanrenew.relation.Ingredient

class RecipeWithMainHave: AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding
    private val dataHave: List<Ingredient> = db.recipeDao().getIngredientMoreThanZero()
    private val makeAbleList: List<Dish> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findRecipeWithMainHave()

        binding.recyclerViewSelected.setHasFixedSize(true)
        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.adapter = RecipeAdapter(makeAbleList)

    }

    fun findRecipeWithMainHave() {
        for(i in 1..470) {
            var isMakeAble = true
            val list: List<EssentialIngredients> = db.recipeDao().getEssentialListWhereDishID(i)
            for(data in list) {
                if(isHave(data)) {
                    continue
                } else {
                    isMakeAble = false
                    break
                }
            }
            if(isMakeAble) {
                makeAbleList.plus(db.recipeDao().getDishWhereId(i))
            }
        }
    }

    private fun isHave(essential: EssentialIngredients): Boolean {
        for(ingredient in dataHave) {
            if(ingredient.remainGram >= essential.essential_gram.toInt()) {
                return true
            } else {
                continue
            }
        }
        return false
    }
}

