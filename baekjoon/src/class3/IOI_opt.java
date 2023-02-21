package class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOI_opt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int NN = 2 * N + 1;
	
		int M = Integer.parseInt(br.readLine());
		char[] arr = new char[M];
		
		String s = br.readLine();
		for (int i=0; i<M; i++) {
			arr[i] = s.charAt(i);
		}
		
		int cnt = 0;
		
		for (int i=0; i<M; i++) {
			
			int idx = 0;
			
			boolean flag = false;
			
			if (arr[i] == 'I' && (i + NN) <= M) {
				while (idx < NN) {
					if (idx % 2 == 0) {
						if (arr[idx + i] == 'I') {
							flag = true;
						} else {
							flag = false;
							break;
						}
					} else {
						if (arr[idx + i] == 'O') {
							flag = true;
						} else {
							flag = false;
							break;
						}
					}					
					idx++;
				}
			}
			
			if (flag) 
				cnt++;
			
		}
		
		bw.write(cnt + '0');
		br.close();
		bw.close();
	}
}
