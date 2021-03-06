package com.example.banchanrenew.relation

import com.example.banchanrenew.R
import java.util.*
import kotlin.collections.ArrayList

class IngredientData {
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
                Ingredient(ingredientId++,"파마산치즈","g", R.drawable.pamasancheese,"meat", 0),





                Ingredient(ingredientId++,"배추김치","g", R.drawable.kimchi,"vegetable",0),
                Ingredient(ingredientId++,"당근","당근1개", R.drawable.carrots,"vegetable",0),
                Ingredient(ingredientId++,"오이","오이1개", R.drawable.cucumber,"vegetable",0),
                Ingredient(ingredientId++,"시금치","시금치1단", R.drawable.spinach,"vegetable",0),
                Ingredient(ingredientId++,"단무지","g", R.drawable.danmuji,"vegetable",0),
                Ingredient(ingredientId++,"스타후르츠","근", R.drawable.starfruit,"vegetable",0),
                Ingredient(ingredientId++,"감자","감자1개", R.drawable.potato,"vegetable",0),
                        Ingredient(ingredientId++,"도라지","g",R.drawable.dorage,"vegetable",0),
                        Ingredient(ingredientId++,"대파","대파1대", R.drawable.bigpa,"vegetable",0),

                        Ingredient(ingredientId++,"마늘","마늘1통", R.drawable.onion,"vegetable",0),
                        Ingredient(ingredientId++,"무","무1개", R.drawable.mu,"vegetable",0),
                        Ingredient(ingredientId++,"미나리","미나리1단", R.drawable.minari,"vegetable",0),
                        Ingredient(ingredientId++,"표고버섯","표고버섯1개", R.drawable.pyogo,"vegetable",0),
                        Ingredient(ingredientId++,"배추","배추1포기", R.drawable.baechu,"vegetable",0),
                        Ingredient(ingredientId++,"부추","부추1단", R.drawable.buchu,"vegetable",0),
                        Ingredient(ingredientId++,"고추","고추1개", R.drawable.gochu,"vegetable",0),
                        Ingredient(ingredientId++,"브로콜리","브로콜리1개", R.drawable.brocoli,"vegetable",0),
                        Ingredient(ingredientId++,"생강","생강1톨", R.drawable.sengang,"vegetable",0),
                        Ingredient(ingredientId++,"연근","g", R.drawable.yungen,"vegetable",0),
                        Ingredient(ingredientId++,"우엉","g", R.drawable.ueng,"vegetable",0),
                        Ingredient(ingredientId++,"양파","양파1개", R.drawable.yangpa,"vegetable",0),
                        Ingredient(ingredientId++,"양배추","양배추1통", R.drawable.yangbaechu,"vegetable",0),
                        Ingredient(ingredientId++,"깻잎","깻잎1장", R.drawable.ggatnib,"vegetable",0),
                        Ingredient(ingredientId++,"옥수수","옥수수1큰술", R.drawable.oksusu,"vegetable",0),
                        Ingredient(ingredientId++,"청경채","g", R.drawable.chunggyungchae,"vegetable",0),
                        Ingredient(ingredientId++,"가지","가지1개", R.drawable.gaji,"vegetable",0),
                        Ingredient(ingredientId++,"실파","실파1뿌리", R.drawable.silpa,"vegetable",0),
                        Ingredient(ingredientId++,"애호박","애호박1개", R.drawable.aepumkin,"vegetable",0),
                        Ingredient(ingredientId++,"단호박","단호박1개", R.drawable.danpumkin,"vegetable",0),
                        Ingredient(ingredientId++,"버섯","g", R.drawable.mushroom,"vegetable",0),
                        Ingredient(ingredientId++,"양송이버섯","양송이버섯1개", R.drawable.yangsongyi,"vegetable",0),
                        Ingredient(ingredientId++,"느타리버섯","느타리버섯1묶음", R.drawable.neutari,"vegetable",0),
                        Ingredient(ingredientId++,"피클","피클1개", R.drawable.pikle,"vegetable",0),
                        Ingredient(ingredientId++,"무청","g", R.drawable.mucheng,"vegetable",0),
                        Ingredient(ingredientId++,"상추","상추1장", R.drawable.sangchu,"vegetable",0),
                        Ingredient(ingredientId++,"인삼","g", R.drawable.insam,"vegetable",0),
                        Ingredient(ingredientId++,"홍삼","g", R.drawable.hongsam,"vegetable",0),
                        Ingredient(ingredientId++,"쑥갓","쑥갓1단", R.drawable.ssukgat,"vegetable",0),
                        Ingredient(ingredientId++,"피망","피망1개", R.drawable.pimang,"vegetable",0),
                        Ingredient(ingredientId++,"파프리카","파프리카1개", R.drawable.pafreeca,"vegetable",0),
                        Ingredient(ingredientId++,"열무","열무1단", R.drawable.yulmu,"vegetable",0),
                        Ingredient(ingredientId++,"케일","g", R.drawable.kayle,"vegetable",0),
                        Ingredient(ingredientId++,"콩나물","g", R.drawable.beanamul,"vegetable",0),
                        Ingredient(ingredientId++,"찹쌀","찹쌀1컵", R.drawable.chapssal,"vegetable",0),
                        Ingredient(ingredientId++,"깐밤","깐밤1개", R.drawable.kkanbam,"vegetable",0),
                        Ingredient(ingredientId++,"대추","대추1개", R.drawable.daechu,"vegetable",0),
                        Ingredient(ingredientId++,"잣","잣1큰술", R.drawable.jat,"vegetable",0),
                        Ingredient(ingredientId++,"팥","팥1컵", R.drawable.pat,"vegetable",0),
                        Ingredient(ingredientId++,"동치미","동치미1그릇", R.drawable.dongchimi,"vegetable",0),
                        Ingredient(ingredientId++,"계란","계란1개", R.drawable.egg,"vegetable",0),
                        Ingredient(ingredientId++,"숙주","g", R.drawable.sukju,"vegetable",0),
                        Ingredient(ingredientId++,"두부","두부1모", R.drawable.dubu,"vegetable",0),

                        Ingredient(ingredientId++,"다시마","다시마1장", R.drawable.dasima,"vegetable",0),
                        Ingredient(ingredientId++,"미역","미역1컵", R.drawable.miyuk,"vegetable",0),
                        Ingredient(ingredientId++,"방울토마토","g", R.drawable.bangultomato,"vegetable",0),
                        Ingredient(ingredientId++,"케이퍼","g", R.drawable.kayper,"vegetable",0),
                        Ingredient(ingredientId++,"그린올리브","그린올리브1개", R.drawable.greenolive,"vegetable",0),
                        Ingredient(ingredientId++,"블랙올리브","블랙올리브1개", R.drawable.blackolive,"vegetable",0),
                        Ingredient(ingredientId++,"죽순","죽순1개", R.drawable.juksun,"vegetable",0),
                        Ingredient(ingredientId++,"적양배추","g", R.drawable.redyangbaechu,"vegetable",0),
                        Ingredient(ingredientId++,"토마토","토마토1개", R.drawable.tomato,"vegetable",0),
                        Ingredient(ingredientId++,"바질","바질1장", R.drawable.bazil,"vegetable",0),
                        Ingredient(ingredientId++,"꽈리고추","꽈리고추1줌", R.drawable.ggualigochu,"vegetable",0),

                        Ingredient(ingredientId++,"목이버섯","g", R.drawable.mokyi,"vegetable",0),
                        Ingredient(ingredientId++,"파인애플","파인애플1쪽", R.drawable.pineapple,"vegetable",0),
                        Ingredient(ingredientId++,"은행","은행1알", R.drawable.bank,"vegetable",0),
                        Ingredient(ingredientId++,"배","배1개", R.drawable.peer,"vegetable",0),
                        Ingredient(ingredientId++,"갓","갓1단", R.drawable.gat,"vegetable",0),
                        Ingredient(ingredientId++,"순두부","g", R.drawable.sundubu,"vegetable",0),
                        Ingredient(ingredientId++,"콩","콩1컵", R.drawable.kong,"vegetable",0),
                        Ingredient(ingredientId++,"흑임자","g", R.drawable.blackimja,"vegetable",0),
                        Ingredient(ingredientId++,"풋배추","g", R.drawable.putbaechu,"vegetable",0),
                        Ingredient(ingredientId++,"총각무","총각무1단", R.drawable.chonggakmu,"vegetable",0),
                        Ingredient(ingredientId++,"고사리","고사리1줌", R.drawable.gosari,"vegetable",0),
                        Ingredient(ingredientId++,"우거지","g", R.drawable.ugeji,"vegetable",0),
                        Ingredient(ingredientId++,"팽이버섯","팽이버섯1봉", R.drawable.pangyimushroom,"vegetable",0),
                        Ingredient(ingredientId++,"곤약","g", R.drawable.konnyak,"vegetable",0),

                        Ingredient(ingredientId++,"김","김1장", R.drawable.kim,"vegetable",0),
                        Ingredient(ingredientId++,"석이버섯","석이버섯1개", R.drawable.sukyimushroom,"vegetable",0),
                        Ingredient(ingredientId++,"냉이","g", R.drawable.nangyi,"vegetable",0),
                        Ingredient(ingredientId++,"더덕","g", R.drawable.deodeok,"vegetable",0),
                        Ingredient(ingredientId++,"마늘종","g", R.drawable.onionjjong,"vegetable",0),
                        Ingredient(ingredientId++,"메주콩","메주콩1컵", R.drawable.mejukong,"vegetable",0),
                        Ingredient(ingredientId++,"치커리","g", R.drawable.qicurry,"vegetable",0),
                        Ingredient(ingredientId++,"도토리묵","도토리묵1모", R.drawable.dotorimuk,"vegetable",0),
                        Ingredient(ingredientId++,"청포묵","청포묵1모", R.drawable.chungpomuk,"vegetable",0),
                        Ingredient(ingredientId++,"양상추","양상추1장", R.drawable.yangsangchu,"vegetable",0),
                        Ingredient(ingredientId++,"수삼","수삼1뿌리", R.drawable.susam,"vegetable",0),
                        Ingredient(ingredientId++,"콜리플라워","g", R.drawable.coliflower,"vegetable",0),
                        Ingredient(ingredientId++,"딸기","딸기1개", R.drawable.strawberry,"vegetable",0),
                        Ingredient(ingredientId++,"자몽","자몽1개", R.drawable.jamong,"vegetable",0),
                        Ingredient(ingredientId++,"사과","사과1개", R.drawable.apple,"vegetable",0),
                        Ingredient(ingredientId++,"트래비스","g", R.drawable.cucumber,"vegetable",0),
                        Ingredient(ingredientId++,"무순","무순1봉", R.drawable.musun,"vegetable",0),
                        Ingredient(ingredientId++,"녹두","녹두1컵", R.drawable.greenkong,"vegetable",0),
                        Ingredient(ingredientId++,"쑥","g", R.drawable.ssuk,"vegetable",0),
                        Ingredient(ingredientId++,"멥쌀","멥쌀1컵", R.drawable.mapssal,"vegetable",0),
                        Ingredient(ingredientId++,"토란","g", R.drawable.toran,"vegetable",0),
                        Ingredient(ingredientId++,"샐러리","샐러리1대", R.drawable.salary,"vegetable",0),
                        Ingredient(ingredientId++,"완두콩","완두콩1컵", R.drawable.wandukong,"vegetable",0),
                        Ingredient(ingredientId++,"누룽지","누룽지1조각", R.drawable.nurungji,"vegetable",0),
                        Ingredient(ingredientId++,"찬밥","찬밥1공기", R.drawable.chanbab,"vegetable",0),
                        Ingredient(ingredientId++,"고구마줄기","g", R.drawable.gogumajulgi,"vegetable",0),
                        Ingredient(ingredientId++,"곶감","곶감1개", R.drawable.gotgam,"vegetable",0),
                        Ingredient(ingredientId++,"취나물","g", R.drawable.qunamul,"vegetable",0),
                        Ingredient(ingredientId++,"겨자잎","g", R.drawable.gyeja,"vegetable",0),
                        Ingredient(ingredientId++,"달래","g", R.drawable.dalrae,"vegetable",0),
                        Ingredient(ingredientId++,"봄동","g", R.drawable.bomdong,"vegetable",0),
                        Ingredient(ingredientId++,"호두","호두1알", R.drawable.hodu,"vegetable",0),
                        Ingredient(ingredientId++,"레몬","레몬1개", R.drawable.lemon,"vegetable",0),
                        Ingredient(ingredientId++,"고구마","고구마1개", R.drawable.sweetpotato,"vegetable",0),
                        Ingredient(ingredientId++,"오곡곡물","오곡곡물1컵", R.drawable.okock,"vegetable",0),
                        Ingredient(ingredientId++,"호박","g", R.drawable.pumpkin,"vegetable",0),
                        Ingredient(ingredientId++,"실고추","실고추1큰술", R.drawable.silgochu,"vegetable",0),
                        Ingredient(ingredientId++,"두릅","g", R.drawable.dureb,"vegetable",0),
                        Ingredient(ingredientId++,"참나물","g", R.drawable.cucumber,"vegetable",0),
                        Ingredient(ingredientId++,"아스파라거스","아스파라거스1개", R.drawable.aspragus,"vegetable",0),
                        Ingredient(ingredientId++,"풋마늘","풋마늘1대", R.drawable.putgarlic,"vegetable",0),
                        Ingredient(ingredientId++,"체리","g", R.drawable.cherry,"vegetable",0),
                        Ingredient(ingredientId++,"아욱","g", R.drawable.ayuk,"vegetable",0),
                        Ingredient(ingredientId++,"새송이버섯","g", R.drawable.songyi,"vegetable",0),
                        Ingredient(ingredientId++,"파래","g", R.drawable.parae,"vegetable",0),
                        Ingredient(ingredientId++,"오레가노","g", R.drawable.oraegano,"vegetable",0),
                        Ingredient(ingredientId++,"홀토마토","홀토마토1컵", R.drawable.holltomato,"vegetable",0),
                        Ingredient(ingredientId++,"키위","키위1개", R.drawable.kiwi,"vegetable",0),
                        Ingredient(ingredientId++,"해초","g", R.drawable.cucumber,"vegetable",0),
                        Ingredient(ingredientId++,"조","g", R.drawable.jo,"vegetable",0),
                        Ingredient(ingredientId++,"초생강","g", R.drawable.chosenggang,"vegetable",0),
                        Ingredient(ingredientId++,"바나나","바나나1개", R.drawable.banana,"vegetable",0),
                        Ingredient(ingredientId++,"우묵","g", R.drawable.umuck,"vegetable",0),


                Ingredient(ingredientId++,"진간장","큰술", R.drawable.jinganjang,"source",0),
                Ingredient(ingredientId++,"고춧가루","큰술", R.drawable.gochugaru,"source",0),
                Ingredient(ingredientId++,"흑설탕","컵", R.drawable.blacksuger,"source",0),
                Ingredient(ingredientId++,"계피가루","큰술", R.drawable.gaepi,"source",0),
                Ingredient(ingredientId++,"물엿","큰술", R.drawable.mulsuger,"source",0),
                Ingredient(ingredientId++,"간장","큰술", R.drawable.ganjang,"source",0),
                Ingredient(ingredientId++,"카레가루","큰술", R.drawable.currygaru,"source",0),
                Ingredient(ingredientId++,"식초","큰술", R.drawable.siccho,"source",0),
                Ingredient(ingredientId++,"국간장","큰술", R.drawable.gukganjang,"source",0),
                Ingredient(ingredientId++,"찹쌀가루","큰술", R.drawable.chapssalgaru,"source",0),
                Ingredient(ingredientId++,"후춧가루","큰술", R.drawable.huchugaru,"source",0),
                Ingredient(ingredientId++,"깨소금","큰술", R.drawable.ggaesalt,"source",0),
                Ingredient(ingredientId++,"올리브유","큰술", R.drawable.oliveoil,"source",0),
                Ingredient(ingredientId++,"식용유","큰술", R.drawable.sikyongoil,"source",0),
                Ingredient(ingredientId++,"설탕","큰술", R.drawable.suger,"source",0),
                Ingredient(ingredientId++,"소금","큰술", R.drawable.salt,"source",0),
                Ingredient(ingredientId++,"케첩","큰술", R.drawable.ketchup,"source",0),
                Ingredient(ingredientId++,"고추장","큰술", R.drawable.gochujang,"source",0),
                Ingredient(ingredientId++,"다진파","큰술", R.drawable.dajinpa,"source",0),
                Ingredient(ingredientId++,"다진마늘","큰술", R.drawable.dajinmanel,"source",0),
                Ingredient(ingredientId++,"생강즙","큰술", R.drawable.saegangjep,"source",0),
                Ingredient(ingredientId++,"참기름","큰술", R.drawable.chamgirem,"source",0),
                Ingredient(ingredientId++,"녹말가루","큰술", R.drawable.nokmalgaru,"source",0),
                Ingredient(ingredientId++,"배즙","큰술", R.drawable.baejep,"source",0),
                Ingredient(ingredientId++,"청주","큰술", R.drawable.chengju,"source",0),
                Ingredient(ingredientId++,"새우젓","큰술", R.drawable.saewujet,"source",0),
                Ingredient(ingredientId++,"밀가루","컵", R.drawable.milgaru,"source",0),
                Ingredient(ingredientId++,"빵가루","컵", R.drawable.bbanggaru,"source",0),
                Ingredient(ingredientId++,"파슬리","큰술", R.drawable.paseli,"source",0),
                Ingredient(ingredientId++,"청국장","큰술", R.drawable.chenggukjang,"source",0),
                Ingredient(ingredientId++,"멸치젓","컵", R.drawable.myeolchijeot,"source",0),
                Ingredient(ingredientId++,"콩가루","컵", R.drawable.konggaru,"source",0),
                Ingredient(ingredientId++,"된장","큰술", R.drawable.deonjang,"source",0),
                Ingredient(ingredientId++,"깨","큰술", R.drawable.ggae,"source",0),
                Ingredient(ingredientId++,"까나리액젓","큰술", R.drawable.gganri,"source",0),
                Ingredient(ingredientId++,"통깨","큰술", R.drawable.tonggae,"source",0),
                Ingredient(ingredientId++,"고추냉이","큰술", R.drawable.wasabi,"source",0),
                Ingredient(ingredientId++,"버터","큰술", R.drawable.butter,"source",0),
                Ingredient(ingredientId++,"화이트와인","큰술", R.drawable.whitewine,"source",0),
                Ingredient(ingredientId++,"생크림","컵", R.drawable.saengcream,"source",0),
                Ingredient(ingredientId++,"겨자","큰술", R.drawable.gyejasource,"source",0),
                Ingredient(ingredientId++,"레몬즙","큰술", R.drawable.lemonzep,"source",0),
                Ingredient(ingredientId++,"마요네즈","큰술", R.drawable.mayonez,"source",0),
                Ingredient(ingredientId++,"머스타드","큰술", R.drawable.mustard,"source",0),
                Ingredient(ingredientId++,"검은깨","큰술", R.drawable.blackggae,"source",0),
                Ingredient(ingredientId++,"건포도","큰술", R.drawable.gunpodo,"source",0),
                Ingredient(ingredientId++,"오렌지마멀레이드","큰술", R.drawable.orangemamal,"source",0),
                Ingredient(ingredientId++,"강력분","g", R.drawable.strongmilgaru,"source",0),
                Ingredient(ingredientId++,"꿀","큰술", R.drawable.honey,"source",0),
                Ingredient(ingredientId++,"포도씨유","큰술", R.drawable.podooil,"source",0),
                Ingredient(ingredientId++,"튀김가루","큰술", R.drawable.tuigimgaru,"source",0),
                Ingredient(ingredientId++,"쌀가루","큰술", R.drawable.ricegaru,"source",0),
                Ingredient(ingredientId++,"아몬드가루","큰술", R.drawable.amondgaru,"source",0),
                Ingredient(ingredientId++,"슈가파우더","큰술", R.drawable.sugerpauder,"source",0),
                Ingredient(ingredientId++,"들기름","큰술", R.drawable.deloil,"source",0),
                Ingredient(ingredientId++,"감자전분","큰술", R.drawable.gamjajunben,"source",0),
                Ingredient(ingredientId++,"정종","큰술", R.drawable.jungjong,"source",0),
                Ingredient(ingredientId++,"굴소스","큰술", R.drawable.gulsource,"source",0),
                Ingredient(ingredientId++,"건새우가루","큰술", R.drawable.gunsaewugaru,"source",0),
                Ingredient(ingredientId++,"정향","g", R.drawable.junghyang,"source",0),
                Ingredient(ingredientId++,"통계피","g", R.drawable.tonggaepi,"source",0),
                Ingredient(ingredientId++,"맛술","큰술", R.drawable.matsul,"source",0),
                Ingredient(ingredientId++,"통후추","g", R.drawable.tonghuchu,"source",0),
                Ingredient(ingredientId++,"다진양파","큰술", R.drawable.dajinyangpa,"source",0),
                Ingredient(ingredientId++,"녹차분말","큰술", R.drawable.greengaru,"source",0),
                Ingredient(ingredientId++,"양파즙","큰술", R.drawable.yangpazep,"source",0),
                Ingredient(ingredientId++,"홍차티백","g", R.drawable.hongchateebag,"source",0),
                Ingredient(ingredientId++,"무즙","큰술", R.drawable.cucumber,"source",0),
                Ingredient(ingredientId++,"피쉬소스","큰술", R.drawable.fishsource,"source",0),
                Ingredient(ingredientId++,"겨자가루","큰술", R.drawable.gyejagaru,"source",0),
                Ingredient(ingredientId++,"들깨가루","큰술", R.drawable.delggaegaru,"source",0),
                Ingredient(ingredientId++,"땅콩버터","큰술", R.drawable.ddangkongbutter,"source",0),
                Ingredient(ingredientId++,"조청","큰술", R.drawable.honey,"source",0),
                Ingredient(ingredientId++,"당근즙","큰술", R.drawable.danggenzep,"source",0),
                Ingredient(ingredientId++,"시금치즙","큰술", R.drawable.sigemqi,"source",0),
                Ingredient(ingredientId++,"우스터소스","큰술", R.drawable.wustersource,"source",0),
                Ingredient(ingredientId++,"땅콩가루","큰술", R.drawable.ddangkonggaru,"source",0),
                Ingredient(ingredientId++,"핫소스","큰술", R.drawable.hotsource,"source",0),
                Ingredient(ingredientId++,"크림수프","큰술", R.drawable.creamsoup1,"source",0),
                Ingredient(ingredientId++,"이스트","큰술", R.drawable.east,"source",0),
                Ingredient(ingredientId++,"두반장","큰술", R.drawable.dubanjang,"source",0),
                Ingredient(ingredientId++,"조림간장" ,"큰술", R.drawable.jorimganjang,"source",0),
                Ingredient(ingredientId++,"레드와인" ,"큰술", R.drawable.redwine,"source",0),
                Ingredient(ingredientId++,"토마토페이스트" ,"큰술", R.drawable.tomatopaste,"source",0),
                Ingredient(ingredientId++,"일본된장(미소)" ,"큰술", R.drawable.miso,"source",0),
                Ingredient(ingredientId++,"산초가루" ,"큰술", R.drawable.sanchogaru,"source",0),
                Ingredient(ingredientId++,"간수" ,"큰술", R.drawable.gansu,"source",0)






            ))
    }
}