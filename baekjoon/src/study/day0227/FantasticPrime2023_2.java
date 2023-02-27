package study.day0227;

import java.util.Scanner;

public class FantasticPrime2023_2 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i=(int) Math.pow(10, N-1); i<(int) Math.pow(10, N); i++) {
			if (fantasticPrime(i, 1)) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	static boolean fantasticPrime(int a, int digit) {
		boolean flag = true;
		
		// 기저 조건
		if (digit == N) {
			if (!(isPrime(a)))
				flag = false;
			
			return flag;
		}
		
		// 유도 파트
		else {
			int temp = a / (int) Math.pow(10, N - digit);
			
			if (isPrime(temp)) 
				flag = fantasticPrime(a, digit+1);
			else
				flag = false;
			
			return flag;
		}	
	}
	
	static boolean isPrime(int a) {
		if (a == 1) return false;
		
		else {
			for (int i=2; i<=Math.sqrt(a); i++) {
				if (a % i == 0)
					return false;
			}
		}
		
		return true;
			
	}
	
}
