package `in`.nareshtech.kotlinprogramming

import java.util.Scanner;

fun main(){
    val s = Scanner(System.`in`); // Scanner s = new Scanner(System.in)
    println("Enter a number")
    val a = s.nextInt()
    println("Enter a number")
    val b = s.nextInt()
    val c = sum2(a,b)
    print(c)
}

fun sum2(x:Int, y:Int) = x+y