public class SavingsAccount {

    private static double annualInterestRate = 0;
    private double savingsBalance;

    public SavingsAccount(double balance){
        savingsBalance = balance;
    }

    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }

    public void calculateMonthlyInterest(){
        savingsBalance += (savingsBalance * annualInterestRate) / 12;
    }

    public void printBalance(){
        System.out.printf("%.2f", savingsBalance);
    }

}
