package `in`.nareshtech.kotlinprogramming

// Kotlin is both functional and object oriented
fun main(){
    val a = sum(10,20)
    val b = mul(23,34)
    print("$a $b")
}

fun sum(a: Int, b: Int) =  a+b

fun mul(a: Int, b: Int) = a*b