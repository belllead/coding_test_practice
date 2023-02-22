package etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SausageDivider1188 {
	static List<Integer> prime = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
	
		prime.add(2);
		
		for (int i=3; i<101; i++) {
			boolean flag = true;
			for (int j=0; j<prime.size(); j++) {
				if (i % prime.get(j) == 0) {
					flag = false;
					break;
				}				
			}
			if (flag)
				prime.add(i);
				
		}
		
//		System.out.println(prime.toString())
		
		int repeat = disjointgMaker(N, M);
		
		System.out.println(cutEvenly(N, M, repeat));
		
	}
	
	static int cutEvenly(int N, int M, int repeat) {
		N /= repeat;
		M /= repeat;
		
		int ans = 0;
		
		while (N > M) 
			N -= M;
		
		if (N == M) {
			ans = 0;  
		} else {
			if (M - N == 1) {
				ans = N;
			} else {
				ans = N * (M - 1);
			}
		}		
		
		System.out.println(N + " " + M);
		return ans * repeat;
	}
	
	static int disjointgMaker(int N, int M) {
		int multiply = 1;
		
		for (int i=0; i<prime.size(); i++) {
			int t = prime.get(i);
			int cnt = 0;
			
			while (N % t == 0 && M % t == 0) {
				N /= t;
				M /= t;
				cnt++;
			}
			
			if (cnt != 0) {
//				System.out.printf("%d : %d\n", t, cnt);
				multiply *= t * cnt;		
			}
		}
		
		return multiply;
	}
	
}
