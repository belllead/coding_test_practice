package d2;

import java.util.Scanner;

public class Frequent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
				
		for (int testCase=0; testCase<T; testCase++) {
			int max = 0;
			
			int testNum = sc.nextInt();
			
			int[] score = new int[1000];
			int[] freq = new int[101];
			
			for (int i=0; i<1000; i++) {
				score[i] = sc.nextInt();
			}
			
			for (int i=0; i<101; i++) {
				freq[i] = 0;
			}
			
			for (int i=0; i<1000; i++) {
				freq[score[i]]++;
				
			}	
			
			for (int i=0; i<101; i++) {
				if (max < freq[i]) 
					max = freq[i];
			}
			
			for (int i=100; i>=0; i--) {
				if (max == freq[i]) 
					max = i;
			}
			
			ans[testCase] = max;
						
		}
		
		
		for (int testCase=0; testCase<T; testCase++) {
			System.out.printf("#%d %d \n", testCase+1, ans[testCase]);
		}
		
	}
	
}
