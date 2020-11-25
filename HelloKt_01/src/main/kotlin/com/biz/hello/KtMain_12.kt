package com.biz.hello

fun main() {

    // 함수내부에 선언된 지역함수
    // 어떤 변수를 여러가지 연산을 수행한 후 그 결과를 담아야 할 경우
    // 함수를 선언하면 묶인 그룹이 명확해지는 효과
    fun privateSum() : Int {
        return  20+30
    }

    println(privateSum().toString())


    fun privateSum(num1 : Int, num2 : Int) = num1 + num2
    println(privateSum(30,40))



}

