package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        /* UPCASTING
        BusinessAccount is also an Account cause of inheritance
        This is why we can assign an object BusinessAccount to an Object Account. */
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        /* DOWNCASTING
        To do an operation in a Account(superclass) it has to be done a downcasting to a
        BusinessAccount(subclass) for the compiler have the knowledge. It can't be done directly
        from a Superclass. */

        BusinessAccount acc4 = (BusinessAccount) acc2; // Downcasting
        acc4.loan(100.0);

        // BusinessAccount acc5 = (BusinessAccount) acc3; This doesn't compile because acc3 is an Account.

        /* This way you can test if the downcasting will be possible.
         Cause a SavingsAccount became an Account type so the BusinessAccount can't have the access
         to a SavingsAccount */
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
    }
}