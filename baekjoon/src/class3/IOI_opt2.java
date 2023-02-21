package class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOI_opt2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int NN = 2 * N + 1;
		
		String p = "";
		
		for (int i=0; i<NN; i++) {
			if (i % 2 == 0)
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
			
			int idx = 0;
			
			boolean flag = false;
			
			if (s.charAt(i) == 'I' && (i + NN) <= M) {
				while (idx < NN) {
					if (p.charAt(idx) == s.charAt(idx + i)) {
						flag = true;
					} else {
						flag = false;
						break;
					}
					idx++;
				}
			}
			
			if (flag) {
				cnt++;
//				System.out.println(i);
				
			}
			
		}
		
		System.out.println(cnt);
	}
}
