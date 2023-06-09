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
***Super Keyword in java***
- Super keyword in java is used to refer to the immediate super class object
- if you create an object for a class B that extends to Class A, 
implicitly there will be an object created for class A. To refer to the implicitly 
created object, we use `super` keyword.

*** Example - Using the super keyword to refer to the immediate parent class variable
```java
class A{ // this is super class
    int count = 0;
}

class B extends A { // this is the sub class
    int count = 0;
    public void display(){
        super.count = super.count + 10;
        System.out.println(super.count); // 10
        System.out.println(count); // 1
    }
}

class Main{
    public static void main (String[] args) {
        B b = new B();
        b.count = b.count+1;
        b.display();
    }
}
```

***Example - Using super keyword to access the immediate parent class Method***
```java
class A{ // this is super class
    int count = 0;
    public void display(){
        System.out.println("Pavan");
    }
}

class B extends A { // this is the sub class
    int count = 0;
    public void display(){
        super.count = super.count + 10;
        System.out.println(super.count); // 10
        System.out.println(count); // 1
        super.display();
    }
}

class Main{
    public static void main (String[] args) {
        B b = new B();
        b.count = b.count+1;
        b.display();
    }
}
```

***Example - Using Super keyword to access the immediate super class's Constructor***
```java
class A{ // this is super class
    int count = 0;
    A(int c){
        count = c;
        System.out.println("Super class constructor is called!!");
    }
    public void display(){
        System.out.println("Pavan");
    }
}

class B extends A { // this is the sub class
    B(){
        super(123);
        System.out.println("constructor Invoked");
    }
    int count = 0;
    public void display(){
        super.count = super.count + 10;
        System.out.println(super.count); // 10
        System.out.println(count); // 1
        super.display();
    }
}

class Main{
    public static void main (String[] args) {
        B b = new B();
        b.count = b.count+1;
        b.display();
    }
}
```
***Two Types of Variables***
- Class Variable - They belong to the class and shared commonly by all the objects that are created for that class.
- Instance Variables - They belong to the object(Instance) created.
***static Keyword***
- It is used for memory management.
- Static keyword is not only applied for variables, it can also be applied for 
methods, blocks and nested classes.
- Java static variables
	- Variables that are defined with static keyword
	- If you have a common property that needs to be applied for 
	all the objects that you create for that class - then, to manage the memory well,
	you can use a static variable.
	- As the static variable belongs to the class, we can access it without creating an object
***Example - Using static keyword to create a class variable***
```java
class A{
    // the aim is to calculate the number of objects created for this class
    static int count = 0;
    A(){
        count++;
    }
    
    public void display(){
        System.out.println("there are "+count+" number of Objects created so far!");
    }
}

class Main {
    public static void main (String[] args) {
        A a = new A();
        a.display();
        A b = new A();
        A c = new A();
        A d = new A();
        A e = new A();
        a.display();
    }
}
```

***Example - Static variables can be accessed without a need of creating an instance of a class***
```java
class A{
    static int count = 0;
    A(){
        count++;
    }
    
    public void display(){
        System.out.println(count);
    }
}

class Main {
    public static void main (String[] args) {
        A.count = 100;
        new A().display();
    }
}
```

***Static Methods***
- Methods that belong to the class but not the instances(Objects) of the class
- Static Methods can be accessed directly.
- Static methods cannot access non static members of a class.
```java
class A{
    int count = 0;
    A(){
        count++;
    }
    
    public static void display(){
        System.out.println(count);
    }
}

class Main {
    public static void main (String[] args) {
        A a = new A();
        A.display();
    }
}
```

***Example - Using Static Methods***
```javaclass A{
    static int count = 0;
    boolean status = false;
    public static void changeStatus(){
        count = count + 10;
    }
    
    public void display(){
        changeStatus();
        System.out.println(count);
    }
}

class Main{
    public static void main (String[] args) {
        A a = new A();
        a.display();
        
        A b = new A();
        b.display();
    }
}```

***Java Static Blocks***
- These blocks can be used to initialize the static data members of a class
- It is something that gets executed before main() method. 

```java
class Main{
    static{
        System.out.println("Executed before Main");
    }
    
    public static void main (String[] args) {
        System.out.println("Hello World");
    }
}
```

**Question**
```Is it possible to execute a java program with out the main method ? ```
```No, from the latest versions of java, it is not at all possible. But in the older versions of java, we use to use java static blocks to the same```

***this keyword in java***
- `this` is a reference variable that refers to the current class object
- Uses of `this` keyword
	- This can be used to implicitly invoke current class method
	- this() can be used to invoke the current class constructor.
	- this can be passed as an argument in a method call.
***Example - this can be used to refer to the current class instance variables***
```java
class Employee{
    String name;
    int age;
    
    Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public void display(){
        System.out.println(name+" "+age);
    }
}

class Main{
    public static void main (String[] args) {
        Employee e = new Employee("Pavan",30);
        e.display();
    }
}
```

***Example - this can be used to access the current objects method***
```java
class Boss{
    public void printDeveloperInfo(){
        System.out.println("Developer has 8 years of experience!");
    }
}
class Employee extends Boss{
    String name;
    int age;
    
    Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public void display(){
        System.out.println(name+" "+age);
        this.printDeveloperInfo();
    }
}

class Main{
    public static void main (String[] args) {
        Employee e = new Employee("Pavan",30);
        e.display();
    }
}
```

***Example - this can be used to call the current objects constructor***
```java
class Employee{
    String name;
    int age;
    int salary;
    
    Employee(String name, int age){
        this(name, age, 30000);
    }
    
    Employee(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public void display(){
        System.out.println(name+" "+age+" "+salary);
    }
}

class Main{
    public static void main (String[] args) {
        Employee e = new Employee("Pavan",30);
        e.display();
    }
}
```

***final Keyword***
- final keyword restricts the user to perform certain kinds of actions
- the value of the final variables cannot be altered.
- the final methods cannot be overrided.
- the final classes cannot be inherited.

***Example - the final classes cannot be inherited***
```java
final class Pavan{
    
}

class Kumar extends Pavan{
    
}

class Main{
    public static void main (String[] args) {
        System.out.println("Hello world!");
    }
}
```
***Example - the value of the final variables cannot be altered.***
```java
class Main{
    
    static final int count = 0;
    public static void main (String[] args) {
        count = 2;
    }
}
```
***Example - the final methods cannot be overrided.***
```java
class A{
    public final void display(){
        System.out.println("Hello A");
    }
}

class B extends A{
    
    @Override
    public void display(){
        System.out.println("Hello B");
    }
}

class Main{
    public static void main (String[] args) {
        B b =new B();
        b.display();
    }
}
```
***Abstract classes in Java***
- When you declare a class with `abstract` keyword, that is called as an abstract class
- In abstract classes, along with the normal methods  that we declare and define, we can also have abstract methods (Abstract methods are those methods where the body of the method is not defined - Abstract methods can also be declared using abstract keyword)
***Abstraction***
- Abstraction is the process of hidin the implementation details and also showing the functionality to the user.
- Two Ways to achieve abstraction in java
	- Using abstract classes and methods (0% to 100%)
	- Interfaces (100%)
	
***Important Points to remember***
- abstract classes must be inherited by the other classes where the definition of the abstract methods of the class will be written
- abstract classes cannot be instantiated (you cannot create objects)

***Example***
```java
abstract class RBI{
    RBI(){
        System.out.println("this bank follows RBI guidelines");
    }
    
    public abstract int homeLoanInterest();
    
    public final int personalLoanInterest(){
        return 7;
    }
}

class SBI extends RBI{
    public int homeLoanInterest(){
        return 17;
    }
}

class ICICI extends RBI{
    public int homeLoanInterest(){
        return 16;
    }
}

class Main{
    public static void main (String[] args) {
        SBI s = new SBI();
        System.out.println(s.personalLoanInterest());
        System.out.println(s.homeLoanInterest());
    }
}
```
***Interfaces in Java***
- An Interface in java is a blueprint of a class
- It consists of Static constants and abstract methods.
- With Interfaces, we can ensure 100% Abstraction.
- With Interfaces, we can also implement Multiple Inheritance (Which is not supported by java by default)

***Sytax of Declaring an Interface***
```java
interface InterfaceName{
// Static constants
// Abstract Methods
}
```

***Basic Example***
```java
interface NareshTech{
    // You need not to write abstract keyword. because the methods in an interface are abstract by default
    void display();
}

class A implements NareshTech{
    
    public void display(){
        System.out.println("Hello World!");    
    }
}

class Main{
    public static void main (String[] args) {
        A a = new A();
        a.display();
    }
}
```
***Example - Implementing Multiple Inheritance using Interfaces in java***
```java
interface A{
    void printMessage();
}

interface B{
    void display();
}

class C implements A,B{
    public void printMessage(){
        System.out.println("Hello");
    }
    
    public void display(){
        System.out.println("Hai");
    }
}

class Main{
    public static void main (String[] args) {
        C c = new C();
        c.printMessage(); 
        c.display();
    }
}
```

***Two Imp Points to remember***
- You `implements` an interface
- you `extends` a class
