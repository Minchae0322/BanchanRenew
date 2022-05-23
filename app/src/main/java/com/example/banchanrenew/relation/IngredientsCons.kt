package com.example.banchanrenew.relation

import com.example.banchanrenew.R
import java.util.*
import kotlin.collections.ArrayList

class IngredientsCons {
    companion object {
        var ingredientId : Int = 0
    }

    fun getData(): List<Ingredient> {
        return ArrayList(
            listOf(
                Ingredient(ingredientId++,"돼지고기","근", R.drawable.pork,"meat", 0),
                Ingredient(ingredientId++,"소고기","근",R.drawable.beef,"meat", 0),
                Ingredient(ingredientId++,"양고기","근",R.drawable.lamb,"meat", 0),
                Ingredient(ingredientId++,"닭고기","닭고기1마리",R.drawable.chicken,"meat", 0),
                Ingredient(ingredientId++,"오리고기","오리고기1마리",R.drawable.duck,"meat", 0),
                Ingredient(ingredientId++,"고등어","고등어1마리",R.drawable.fish_godeng,"meat", 0),
                Ingredient(ingredientId++,"꽁치","꽁치1마리",R.drawable.fish_ggongqi,"meat", 0),
                Ingredient(ingredientId++,"꽁치통조림","꽁치통조림1캔",R.drawable.ggongqican,"meat", 0),
                //한줌 g
                Ingredient(ingredientId++,"멸치","g",R.drawable.fish_myulqi,"meat", 0),
                Ingredient(ingredientId++,"장어","장어1마리",R.drawable.fish_jange,"meat", 0),
                Ingredient(ingredientId++,"연어","g",R.drawable.fish_salmon,"meat", 0),
                Ingredient(ingredientId++,"문어","g",R.drawable.fish_octopus,"meat", 0),
                Ingredient(ingredientId++,"낙지","낙지1마리",R.drawable.fish_nakgi,"meat", 0),
                Ingredient(ingredientId++,"오징어","오징어1마리",R.drawable.fish_squid,"meat", 0),
                Ingredient(ingredientId++,"게","게1마리",R.drawable.fish_crab,"meat", 0),
                //새우 한마리 g
                Ingredient(ingredientId++,"새우","새우1마리",R.drawable.fish_shirump,"meat", 0),
                Ingredient(ingredientId++,"굴","g",R.drawable.fish_oyster,"meat", 0),
                Ingredient(ingredientId++,"생태","생태1마리",R.drawable.fish_sengtae,"meat", 0),
                Ingredient(ingredientId++, "꼴뚜기", "g", R.drawable.fish_ggolttugi, "meat", 0),
                Ingredient(ingredientId++,"쭈꾸미","g",R.drawable.fish_jjuggumi,"meat", 0),
                //한봉지 g
                //개 그램
                Ingredient(ingredientId++,"모시조개","g",R.drawable.fish_mosijogae,"meat", 0),
                Ingredient(ingredientId++,"잔멸치","잔멸치1컵",R.drawable.fish_janmyulqi,"meat", 0),
                Ingredient(ingredientId++,"갈치","갈치1마리",R.drawable.fish_galqi,"meat", 0),
                Ingredient(ingredientId++,"동태","동태1마리",R.drawable.fish_dongtae,"meat", 0),
                Ingredient(ingredientId++,"대구","g",R.drawable.fish_daegu,"meat", 0),
                Ingredient(ingredientId++,"홍합","홍합1개",R.drawable.fish_honghap,"meat", 0),
                Ingredient(ingredientId++,"갈비","g",R.drawable.galbi,"meat", 0),
                Ingredient(ingredientId++,"바지락","바지락1봉지",R.drawable.fish_bajilak,"meat", 0),
                Ingredient(ingredientId++,"통북어","통북어1개",R.drawable.fish_tongbuke,"meat", 0),
                Ingredient(ingredientId++,"유부","유부1장",R.drawable.ubu,"meat", 0),
                Ingredient(ingredientId++,"해파리","g",R.drawable.fish_hepari,"meat", 0),
                Ingredient(ingredientId++,"게맛살","게맛살1팩",R.drawable.gaematsal,"meat", 0),
                Ingredient(ingredientId++,"아귀","아귀1마리",R.drawable.fish_agui,"meat", 0),
                Ingredient(ingredientId++,"조기","조기1마리",R.drawable.fish_jogi,"meat", 0),
                Ingredient(ingredientId++,"명란","명란1개",R.drawable.fish_myunglan,"meat", 0),
                Ingredient(ingredientId++,"선지","g",R.drawable.sunji,"meat", 0),
                Ingredient(ingredientId++,"장조림","g",R.drawable.jangjorim,"meat", 0),
                Ingredient(ingredientId++,"양","g",R.drawable.yang,"meat", 0),
                Ingredient(ingredientId++,"소(잡뼈)","g",R.drawable.cowbone,"meat", 0),
                Ingredient(ingredientId++,"양지머리","g",R.drawable.yangji,"meat", 0),
                Ingredient(ingredientId++,"도가니","도가니1개",R.drawable.dogani,"meat", 0),
                Ingredient(ingredientId++,"사골","g",R.drawable.sagol,"meat", 0),
                Ingredient(ingredientId++,"마른오징어","마른오징어1마리",R.drawable.fish_drysquid,"meat", 0),
                Ingredient(ingredientId++,"칵테일새우","g",R.drawable.fish_kaktail,"meat", 0),
                Ingredient(ingredientId++,"돼지갈비","g",R.drawable.porkgalbi,"meat", 0),
                Ingredient(ingredientId++,"참치","참치1캔",R.drawable.chanqican,"meat", 0),
                Ingredient(ingredientId++,"라면","라면1개",R.drawable.ramyun,"meat", 0),
                Ingredient(ingredientId++,"햄","g",R.drawable.ham,"meat", 0),
                Ingredient(ingredientId++,"골뱅이통조림","골뱅이통조림1캔",R.drawable.golbangyi,"meat", 0),
                Ingredient(ingredientId++,"베이컨","베이컨1줄",R.drawable.bacon,"meat", 0),
                Ingredient(ingredientId++,"스파게티면","g",R.drawable.spagati,"meat", 0),
                //프랑크
                Ingredient(ingredientId++,"소세지","소세지1개",R.drawable.sausage,"meat", 0),
                Ingredient(ingredientId++,"우동면","우동면1봉지",R.drawable.udong,"meat", 0),
                Ingredient(ingredientId++,"곱창","g",R.drawable.gobchang,"meat", 0),
                Ingredient(ingredientId++,"미더덕","g",R.drawable.mideduck,"meat", 0),
                Ingredient(ingredientId++,"육수용멸치","육수용멸치1줌",R.drawable.yuksumyulqi,"meat", 0),
                Ingredient(ingredientId++,"말린새우","g",R.drawable.dryshirmp,"meat", 0),
                Ingredient(ingredientId++,"생선살","g",R.drawable.fishsal,"meat", 0),
                Ingredient(ingredientId++,"대하","대하1마리",R.drawable.bigshrimp,"meat", 0),
                Ingredient(ingredientId++,"코다리","코다리1마리",R.drawable.codari,"meat", 0),
                Ingredient(ingredientId++,"콘플레이크","콘플레이크1컵",R.drawable.conflake,"meat", 0),
                Ingredient(ingredientId++,"비엔나소세지","비엔나소세지1개",R.drawable.biannasausage,"meat", 0),
                Ingredient(ingredientId++,"인절미","g",R.drawable.injulmi,"meat", 0),
                Ingredient(ingredientId++,"바게트","바게트1개",R.drawable.bagate,"meat", 0),
                Ingredient(ingredientId++,"소면","소면1인분",R.drawable.sumyun,"meat", 0),
                Ingredient(ingredientId++,"닭다리","닭다리1개",R.drawable.chickenleg,"meat", 0),
                Ingredient(ingredientId++,"옥수수통조림","옥수수통조림1큰술",R.drawable.corncan,"meat", 0),
                Ingredient(ingredientId++,"완두콩통조림","완두콩통조림1큰술",R.drawable.wanducan,"meat", 0),
                Ingredient(ingredientId++,"순대","g",R.drawable.sundae,"meat", 0),
                Ingredient(ingredientId++,"쌀국수","g",R.drawable.ssalmyun,"meat", 0),
                Ingredient(ingredientId++,"해삼","g",R.drawable.fish_haesam,"meat", 0),
                Ingredient(ingredientId++,"파스타","g",R.drawable.pasta,"meat", 0),
                Ingredient(ingredientId++,"라이스페이퍼","라이스페이퍼1장",R.drawable.riecpaper,"meat", 0),
                Ingredient(ingredientId++,"냉동만두","냉동만두1봉지",R.drawable.mandu,"meat", 0),
                Ingredient(ingredientId++,"소고기스톡","소고기스톡1컵",R.drawable.beefstock,"meat", 0),
                Ingredient(ingredientId++,"메밀국수","g",R.drawable.memilmyun,"meat", 0),
                Ingredient(ingredientId++,"맛조개","g",R.drawable.fish_matjogae,"meat", 0),
                Ingredient(ingredientId++,"잔새우","g",R.drawable.janshrimp,"meat", 0),
                Ingredient(ingredientId++,"칼국수면","g", R.drawable.kalguksu,"meat", 0),
                Ingredient(ingredientId++,"만두피","만두피1장", R.drawable.mandupee,"meat", 0),
                Ingredient(ingredientId++,"어묵","어묵1개", R.drawable.emuk,"meat", 0),
                Ingredient(ingredientId++,"국수","g", R.drawable.kuksu,"meat", 0),
                Ingredient(ingredientId++,"당면","g", R.drawable.dangmyun,"meat", 0),
                Ingredient(ingredientId++,"우유","우유1큰술", R.drawable.milk,"meat", 0),
                Ingredient(ingredientId++,"치즈","치즈1장", R.drawable.cheeze,"meat", 0),
                Ingredient(ingredientId++,"식빵","식빵1장", R.drawable.sikbbang,"meat", 0),
                Ingredient(ingredientId++,"가래떡","가래떡1줄", R.drawable.garaedduk,"meat", 0),
                Ingredient(ingredientId++,"떡국떡","떡국떡1컵", R.drawable.dduckgukdduck,"meat", 0),
                Ingredient(ingredientId++,"모짜렐라치즈","g", R.drawable.mozzarella,"meat", 0),
                Ingredient(ingredientId++,"파마산치즈","g", R.drawable.pamasancheese,"meat", 0)
            ))
    }
}