package d4;

import java.util.Scanner;

public class D4_1486_HighShelf {

	static int N, B, tower;
	static int[] clerk;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			clerk = new int[N];
			for (int i=0; i<N; i++) {
				clerk[i] = sc.nextInt();
			}

			tower = Integer.MAX_VALUE;
			
			powerSet(0, 0);
			
			sb.append("#" + tc + " ");
			sb.append(tower - B);
			sb.append("\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	static void powerSet(int n, int sum) {
		
		if (sum >= B) {
			tower = Math.min(tower, sum);
			return;
		}
		
		if (n >= N) {
			return;
		}
		
		powerSet(n+1, sum+clerk[n]);
		powerSet(n+1, sum);
	}
}
