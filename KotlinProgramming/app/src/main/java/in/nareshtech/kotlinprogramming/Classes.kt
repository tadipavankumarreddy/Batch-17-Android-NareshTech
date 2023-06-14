package `in`.nareshtech.kotlinprogramming

open class Shape{
    fun greetMe(){
        print("Good Morning")
    }
}

class Rectangle(val a: Int, val b:Int, val c:Int) : Shape(){
    fun perimeter():Int{
        return a*b*c
    }
}

fun main(){
    val r = Rectangle(10,20,30)
    println(r.perimeter())
    r.greetMe()
}
