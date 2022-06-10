# BanchanRenew
Todo 이제 데이터베이스 정의 다 끝냈으니 MainActivity 부터 databaseDao 완성해가면서 하나씩 하기 네이버에 APP3.9 다시 다운받아서 보면서 하기 
5-23 addIngredient부분 데이터 삽입하고 다 완성됐으니 recyclerView테스트 해보고 viewPager 테스트 해보면 된다.
json 데이터 처리
6-8 레시피_재료정보 자료 추가하고 json 파싱 후 데이터베이스에 넣기 그 다음 cell_content부분 만들기
6-9 재료정보 json 파싱 함수 리팩토링과 database 초기설정 속도가 느려서 list에 담은 후 데이터베이스에 한번만 접근 하도록 설정
//todo recipe content 디자인하고 요리 정보 추가, 레시피 안에 사진 url 어떻게 처리할지 고민 database에 자주 i/o 할때 어떻게 더 빨리 처리할 수 있는지 고민
6-10 recipe content 디자인 중간 완료, activity전환 tabLayout 설정, intent 처리할때 task 관련 menifest 수정(액티비티가 한번만 불러지게)
//todo 레시피 안에 사진 url 어떻게 처리할지 고민 database에 자주 i/o 할때 어떻게 더 빨리 처리할 수 있는지 고민, recipeActivity가 초기화면으로 불러올 수 있게 설정하고
//todo recipeActivity 메뉴화면 설정

