package com.siit.homework.Course4;

public class TransactionService {
    public static void main(String[] args) throws Exception {
        String ownerName = "Andrei Alexandru";
        System.out.println("\nOwner name: " + ownerName);

        Card card = new Card("15-03-2023 15:00:00", ownerName, 123456789012L);
        BankAccount account = new BankAccount("ROINGB00000000000000");
        account.attachCard(card);

        User customer = new User();
        customer.addBankAccount(account);
        customer.addCard(card);

        try {
            //Action for add money on customer1 accountForCustomer1.
            for (BankAccount customerAccount: customer.getBankAccounts()) {
                customerAccount.addMoney(700);
                System.out.println("Card amount: " + customerAccount.getBalance());
            }

            //Action for withdraw money from customerAccount.
            for (BankAccount clientAccount: customer.getBankAccounts()) {
                clientAccount.withdrawMoney(200);

                long money = clientAccount.getBalance();
                System.out.println("Sold after withdraw = " + money + "\n");
            }

            //Pay at POS with cardForCustomer1.
            Pos pos = new Pos();
            pos.addKnownBankAccounts(account);
            System.out.println("Pay at pos:");
            pos.pay(380,card);
            System.out.println(pos.getAmount() + " payed at pos.");

            for (BankAccount clientAccount: customer.getBankAccounts()) {
                long money = clientAccount.getBalance();

                System.out.println("Sold after pay = " + money);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
