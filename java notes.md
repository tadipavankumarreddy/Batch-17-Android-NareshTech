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