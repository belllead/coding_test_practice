package study.day0223;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RightBig17298_2 {
	static Queue<Integer> q = new LinkedList<>();
	static List<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		
		
		int max = 0;
		for (int i=0; i<N; i++) {
			int temp = sc.nextInt(); 
			q.offer(temp);
			max = Math.max(max, temp);
		}
		
//		System.out.println(q.toString());
		
		
		for (int i=0; i<N; i++) {
			int cnt = 1;
			int temp = q.poll();
			
			if (i == N-1 || temp == max) {
				ans.add(-1);
			} else {
				int temp2 = q.peek();
				
				try {
					while (temp2 < temp) {
						q.poll();
						cnt++;
						i++;
						temp2 = q.peek();
					}
					
					for (int j=0; j<cnt; j++)
						ans.add(temp2);
				} catch (Exception e) {
					ans.add(-1);
				}
			}
			System.out.println(q.toString());
		}
		
		String s = ans.toString().replace(',', '\u0000').replace('[', '\u0000').replace(']', '\u0000');
		System.out.println(s);
		sc.close();
	}
	
	static int searchRight(int a) {
		if (a < q.peek()) {
			
		} 
		
		if (a > q.peek()) {
			
		}
		
		
		return 0;
	}
	
}



//10
//1 2 54 65 4 2 6 8 1 3