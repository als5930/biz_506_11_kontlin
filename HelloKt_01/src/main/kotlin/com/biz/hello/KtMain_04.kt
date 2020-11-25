package com.biz.hello

import java.util.*

fun main(){

    val scan = Scanner(System.`in`)

    print("구의 반지름 >>")
    val strRedlus = scan.nextLine()
    val dRedlus = strRedlus.toDouble()

    // 구의 면적
    val area : Double = dRedlus * Math.PI * 4.0

    // 구의 부피
    val volume : Double = (dRedlus * dRedlus) * (4/3).toDouble() * Math.PI

    println("반지름이 $dRedlus 인 구의 면적 : $area, 부피 : $volume")


}