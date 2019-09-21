package buddendorff_p2;

import java.util.Scanner;

public class BMI_Calculator {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		char unitType;
		double height;
		double weight;
		double BMI;
		
		//Get user input on unit type to use for the formula
		System.out.print("BMI Calculator - Enter [m] to use metric units or [i] to use imperial units: ");
		unitType = scnr.next().charAt(0);
		
		
		if (unitType == 'm') {
			System.out.println("You have selected metric units.");
			System.out.print("Please enter your height in meters: ");
			height = scnr.nextDouble();
			System.out.print("Please enter your weight in kilograms: ");
			weight = scnr.nextDouble();
			
			System.out.println("");
			
			BMI = weight / (height*height);
			System.out.printf("Your BMI: %.1f", BMI);
			
			System.out.println("");
			System.out.println("");
			System.out.println("BMI Categories:");
			System.out.println("Underweight = <18.5");
			System.out.println("Normal weight = 18.5–24.9");
			System.out.println("Overweight = 25–29.9");
			System.out.println("Obesity = BMI of 30 or greater");
			
		}
		
		else if (unitType == 'i') {
			System.out.println("You have selected imperial units.");
			System.out.print("Please enter your height in inches: ");
			height = scnr.nextDouble();
			System.out.print("Please enter your weight in pounds: ");
			weight = scnr.nextDouble();
			
			System.out.println("");
			
			BMI = (703 * weight) / (height * height);
			System.out.printf("Your BMI: %.1f", BMI);
			
			System.out.println("");
			System.out.println("");
			System.out.println("BMI Categories:");
			System.out.println("Underweight = <18.5");
			System.out.println("Normal weight = 18.5–24.9");
			System.out.println("Overweight = 25–29.9");
			System.out.println("Obesity = BMI of 30 or greater");
		}
		
		else {
			System.out.println("Sorry, your input is not recognized. Please restart.");
		}
		
	}

}
