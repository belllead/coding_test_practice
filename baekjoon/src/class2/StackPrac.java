package class2;

import java.util.Scanner;
import java.util.Stack;

public class StackPrac {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			String order = sc.next();
			
			switch (order) {
			case "push":
				int num = sc.nextInt();
				stack.push(num);
				break;
			case "pop":
				if (stack.size() > 0)
					System.out.println(stack.pop());
				else 
					System.out.println(-1);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty())
					System.out.println(1);
				else 
					System.out.println(0);
				break;
			case "top":
				if (stack.size() > 0)
					System.out.println(stack.peek());
				else 
					System.out.println(-1);
			}
		}
	}
	
	
}
