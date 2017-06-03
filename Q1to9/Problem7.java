/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10 001st prime number?
https://projecteuler.net/problem=7
 */

package solutions.Q1to9;

import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem7 {
	public static void main(String[] args) {
		System.out.println(findPrime());
	}
	
	public static int findPrime(){
		return Stream.iterate(1, e -> e + 1)
				     .filter(e -> isPrime(e))
				     .limit(10001)
				     .reduce((first, second) -> second)
				     .get();
				     
	}
	
	public static boolean isPrime(int num){
		LongPredicate range = d -> d < 2 && d > num;
		return num > 1 &&
				IntStream.iterate(2, e -> e + 1)
						  .limit((int) Math.sqrt(num))
						  .noneMatch(i -> (num % i == 0 && i != num));
	}
}
