package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SteelRod_opt3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			String str2 = "";
			
			List<Integer> laserL = new ArrayList<>();
			List<Integer> laserR = new ArrayList<>();
			
			for (int i=0; i<str.length()-1; i++) {
				String t1 = str.substring(i, i+1);
				String t2 = str.substring(i+1, i+2);
				if (t1.equals("(") && t2.equals(")")) {
					laserL.add(i);
					laserR.add(i+1);
				}
			}
			
			for (int i=0; i<str.length(); i++) {
				if (laserL.contains(i)) {
					str2 += "|";
				} else if (laserR.contains(i)) {
					str2 += "";
				} else {
					str2 += str.charAt(i);
				}
			}
						
			System.out.println(str2);
			
			Stack<Integer> rod = new Stack<>();
			
			int sum = 0;
			
			for (int i=0; i<str2.length(); i++) {
				String temp = str2.substring(i, i+1);
				if (temp.equals("(")) {
					rod.push(1);
				} else if (!rod.isEmpty() && temp.equals("|")) {
					for (int c=0; c<rod.size(); c++) {
						rod.set(c, rod.get(c)+1);
					}
				} else if (temp.equals(")")) {
					sum += rod.pop();
				}
				System.out.println(rod.toString());
				System.out.println(sum);
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
