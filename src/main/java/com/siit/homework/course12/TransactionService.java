package com.siit.homework.course12;

import com.siit.homework.course5.bank.Entity.BankAccount;
import com.siit.homework.course5.bank.Entity.Card;
import com.siit.homework.course5.bank.Entity.Pos;
import com.siit.homework.course5.bank.Entity.User;
import com.siit.homework.course5.bank.Repository.BankAccountRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TransactionService {
    public static void main(String[] args) throws Exception {
        TransactionService atmService = new TransactionService();

        Path fileDB = Paths.get("files", "bank_account.csv");

        List<BankAccount> bankAccounts = Files.lines(fileDB)
                .skip(1) //igonram headerul
                .filter(StringUtils::isNotBlank)
                .map(TransactionService::mapLineToBankAccount)
                .peek(System.out::println)
                .collect(Collectors.toList());

        Card card = new Card();
        BankAccount account = new BankAccount();
        User customer = new User();
        Pos pos = new Pos();
        card.addCard("15-03-2023 15:00:00", "Dumitru Paul", 123456789663L, 2444);
        account.addBankAccount("ROINGB00000000000000", new BigDecimal(700), "Dumitru Paul");
        account.attachCard(card);
        customer.addBankAccount(account);
        customer.addCard(card);
        pos.addKnownBankAccounts(account);
        atmService.addCard(account.getAttachedCardNumber());
        atmService.addBankAccount(customer.getBankAccounts());

        bankAccounts.add(account);
        rewriteBankAccountsDB(fileDB, bankAccounts);

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
                    System.out.println("1 - Deposit money; 2 - Interogare sold; 3 - Change pin; 4 - Withdraw Money; 5 - Exit");
                    int atmOption = scanner.nextInt();
                    atmOptionCounter = atmOption;

                    if (atmOption == 1) {
                        System.out.println("Enter the amount you want to deposit:");
                        BigDecimal deposit = scanner.nextBigDecimal();
                        while (deposit.compareTo(BigDecimal.ZERO) < 0) {
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
                        BigDecimal amountWithdraw = scanner.nextBigDecimal();
                        boolean isWithdraw = bankAccount.withdrawMoney(amountWithdraw);
                        if (isWithdraw) {
                            BigDecimal money = bankAccount.getBalance();
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

    public static BankAccount mapLineToBankAccount(String line) {
        String[] fields = line.split(",");

        List<Card> cards = new ArrayList<>();

        cards.add(new Card(fields[3], fields[4], Long.parseLong(fields[5]), Integer.parseInt(fields[6])));

        return BankAccount.builder()
                .iban(fields[0])
                .ownerName(fields[2])
                .attachedCardNumber(cards)
                .balance(new BigDecimal(fields[1].trim()))
                .build();
    }

    private static void rewriteBankAccountsDB(Path fileDB, List<BankAccount> bankAccounts) throws IOException {
        String currentTimeString = LocalDateTime.now().truncatedTo(SECONDS).format(ISO_LOCAL_DATE_TIME);
        String newFileName = fileDB.toString().substring(0, fileDB.toString().length() - 4) + "_" + currentTimeString + ".csv";

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(newFileName), UTF_8, StandardOpenOption.CREATE);
        writeHeader(writer);
        bankAccounts.forEach(bankAccount -> writeBankAccountEntry(writer, bankAccount));
        writer.flush();
    }

    private static void writeHeader(BufferedWriter writer) {
        try {
            writer.write("iban,balance,ownerName,expirationDate,ownerName,cardNumber,pinCode");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing header ");
        }
    }

    private static void writeBankAccountEntry(BufferedWriter writer, BankAccount bankAccount) {
        try {
            Card card = bankAccount.getAttachedCardNumber().get(0);
            writer.write(bankAccount.getIban() + "," + bankAccount.getBalance() + "," + bankAccount.getOwnerName()
                    + "," + card.getExpirationDate() + "," + card.getOwnerName() + "," + card.getCardNumber() + ","
                    + card.getPinCode());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing bankAccount: " + bankAccount);
        }
    }
}
