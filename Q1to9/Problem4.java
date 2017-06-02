/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
https://projecteuler.net/problem=4
 */

package solutions.Q1to9;

import java.util.stream.IntStream;

public class Problem4 {
	public static void main(String[] args) {
		System.out.println(findNumber());
	}
	
	public static int findNumber(){
		return IntStream.range(100, 999)
				        .filter(e -> isPalindrome(e))
				        .reduce((first, second) -> second)
				        .getAsInt();
	}
	
	public static boolean isPalindrome(int e){
		String s = Integer.toString(e);
		return s.equals(new StringBuffer(s).reverse().toString().trim());	  
	}
}
