package com.biz.hello


class Standard(data : Int){}
class Standard1 private constructor(){}

class Empty
class Empty1 private constructor(){}

class PropertyClass(val firNamt : String, val lasName : String){}

fun main() {
    var st = Standard(20)
    //println(st.date)
    var em = Empty()
    var pc = PropertyClass("홍","길동")
    println("${pc.firNamt + pc.lasName}")
}