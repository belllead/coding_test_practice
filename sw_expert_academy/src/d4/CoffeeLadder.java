package d4;

import java.util.Scanner;

public class CoffeeLadder {
	static int[][] ladder;
	static int currentRow, currentCol;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=0; t<10; t++) {
			int tc = sc.nextInt();
			ladder = new int[100][100];
			int goalRow = 0;
			int goalCol = 0;
			
			for (int r=0; r<100; r++) {
				for (int c=0; c<100; c++) {
					ladder[r][c] = sc.nextInt();
					if (ladder[r][c] == 2) {
						goalRow = r;
						goalCol = c;
					}
						
				}
			}
			
			currentRow = goalRow;
			currentCol = goalCol;
			
			while (currentRow > 0) {
				followLadder();
			}
			
			System.out.println("#" + tc + " " + currentCol);
		}
		sc.close();
	}
	
	static void followLadder() {
		
		// check left
		if (currentCol >= 1 && ladder[currentRow][currentCol - 1] == 1) { 
			ladder[currentRow][currentCol] = 0;
			currentCol--;			
		
		// check right
		} else if (currentCol < 99 && ladder[currentRow][currentCol + 1] == 1) { 
			ladder[currentRow][currentCol] = 0;
			currentCol++;
			
		// go up
		} else { 
			ladder[currentRow][currentCol] = 0;
			currentRow--;			
		}
	}
	
}
