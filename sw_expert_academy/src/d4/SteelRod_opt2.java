package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SteelRod_opt2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			Stack<Integer> rod = new Stack<>();
			List<Integer> cnt = new ArrayList<>();
			
			int sum = 0;
			
			for (int i=0; i<str.length(); i++) {
				String temp = str.substring(i, i+1);
				if (temp.equals("(")) {
					rod.push(1);
					cnt.add(1);
				} else if (temp.equals(")")) {
					if (cnt.get(cnt.size()-1) == 1) {
						rod.pop();
						for (int c=0; c<cnt.size(); c++)
							cnt.set(c, cnt.get(c)+1);
						cnt.remove(cnt.size()-1);
					} else {
						rod.pop();
						sum += cnt.get(cnt.size()-1);
						cnt.remove(cnt.size()-1);
					}
				}
				System.out.println(cnt.toString());	
				System.out.println(sum);
			}
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
