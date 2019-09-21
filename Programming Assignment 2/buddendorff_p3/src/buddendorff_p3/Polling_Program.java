package buddendorff_p3;

import java.util.Scanner;

public class Polling_Program {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String[] topics = new String[5];
		topics[0] = "Religion";
		topics[1] = "Politics";
		topics[2] = "Sciences";
		topics[3] = "Business";
		topics[4] = "The Arts";
		
		int[][] responses = new int[5][10];
		char userContinue = 'y';
		int userRating;
		int numInvalidResponses;
		int i;
		int j;
		int k;
		int l;
		int m;
		int divisor = 0;
		
		//Get user inputs
		while (userContinue == 'y' || userContinue == 'Y') {
			
			numInvalidResponses = 0;
			
			System.out.println("Please rate the following topics from 1 to 10.");
			
			for (i = 0; i < topics.length; i++) {
				System.out.print(topics[i] + ": ");
				userRating = scnr.nextInt();
				
				if (userRating >= 1 && userRating <= 10) {
					responses[i][userRating - 1] = responses[i][userRating - 1] + 1;
				}
				else {
					numInvalidResponses++;
				}
			}
			
			if (numInvalidResponses > 0){
				System.out.println("");
				System.out.println("You have entered " + numInvalidResponses + " invalid scores. These responses were not recorded.");
			}
			
			System.out.println("");
			System.out.println("Would you like to record another response? Enter [y] to continue. Enter any other key to view results.");
			userContinue = scnr.next().charAt(0);
		}
		
		//Calculate the average, max, and min values
		double averages[] = new double[5];
		int min = 0;
		int max = 0;
		double minNum = 500;
		double maxNum = 0;
		
		for (l = 0; l < averages.length; l++) {
			
			divisor = 0;
			
			for (m = 0; m <  10; m++) {
				averages[l] = averages[l] + (responses[l][m] * (m + 1));
				divisor = divisor + responses[l][m];
			}
			
			if (averages[l] > maxNum) {
				maxNum = averages[l];
				max = l;
			}
			
			if (averages[l] < minNum) {
				minNum = averages[l];
				min = l;
			}
			
			averages[l] = averages[l] / divisor;
		}
		
		//Print the Table
		System.out.println("");
		System.out.println("Topic     1  2  3  4  5  6  7  8  9  10  Average");
		System.out.println("------------------------------------------------");
		
		for (j = 0; j < topics.length; j++) {
			
			System.out.print(topics[j]);
			System.out.print("  ");
			
			for (k=0; k < 10; k++) {
				System.out.print(responses[j][k] + "  ");
			}
			
			System.out.println("  " + averages[j]);
		}
		
		System.out.println("------------------------------------------------");
		
		System.out.println("The topic with the most points is: " + topics[max]);
		System.out.println("The topic with the least points is: " + topics[min]);
		

	}

}
