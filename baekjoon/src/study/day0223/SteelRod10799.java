package study.day0223;

import java.util.Scanner;
import java.util.Stack;

public class SteelRod10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		Stack<Character> stack = new Stack<>();
		
		int cnt = 0;
		int sum = 0;
		for (int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '(') {
				stack.push(temp);
				cnt++;
				sum++;
			} else {
				if (stack.peek() == '(') {
					cnt--;
					sum--;
					sum += cnt;
					stack.push(temp);
				} else {
					cnt--;
				}
			}
			System.out.println(sum);
			System.out.println(stack.toString());
		}
		System.out.println(sum);
	}
}
