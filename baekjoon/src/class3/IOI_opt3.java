package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOI_opt3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int NN = 2 * N + 1;
		
		String p = "";
		
		for (int i=3; i<NN; i++) {
			if (i % 2 == 1)
				p += 'I';
			else
				p += 'O';
		}
		
		int M = Integer.parseInt(br.readLine());		
		
		String s = br.readLine();
				
//		System.out.println(p);
//		System.out.println(s);
		
		int cnt = 0;
		
		for (int i=0; i<M; i++) {
			if ((i + NN) <= M && (s.substring(i, i+3).equals("IOI")) && s.substring(i+3, i+NN).equals(p)) {
				cnt++;	
			}
			
		}
		
		System.out.println(cnt);
	}
}
