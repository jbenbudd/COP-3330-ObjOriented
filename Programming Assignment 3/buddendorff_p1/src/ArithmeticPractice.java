import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ArithmeticPractice {

    public static int getDifficulty(){
        int diff = 0;
        int i = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a difficulty level: 1, 2, 3, or 4: ");
        System.out.println("1 = 1 digit, 2 = 2 digit, 3 = 3 digit, 4 = 4 digit");

        while (i == 0){
            diff = scnr.nextInt();
            if (diff < 1 || diff > 4) {
                System.out.println("Invalid. Please enter a number 1 to 4.");
            }
            else {
                i = 1;
            }
        }
        return diff;
    }

    public static int getProblemType(){
        int type = 0;
        int i = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a number from 1 to 5 to select your problem type.");
        System.out.println("1 = Addition, 2 = Multiplication, 3 = Subtraction, 4 = Division, 5 = Everything!");

        while (i == 0){
            type = scnr.nextInt();
            if (type < 1 || type > 5) {
                System.out.println("Invalid. Please enter a number 1 to 5.");
            }
            else {
                i = 1;
            }
        }
        return type;
    }

    public static int generateNum(int difficulty){
        int randomNumber = 0;
        Random rand = new SecureRandom();
        switch (difficulty){
            case 1:
                randomNumber = rand.nextInt(10);
                break;
            case 2:
                randomNumber = rand.nextInt(100);
                break;
            case 3:
                randomNumber = rand.nextInt(1000);
                break;
            case 4:
                randomNumber = rand.nextInt(10000);
                break;
        }
        return randomNumber;
    }

    public static void generateResponse(double userAnswer, double actualAnswer){
        Random rand = new SecureRandom();

        int randomNumber = rand.nextInt(4);
        boolean isCorrect;

        if (Math.abs(userAnswer - actualAnswer) < 0.1){
            isCorrect = true;
        }
        else
            isCorrect = false;

        if (isCorrect == true){
            switch (randomNumber){
                case 0:
                    System.out.println("Correct!");
                    break;
                case 1:
                    System.out.println("Great work!");
                    break;
                case 2:
                    System.out.println("Nice, you got it!");
                    break;
                case 3:
                    System.out.println("Right, keep it up!");
                    break;
            }
        }
        else if(isCorrect == false){
            switch (randomNumber){
                case 0:
                    System.out.println("Oops! The correct answer was: " + actualAnswer);
                    break;
                case 1:
                    System.out.println("Nice try, but the correct answer was: " + actualAnswer);
                    break;
                case 2:
                    System.out.println("Incorrect. The correct answer was: " + actualAnswer);
                    break;
                case 3:
                    System.out.println("Wrong, but don't give up! The correct answer was: " + actualAnswer);
                    break;
            }
        }
    }

    public static void generateQuestions(int difficulty, int type){
        Scanner scnr = new Scanner(System.in);
        Random rand = new SecureRandom();

        int randomNumber = 0;
        double numCorrect = 0;
        double numIncorrect = 0;
        double num1 = 0;
        double num2 = 0;
        double userAns = 0;
        double actualAns = 0;

        for (int i = 0; i < 10; i++){
            num1 = generateNum(difficulty);
            num2 = generateNum(difficulty);

            if (type == 1){
                actualAns = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = ? ");
                userAns = scnr.nextDouble();
            }
            else if (type == 2){
                actualAns = num1 * num2;
                System.out.println(num1 + " x " + num2 + " = ? ");
                userAns = scnr.nextDouble();
            }
            else if (type == 3){
                actualAns = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = ? ");
                userAns = scnr.nextDouble();
            }
            else if (type == 4){
                if (num2 == 0)
                    num2++;
                actualAns = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = ? ");
                userAns = scnr.nextDouble();
            }
            else if (type == 5){
                randomNumber = rand.nextInt(4) + 1;
                switch (randomNumber){
                    case 1:
                        actualAns = num1 + num2;
                        System.out.println(num1 + " + " + num2 + " = ? ");
                        userAns = scnr.nextDouble();
                        break;
                    case 2:
                        actualAns = num1 * num2;
                        System.out.println(num1 + " x " + num2 + " = ? ");
                        userAns = scnr.nextDouble();
                        break;
                    case 3:
                        actualAns = num1 - num2;
                        System.out.println(num1 + " - " + num2 + " = ? ");
                        userAns = scnr.nextDouble();
                        break;
                    case 4:
                        if (num2 == 0)
                            num2++;
                        actualAns = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = ? ");
                        userAns = scnr.nextDouble();
                        break;
                }
            }

            generateResponse(userAns, actualAns);

            if (Math.abs(actualAns - userAns) < 0.1){
                numCorrect++;
            }
            else
                numIncorrect++;

        }

        System.out.println("");

        double percentage = (numCorrect / 10) * 100;
        System.out.println("You answered " + numCorrect + " questions correctly and " + numIncorrect + " questions incorrectly.");
        System.out.println("You overall score is: " + percentage + "%");
        if (percentage < 75){
            System.out.println("Please ask your teacher for extra help.");
        }
        else if (percentage >= 75){
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }


    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        boolean resume = true;

        while (resume == true) {
            int difficultyLevel = getDifficulty();
            System.out.println("You have entered: " + difficultyLevel);
            System.out.println("");

            int problemType = getProblemType();
            System.out.println("You have entered: " + problemType);
            System.out.println("");

            generateQuestions(difficultyLevel, problemType);

            System.out.println("");

            System.out.println("Would you like to continue? Enter (y) to start from the beginning, or any other key to close the program.");
            String userContinue = scnr.next();

            if (userContinue.compareTo("y") != 0){
                resume = false;
            }
        }

    }

}
