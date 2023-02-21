package study.day0220;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			queue.offer(i+1);
		}
				
		while (queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		System.out.println(queue.poll());
		sc.close();
	}
}