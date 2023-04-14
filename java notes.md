# Essentials of Java for android application development

***Pre-requisites***
- Need to have good programming experience (any language)
- Use any online java compiler to run your programs

***Hello World Program***
```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

***output***

```
Hello, World!
```

# Data types in Java
- Primitive 
- Non Primitive

***Primitive Data types***
- boolean - 1 bit
- byte - 1 byte = 8 bits
- char - 2 Bytes = 16 bits
- short -2 Bytes = 16 bits
- int -4 Bytes = 32 bits
- long - 8 Bytes = 64 bits
- float -4 Bytes = 32 bits
- double - 8 Bytes = 64 bits

// Example 
```Java
class HelloWorld {
    public static void main(String[] args) {
        int x = 10;
        long y = 1234567L;
        System.out.println(x+" "+y);
    }
}
```
***Output***
```
10 1234567
```

***Addition of two numbers***
**using Static values**
```java
public class Main
{
	public static void main(String[] args) {
		int x = 10; 
		int y = 20;
		System.out.println(x+y);
	}
}
```

**Using the values input by the user**
- Generally for this, we can use two classes
	- BufferedReader (java.io - package)
	- Scanner (java.util - Package)

***Example - Buffered Reader***
```java
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		int x,y;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of x");
		x = Integer.parseInt(br.readLine());
		System.out.println("Enter the value of y");
		y = Integer.parseInt(br.readLine());
		System.out.println(x+y);
	}
}
```

***Example - Scanner***
```java
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		int x,y;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first number");
		x = s.nextInt();
		// nextFloat(), nextDouble(), nextLine() etc.,
		System.out.println("Enter the Second number");
		y = s.nextInt();
		
		System.out.println(x+y);
	}
}
```

***Control Statements in java***
- Three types of control statements
	- Decision Making Statements
		- if statements
		- switch Statements
		
	- Loop statements
		- for
		- while
		- do while
		- for each
	
	- Jump Statements
		- break
		- continue

***Relational operators in java***
> - greater than
< - less than
>= - greater than or equal to
<= - less than or equal to
== - equal to 
!= - not equal to

***Logical Operators in java***
&& - Logical AND
|| - Logical OR
! - Logical NOT

```Java
// print all the prime numbers between the given range of numbers
// What are prime numbers ?
//  - Any number that has only two factors (1 and itself) is called as prime

import java.util.Scanner;

class Main{
    
    public static void main (String[] args) {
        int lb, ub;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the lower bound");
        lb = s.nextInt();
        
        System.out.println("Enter the upper bound");
        ub = s.nextInt();
        
        for(int i = lb; i<=ub; i++){
            printIfPrime(i);
        }
    }
    
    public static void printIfPrime(int n){
        int i = 2;
        if(n==1)
            return;
        if(n==2){
            System.out.print(n+" ");
            return;    
        }
        
        for(i = 2; i<n; i++)
        {
            if(n%i == 0){
                return;
            }
        }
        System.out.print(n+"   ");
    }
}
```

***Assignment 2***
A Certain grade of steel has to be graded according to the following conditions
Condition A: If the steel's carbon content is less than 0.7
Condition B: The steels tensile strength must be greater than 5600
Condition C: The steels hardness should be less than 50

If all conditions meet -> grade is 10
if A & B conditions are true -> grade is 9
If B & C conditions are true -> grade is 8
if A & C conditions are true -> grade is 7
if only one condition is true and others are false -> grade is 6
if no condition meets -> grade 5

***JAVA Arrays***
- An array is a collection of similar type of data items under one single name.
- the array elements are stored in contegious memory locations (side by side)
- These locations can be accessed by the indices. 
- Array index starts at 0 and ends at one less than the actual size.

**Example**
```java
public class Main
{
	public static void main(String[] args) {
	   int[] a = new int[]{10,20,30,40,50,60,70,80,90,100};
	   
	   // Access the individual values 
	   System.out.println(a[2]);
	   
	   // modify existing value 
	   a[4] = 150;
	   System.out.println(a[4]);
	   
	   // print all the elements in the array 
	   for(int i=0; i<a.length; i++){
	       System.out.print(a[i]+" ");
	   }
	}
}
```

***for-each loop syntax***
```java
	for(int b: collection_variable_value(that has integers)){
		// statements
	}
```

**Example**
```java
public class Main
{
	public static void main(String[] args) {
	   int[] a = new int[]{10,20,30,40,50,60,70,80,90,100};
	   
	   // Access the individual values 
	   System.out.println(a[2]);
	   
	   // modify existing value 
	   a[4] = 150;
	   System.out.println(a[4]);
	   
	   // print all the elements in the array 
	   /*for(int i=0; i<a.length; i++){
	       System.out.print(a[i]+" ");
	   }*/
	   
	   for(int b: a){
	       System.out.print(b+" ");
	   }
	}
}
```

**Example - reading values dynamically (from console)**
```java

import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	   int[] a = new int[10];
	   
	   Scanner s = new Scanner(System.in);
	   for(int i=0; i<a.length; i++){
	       System.out.println("Enter the value "+(i+1)+":");
	       a[i] = s.nextInt();
	   }
	   
	   int sum = 0;
	   for(int b: a){
	       sum += b; // sum = sum + b;
	   }
	   
	   System.out.println(sum);
	}
}
```

***JUMP Statements in java***
- break
- continue
**Break**
- A `break` statement breaks the loop.
- A `break` statement is associated with an if.
```java
class Main{
    
    public static void main (String[] args) {
        
        for(int i=1; i<=10; i++){
            if(i%3 ==0){
                break;
            }
            System.out.print(i+" ");
        }    
        
    }
}
```
**Output**
```
1 2
```

**continue**
- `Continue` keyword when it is encountered it goes to the nextDoubl
iteration leaving behind the statements following it in the loop.

```JAVA
class Main{
    
    public static void main (String[] args) {
        
        for(int i=1; i<=10; i++){
            if(i%3 ==0){
                continue;
            }
            System.out.print(i+" ");
        }    
        
    }
}
```
**Output**
```
1 2 4 5 7 8 10
```

***Java OOPS***
- oops -> Object oriented programming system
- Java Purely OOP language
- You cannot write a program without declaring a class
- Everything in java is built around objects in java

***Important Concepts***
- Objects
- classes
- Inheritance
- Polymorphism
- Abstration & Interfaces
- Encapsulation

***Objects***
- Any real world entity can be considered as an object if it exhibits properties
and behavior.
- An Object is an instance(copy) of a class.

***Class***
- A class is a blueprint of an object	
	- variables(instance) in the class they are allotted with memory
	- Only when you create an object(a copy) for the class, the memory is created
	- Always keep the first letter of the class name as capital.
***Syntax of Creating a class***
```java
class Dog{
	// properties -> variables
	// Behaviors -> Methods
}
```

**Example**
```java
class Dog{
    // properties
    String name;
    int age;
    double weight;
    
    // behaviors
    public void barkAtStrangers(){
        System.out.println("Bow Bow! "+name);
    }
    
    public void swim(){
        System.out.println("I can Swim "+age);
    }
}

class Main{
    
    public static void main(String[] args) {
            Dog d1 = new Dog();
            d1.name = "Jimmy";
            d1.age = 20;
            d1.weight = 25.3;
            d1.barkAtStrangers();
            
            Dog d2 = new Dog();
            d2.name = "Tommy";
            d2.age = 30;
            d2.weight = 55.2;
            d2.swim();
            
    }
}
```

***Constructors in Java***
- At the time of initializing an object, if you want to intialize a few variables 
of that object, you can use a constructor.
- There is a default constructor available for every class you create
- In java, we can have multiple constructors for the same class (Overloading constructors)
- Types of Constructors
	- Default Constructors (No arguments)
	- Parameterized constructors (Arguments)
- Constructors look like methods but does not have return types.
- The name of the constructor should be the same as that of the class name.

```java
class Dog{
    // properties
    String name;
    int age;
    double weight;
    Dog(){
        
    }
    
    Dog(String n, int a, double w){
      name = n;
      age = a;
      weight = w;
    }
    
    // behaviors
    public void barkAtStrangers(){
        System.out.println("Bow Bow! "+name);
    }
    
    public void swim(){
        System.out.println("I can Swim "+age);
    }
}

class Main{
    
    public static void main(String[] args) {
            Dog d1 = new Dog("Jimmy",10,30.5);
            d1.barkAtStrangers();
            
            Dog d2 = new Dog();
            d2.name = "Tommy";
            d2.age = 30;
            d2.weight = 55.2;
            d2.swim();
            
    }
}
```

***Command line arguments in java***
```java
class King{
  public static void main(String a[]){
    for(String d : a){
      System.out.println(d);
    }
  }
}
```

***Inheritance in Java***
- It is a mechanism in which one class aquires the properties & behaviors 
of another class
- The class that acquires the properties of another class is called "Derived class",
"Sub class" or "Child Class"
- The class from which the properties are acquired is called Base class or parent
class or super class.

***Types of Inheritance***
- Single Inheritance
- Multi Level Inheritance
- Hierarchical Inheritance
- Multiple Inheritance (this is not supported in Java)

***Example - Single Inheritance***
```java
import java.lang.Math;

class Parent{
    int a;
    
    public int square(){
        return a*a;
    }
}

class Child extends Parent{
    double d;
    public double squareRoot(){
        return Math.sqrt(d);
    }
}


class Main{
    public static void main (String[] args) {
        Child c = new Child();
        c.a = 10;
        int x = c.square();
        System.out.println(x);
        
        c.d = 9;
        double d = c.squareRoot();
        System.out.println(d);
    }
}
```

***Example - Multi Level Inheritance***
```Java
import java.lang.Math;

class Parent{
    int a;
    
    public int square(){
        return a*a;
    }
}

class Child extends Parent{
    double d;
    public double squareRoot(){
        return Math.sqrt(d);
    }
}

class GrandChild extends Child{
    double x,y;
    public double num2Power(){
        return Math.pow(x,y);
    }
}

class Main{
    public static void main (String[] args) {
        GrandChild c = new GrandChild();
        c.a = 10;
        int x = c.square();
        System.out.println(x);
        
        c.d = 9;
        double d = c.squareRoot();
        System.out.println(d);
        
        c.x = 5; c.y = 2;
        double an = c.num2Power();
        System.out.println(an);
    }
}
```

***Example - Hierarchical Inheritance***
```java
class Animal{
    public void eat(){
        System.out.println("Eating...");
    }
}

class Dog extends Animal{
    public void bark(){
        System.out.println("Bow Bow");
    }
}

class Cat extends Animal{
    public void shout(){
        System.out.println("Meow Meow");
    }
}

class Main{
    public static void main (String[] args) {
        Cat c = new Cat();
        c.shout(); c.eat();
        
        Dog d = new Dog();
        d.bark(); d.eat();
    }
}
```

***Polymorphism***
- Means existing in multiple Forms
- Two types of Polymorphism
	- run time (method overriding)
	- compile time (method overloading)
- Compile time Polymorphism
	- if a class has multiple methods of the same name but different number/ 
	different types of parameters, then it is known as Compile time polymorphism
```java
class SumOfNumbers{
    public void sum(int a, int b){
        System.out.println(a+b);
    }
    
    public void sum(int a, int b, int c){
        System.out.println(a+b+c);
    }
    
    public void sum(double a, double b){
        System.out.println(a+b);
    }
}

class Main{
    public static void main (String[] args) {
        SumOfNumbers s = new SumOfNumbers();
        s.sum(10,20);
        s.sum(10,20,30);
        s.sum(10.23,20.25);
    }
}
```

- Run time Polymorphism (Method overriding)
	- Inorder to implement method overriding, we need the inheritance implemented
	- Method overrding means that creating the same method in the child class 
	which is already present in the parent class.
```java
class Summing{
    public void sum(int a, int b){
        System.out.println(a+b);
    }
}
class SumOfNumbers extends Summing{
    
    @Override
    public void sum(int a, int b){
        System.out.println("Counting....");
        System.out.println(a+b);
    }
    
    public void sum(int a, int b, int c){
        System.out.println(a+b+c);
    }
    
    public void sum(double a, double b){
        System.out.println(a+b);
    }
}

class Main{
    public static void main (String[] args) {
        SumOfNumbers s = new SumOfNumbers();
        s.sum(10,20);
        s.sum(10,20,30);
        s.sum(10.23,20.25);
    }
}
```

