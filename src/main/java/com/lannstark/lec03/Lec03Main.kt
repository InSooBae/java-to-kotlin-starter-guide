package com.lannstark.lec03


/*
    Any - Java의 Object 역할(모든 객체의 최상위 타입
    모든 primitive 타입의 최상위 타입도 Any이다.
    Any 자체로는 null을 포함할 수 없어 null 포함시키고 싶다면 Any? 로 표현
    Any에 equals / hashCode / toString 존재
 */

/*
    Unit - Java의 void와 동일한 역할(타입 추론덕분에 생략가능)
    void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
        - 제네릭에서 void는 void 제네릭을 사용하려면 Void클래스를 이용
        - Unit은 그냥 Unit 이용
    함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미.
    즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
 */

/*
    Nothing - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    무조건 예외를 반환하는 함수 / 무한 루프 함수 등
 */
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
fun main() {
    // 코틀린에서는 명시적 형변환이다. 자바의 암시적 형변환이 아닌
    val number1 = 3
    val number2: Long = number1.toLong()

    // 변수가 nullable이면 적절히 처리가 필요하다.
    val num1: Int? = 2
    val num2: Long = num1?.toLong() ?: 0L

    // NPE -> 정상작동하려면 as 뒤에 ?로 safe call로 만듦
    printAgeIfPersonNullable(Person("",100))

    // String interpolation / String indexing
    val person = Person("배인수", 100)
    val name = person.name
    println("이름 : ${person.name}")
    // 변수이용시 $로만 가능하나 가독성, 일괄 변환, 정규식 활용 등 여러모로 ${}로 통일성 있게 이용하는 것이 좋다.
    println("이름 : $name")

    // 여러 줄에 걸친 문자열을 작성해야할 때 큰따옴표 세 개 """를 사용하면 편하게 할 수 있다.
    val str = """
        ABC
        EFG
        ${name}
    """.trimIndent() // 인덴트 제거
    println(str)

    // 문자열에서 특정 문자 가져오기
    println(str[0])
    println(str[2])
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        // obj를 person 타입으로 간주한다. (생략 가능)
//        val person = obj as Person
//        println(person.age)
        // 위 코드가 아래처럼 간단하게도 가능 -> 스마트 캐스트 (if 안에 들어왔으니 해당 타입이겠구나!!)
        println(obj.age)
    }
}

fun printAgeIfNotPerson(obj: Any) {
    // not is 를 is 앞에 !로 가능하다.
    if (obj !is Person) {

    }
}

fun printAgeIfPersonNullable(obj: Any?) {
    // obj가 null | 해당 타입이 아니면 -> null
    val person = obj as? Person
    println(person?.age)
}

