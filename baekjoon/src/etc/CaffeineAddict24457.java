//package etc;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class CaffeineAddict24457 {
//
//	static int longestAwake = 0;
//	
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[][] drink = new int[N][2];
//		
//		StringTokenizer st1 = new StringTokenizer(br.readLine());
//		StringTokenizer st2 = new StringTokenizer(br.readLine());
//		for (int i=0; i<N; i++) {
//			int energy = Integer.parseInt(st1.nextToken());
//			int caffeine = Integer.parseInt(st2.nextToken());
//			drink[i] = new int[] {energy, caffeine};
//		}
//		
//		int awake = 0;
//		int S = 0;
//		
//		stayAwake(S, drink[1], awake);
//	}
//	
//	static void stayAwake(int S, int[] drink, int awake) {
//		if (drink[0] - S <= 0) {
//			longestAwake = Math.max(longestAwake, awake);
//			return;
//		}
//		
//		awake += drink[0] - S;
//		S += drink[1];
//		
//		for (int i=0; )
//		stayAwake(S, drink, awake);
//		
//		
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
