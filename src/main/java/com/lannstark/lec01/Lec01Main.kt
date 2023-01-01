package com.lannstark.lec01

class Lec01Main {
    fun main() {
        // 모든 변수에 var | val을 붙혀줘야 한다.
        var number: Int
        // var 변경 가능, val 변경 불가능
        var number1 = 10L
        // Long으로 reference 타입으로 보일 수 있으나 코틀린에서 자동적으로(상황에 따라) primitive or reference로 바꿈
        // -> 프로그래머가 boxing, unboxing 고려를 안할 수 있다.
        // primitive , reference 타입 구분 안해도 된다.
        val number2 : Long = 10L

        // 코틀린에서 변수는 null을 갖을 수 없지만 가능하게 하려면 -> 타입?
        var number3 : Long? = null

        // 코틀린에서 객체 인스턴스화할 때 new 붙이지 않아야 한다.
        var person = Person("배인수")
    }
}