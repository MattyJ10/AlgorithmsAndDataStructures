package test;
import java.util.*; 

public class Test {
	
	public static int change(int n) {
		int[] memo = new int[n+1]; 
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1; 
		}
		helper(n, memo);
		for(int i = 0; i < memo.length; i++) {
			System.out.println("for " + i + " there are " + memo[i] + " ways to make change"); 
		}
		return memo[n]; 
	}
	
	public static int helper(int n, int[] memo) {
		if (memo[n] != -1) {
			return memo[n]; 
		}
		if (n == 0) {
			memo[0] = 1; 
			return 1; 
		}
		if (n < 0) {
			return 0; 
		}
		if (n >= 25) {
			memo[n] = helper(n - 25, memo) + helper(n - 10, memo) + helper(n-5, memo) + helper(n-1, memo);
			return memo[n]; 
		} else if (n >= 10) {
			memo[n] = helper(n - 10, memo) + helper(n - 5, memo) + helper(n - 1, memo);
			return memo[n]; 
		} else if (n >= 5) {
			memo[n] = helper(n-5, memo) + helper(n-1, memo);
			return memo[n]; 
		} else {
			memo[n] = 1; 
			return 1; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(change(22)); 
	}

}
