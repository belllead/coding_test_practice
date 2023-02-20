package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SteelRod_opt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			Stack<Integer> rod = new Stack<>();
			
			int sum = 0;
			
			for (int i=0; i<str.length(); i++) {
				String temp = str.substring(i, i+1);
				if (temp.equals("(")) {
					rod.push(1);
				} else if (temp.equals(")")) {
					if (rod.peek() == 1) {
						rod.pop();
						for (int c=0; c<rod.size(); c++)
							rod.set(c, rod.get(c)+1);
					} else {
						sum += rod.pop();
					}
				}
				System.out.println(rod.toString());	
				System.out.println(sum);
			}
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
