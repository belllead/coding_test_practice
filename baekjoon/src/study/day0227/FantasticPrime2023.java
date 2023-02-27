package study.day0227;

import java.util.Scanner;

public class FantasticPrime2023 {
	static int N;
//	static List<Integer> memo = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i=(int) Math.pow(10, N-1); i<(int) Math.pow(10, N); i++) {
			if (fantasticPrime(i, 1)) {
				sb.append(i + "\n");
			}
		}
		
//		System.out.println(memo.toString());
		System.out.println(sb);
		sc.close();
	}
	
	static boolean fantasticPrime(int a, int digit) {
		// 기저 조건
		if (digit == N) {
			if (a == 1)
				return false;
			else {
				for (int i=2; i<a; i++) {
					if (a % i == 0)
						return false;
				}
			}
			// 모든 false 관문을 뚫으면 true
//			memoPrime(a);
			return true;
		}
		
		// 유도 파트
		else {
			int temp = a / (int) Math.pow(10, N - digit);
			if (temp == 1)
				return false;
			else {
				for (int i=2; i<temp; i++) {
					if (temp % i == 0) 
						return false;
				}
			}
			// 이번 단계의 false 관문들을 뚫으면
			// 다음 단계 호출
//			memoPrime(temp);
			return fantasticPrime(a, digit+1);
		}	
	}
	
//	static void memoPrime(int a) {
//		if (!(memo.contains(a)))
//			memo.add(a);
//	}
	
}
