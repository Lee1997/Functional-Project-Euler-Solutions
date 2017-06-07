/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
https://projecteuler.net/problem=10
 */

package solutions.Q10to19;

import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem10 {
	public static void main(String[] args) {
		System.out.println(findSum());
	}
	
	public static long findSum(){
		return LongStream.range(1, 2000000)
				        .filter(e -> isPrime(e))				        
				        .sum();				     
	}
	
	public static boolean isPrime(Long num){
		LongPredicate range = d -> d < 2 && d > num;
		return num > 1 &&
				LongStream.iterate(2, e -> e + 1)
						  .limit((long) Math.sqrt(num))
						  .noneMatch(i -> (num % i == 0 && i != num));
	}
}
