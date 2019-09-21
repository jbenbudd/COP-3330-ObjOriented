package buddendorff_p1;

import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		//Get user input
		System.out.print("Enter 4-digit number: ");
		int userNum = scnr.nextInt();
		
		//Get each digit as separate variable
		int num1 = userNum / 1000;
		int num2 = (userNum / 100) % 10;
		int num3 = ((userNum / 10) % 100) % 10;
		int num4 = (((userNum % 1000) % 100) % 10);
		
		//Encrypt each digit
		num1 = (num1 + 7) % 10;
		num2 = (num2 + 7) % 10;
		num3 = (num3 + 7) % 10;
		num4 = (num4 + 7) % 10;
		
		//Rearrange digits into final number
		int finalNum = (num3 * 1000) + (num4 * 100) + (num1 * 10) + num2;
		
		//Print final number
		System.out.printf("Encrypted number: " + "%04d", finalNum);


	}

}
