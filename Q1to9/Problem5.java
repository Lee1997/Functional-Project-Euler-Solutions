/*
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 https://projecteuler.net/problem=5
*/

package solutions.Q1to9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem5 {
	public static void main(String[] args) {
		System.out.println(smallest());
	}
	
	public static int smallest(){
		return Stream.iterate(1, e -> e + 1)
				      .filter(num -> isDiv(num))
				      .findFirst()
				      .get();
		      
	}
	
	public static boolean isDiv(int num){
		return IntStream.range(1, 20)
			            .allMatch(i -> num % i == 0);			
	}
}
