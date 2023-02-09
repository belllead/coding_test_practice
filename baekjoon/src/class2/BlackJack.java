package class2;

import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N];
		
		for (int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		int a, b, c;
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			a = cards[i];
			
			for (int j=0; j<N; j++) {
				if (j != i)	b = cards[j];
				else break;
				
				for (int k=0; k<N; k++) {
					if (k != i && k != j) {
						c = cards[k];
						
						if (a + b + c <= M) {
							max = Math.max(max, a+b+c);
						}
					} else break;
				}
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}
