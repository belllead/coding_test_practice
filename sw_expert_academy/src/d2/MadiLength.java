package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MadiLength {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String caseText = in.readLine();
			
			int madi = 0;
			int max = 0;
						
			for (int i=0; i<caseText.length(); i++) {
				for (int j=i+1; j<caseText.length(); j++) {
					if (caseText.charAt(i) == caseText.charAt(j)) {
						madi = j-i;
						break;
					}
				}
				if (max < madi) max = madi;
				madi = 0;
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");	
		}
		
		System.out.println(sb.toString());
		
	}
	
}
