public class Application {

    public static void main(String[] args){

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("Balances at 4%:");

        for (int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + (i+1) + ", Saver 1 = $");
            saver1.printBalance();
            System.out.print(", Saver 2 = $");
            saver2.printBalance();
            System.out.println("");
        }

        System.out.println("");

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Balances after an additional month at 5%");
        System.out.print("Saver 1 = $");
        saver1.printBalance();
        System.out.print(", ");
        System.out.print("Saver 2 = $");
        saver2.printBalance();
    }
}
