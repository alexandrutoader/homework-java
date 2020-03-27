package com.siit.homework.Course5.bank.Services;

import com.siit.homework.Course5.bank.Entity.BankAccount;
import com.siit.homework.Course5.bank.Entity.Card;
import com.siit.homework.Course5.bank.Entity.Pos;
import com.siit.homework.Course5.bank.Entity.User;
import com.siit.homework.Course5.bank.Repository.BankAccountRepository;

import java.util.List;
import java.util.Scanner;

public class TransactionService {
    public static void main(String[] args) throws Exception {
        TransactionService atmService = new TransactionService();

        Card card = new Card();
        BankAccount account = new BankAccount();
        User customer = new User();
        Pos pos = new Pos();
        card.addCard("15-03-2023 15:00:00", "Andrei Alexandru", 123456789012L, 1234);
        account.addBankAccount("ROINGB00000000000000", 700L, "Andrei Alexandru");
        account.attachCard(card);
        customer.addBankAccount(account);
        customer.addCard(card);
        pos.addKnownBankAccounts(account);
        atmService.addCard(account.getAttachedCardNumber());
        atmService.addBankAccount(customer.getBankAccounts());

        List<BankAccount> bankAccounts = BankAccountRepository.getBankAccounts();

        try {
            int countPinTries = 3;
            Scanner scanner = new Scanner(System.in);

            for (BankAccount bankAccount : bankAccounts) {
                while (countPinTries > 0) {
                    System.out.println("Enter your pin code:");
                    Integer pinCode = scanner.nextInt();
                    boolean atmCheckFlag = pos.validateCard(pinCode);

                    if (!atmCheckFlag) {
                        countPinTries--;
                        System.out.println(countPinTries + " tries remaining!");

                        if (countPinTries == 0) {
                            System.out.println("Incorrect pin code for three times! Card have been removed from atm.");
                            countPinTries = 3;
                        }
                    } else {
                        break;
                    }
                }

                int atmOptionCounter = 0;
                while (atmOptionCounter < 5) {
                    System.out.println("Enter the operation you want to do:");
                    System.out.println("1 - Deposit money; 2 - Interogate sold; 3 - Change pin; 4 - Withdraw Money; 5 - Exit");
                    int atmOption = scanner.nextInt();
                    atmOptionCounter = atmOption;

                    if (atmOption == 1) {
                        System.out.println("Enter the amount you want to deposit:");
                        int deposit = scanner.nextInt();
                        while (deposit < 0) {
                            System.out.println("Please enter a deposit greater than 0!");
                            int depositRetry = scanner.nextInt();
                            if (depositRetry > 0) {
                                break;
                            }
                        }
                        bankAccount.addMoney(deposit);
                        System.out.println("The amount have been added to your account!");
                    }

                    if (atmOption == 2) {
                        System.out.println("Card amount: " + bankAccount.getBalance());
                    }

                    if (atmOption == 3) {
                        System.out.println("Enter your new pin code:");
                        int pinCode = scanner.nextInt();
                        pos.changePinCode(pinCode);
                    }

                    if (atmOption == 4) {
                        System.out.println("Enter the amount you want to withdraw:");
                        int amountWithdraw = scanner.nextInt();
                        boolean isWithdraw = bankAccount.withdrawMoney(amountWithdraw);
                        if (isWithdraw) {
                            long money = bankAccount.getBalance();
                            System.out.println("Sold after withdraw = " + money + "\n");
                        }
                    }

                    if (atmOption == 5) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCard(List<Card> cards) {
        for (Card card : cards) {
            Card object = new Card();
            object.setPinCode(card.getPinCode());
            object.setCardNumber(card.getCardNumber());
            object.setExpirationDate(card.getOwnerName());
            object.setOwnerName(card.getOwnerName());
            BankAccountRepository.cards.add(object);
        }
    }

    public void addBankAccount(List<BankAccount> bankAccounts) {
        for (BankAccount card : bankAccounts) {
            BankAccount object = new BankAccount();
            object.setBalance(card.getBalance());
            object.setAttachedCardNumber(card.getAttachedCardNumber());
            object.setIban(card.getIban());
            object.setOwnerName(card.getOwnerName());
            BankAccountRepository.bankAccounts.add(object);
        }
    }
}
