package study.day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		while ((s = br.readLine()) != null) {
			if (s.equals(".")) break;
			else s = s.replace(" ", "");
			
			stack.clear();
			
			boolean flag = true;
			
			for (int i=0; i<s.length(); i++) {
				char temp = s.charAt(i);
				
				if (temp == '(') {
					stack.push(temp);
				} else if (temp == ')') {
					try {
						if (stack.peek() == '(')
							stack.pop();
						else {
							flag = false;
							break;
						}
					} catch (Exception e) {
						flag = false;
						break;
					}
				} else if (temp == '[') {
					stack.push(temp);
				} else if (temp == ']') {
					try {
						if (stack.peek() == '[') 
							stack.pop();
						else {
							flag = false;
							break;
						}
					} catch (Exception e) {
						flag = false;
						break;
					}
				}
				System.out.println(stack.toString());
			}
			
			if (flag) {
				sb.append("yes" + "\n");
			} else {
				sb.append("no" + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
