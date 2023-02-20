package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SteelRod_opt3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();

			int rod = 0;
			int sum = 0;
			
			for (int i=0; i<str.length(); i++) {
				if (str.charAt(i) == '(') {
					rod++;
				} else {
					if (str.charAt(i-1) == '(') {
						rod--;
						sum += rod;
					} else {
						rod--;
						sum++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}
}
