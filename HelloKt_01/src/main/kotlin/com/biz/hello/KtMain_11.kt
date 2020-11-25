package com.biz.hello

fun main() {

    // kt에서는 자료형이 지정되지 않은 변수에 null값을 지정하면 안된다
    // 반드시 자료형을 지정하고 자료형 뒤에 ? 첨가해야 한다.1
    var arrVar = null
    println(arrVar)

    // Any 키워드는 모든 타입의 값을 지정할수 있는 변수
    // object type 변수
    var arrVar1 : Any = 123
    arrVar1 = "Korea"
    arrVar1 = 30.2F

    // Any type 저장된 값의 자료형이 무었이냐?
    when(arrVar1){
        is String -> println("문자열형")
        is Int -> println("Int 형")
        is Float -> println("Float 형")
        is Double -> println("Double 형")
        else -> println("모르겠는데!!")

    }



}