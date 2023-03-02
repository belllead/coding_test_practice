package study.day0306;

import java.util.Scanner;

public class Recursion25501 {
	static int recur = 0;;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			String s = sc.next();
			int ans = recursion(s, 0, s.length()-1);
			System.out.printf("%d %d", ans, recur);
			System.out.println();
			recur = 0;
		}
	}
	
	static int recursion(String s, int l, int r) {
		recur++;
		if (l >= r) return 1;
		else if (s.charAt(l) != s.charAt(r)) return 0;
		else {
			return recursion(s, l+1, r-1);
		}
	}
}
