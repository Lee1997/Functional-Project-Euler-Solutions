/*
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
https://projecteuler.net/problem=3
 */

package solutions.Q1to9;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class Problem3 {
	public static void main(String[] args) {
		long d = 600851475143l;
		System.out.println(findPrimeFactor(d));
	}
	
	public static long findPrimeFactor(long num){
		
		return LongStream.iterate(1, e -> e + 1)
						 .limit(num/2)						 
						 .filter(e -> isFactor(e, num))
						 .filter(e -> isPrime(e))
						 .reduce((first, second) -> second)
						 .getAsLong();	
	}
	
	public static boolean isFactor(long i, long num){
		return num % i == 0;	            		   
	}
	
	public static boolean isPrime(Long num){
		LongPredicate range = d -> d < 2 && d > num;
		return num > 1 &&
				LongStream.iterate(2, e -> e + 1)
						  .limit((long) Math.sqrt(num))
						  .noneMatch(i -> (num % i == 0 && i != num));
	}
}