package com.lannstark.lec02

fun main() {
    // safe call
    val str: String? = "ABC"
//    println(str.length) // 불가능
    // safe call = null이 아니면 ?뒤에 있는 친구를 실행하고, null이면 실행하지 않는다(그 값 자체가 null).
    println(str?.length) // 가능(null 아닌 경우만 호출해줘~ null이면 null임)

    // elvis(?:) 연산자
    // 앞의 연산 결과가 null이면 (?:)뒤의 값을 사용
    println(str?.length ?: 0)

    println(startsWith("BC"))

    // 자바와 병행시(Person class)
    val person = Person(null)
    // 자바에서 쓰는 어노테이션을 코틀린에서도 이해를 한다. 그래서 @Nullable같은 어노테이션 등 이해
    // 만약 Person의 getName에서 @Nullable | @NotNull이 없다면 name이 nullable한지 아닌지 구별이 안간다.
    // 이를 **플랫폼 타입**이라고 한다. 코틀린이 null 관련 정보를 알 수 없는 타입이다.
    // 이때 알 수 없다보니 우선은 실행되게 해준다. 근데 실제로 null이 들어오면 런타임에서 NPE가 터진다.
    // 코틀린에서 자바코드 실행시 유의해야한다. 그래서 코드를 읽으며 null 가능성을 확인하거나, 코틀린으로 한번 래핑해서 단일 지점으로 만들자
    startsWithA(person.name)
}

// nullable한 것은 ?가 붙음
// 함수 리턴 타입도 TS처럼 fun funName(param): return type 이다.
// nullable인지 구별함으로써 완전히 다른 취급이 가능하다.
fun startsWithA1(str: String?): Boolean {
    // 자바 -> 코틀린
//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다")
//    }
//    return str.startsWith("A")

    // 코틀린 답게(safe call + elvis)
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")
}

fun startsWithA2(str: String?): Boolean? {
    // 자바 -> 코틀린
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")

    // 코틀린 답게
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    // 자바 -> 코틀린
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")

    // 코틀린 답게
    return str?.startsWith("A") ?: false
}

// 아래는 무조건 null이 아님(str에 무조건 null이 들어올 수 없다.)
fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

// elvis 연산은 early return에도 사용할 수 있다.
fun calculate(number: Long?): Long {
//    if (number == null) return 0

    return number ?: return 0

    // 다음 로직 ~
}

// null이 아님을 단언. nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}