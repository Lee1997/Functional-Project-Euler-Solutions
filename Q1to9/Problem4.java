/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
https://projecteuler.net/problem=4
 */

package solutions.Q1to9;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {
	public static void main(String[] args) {
		System.out.println(findNumber());
	}
	
	public static int findNumber(){
		return (Stream.iterate(999, e -> e - 1)
				     .limit(899)
			         .filter(i -> Stream.iterate(999, e2 -> e2 - 1)
			        		            .limit(899)			        		           
			        		            .anyMatch(j -> isPalindrome(i * j))
			        		            )).getAsInt();
				     
	}
	
	public static boolean isPalindrome(Object e){
		String s = Integer.toString((int) e);
		return s.equals(new StringBuffer(s).reverse().toString().trim());	  
	}
}
