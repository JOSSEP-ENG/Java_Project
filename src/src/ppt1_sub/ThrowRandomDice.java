package src.ppt1_sub;

import java.util.Random;
import java.util.Scanner;

public class ThrowRandomDice {

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scanner = new Scanner(System.in);
		int[] result = new int[7];
		int input=0;
		
		while(true) {
			System.out.println("몇번 던질까요?");
			input = scanner.nextInt();			
			if(input < 1 || input > 100) break;
			
			for(int i=0; i<input;i++) {
				result[ran.nextInt(1, 7)]++;
			}
			for(int i=1;i<=6;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.printf("\n");
		}			
		System.out.println("종료");
		scanner.close();
	}
}
