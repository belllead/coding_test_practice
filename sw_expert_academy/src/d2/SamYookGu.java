package d2;

import java.util.Scanner;

public class SamYookGu {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=N; i++) {
			String str = Integer.toString(i); 
			while (str.contains("3")) {
				str.replace('3', '-');
				break;
			}
				sb.append(str + " ");
		}
		
		System.out.println(sb.toString());
		
	}
	
}
