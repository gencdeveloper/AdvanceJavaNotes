package TransactionsTaskSTREAM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );


        System.out.println("***********TASK******************");
        System.out.println("***********1.QUESTION******************");
        /**Find all transactions in the year 2011 and sort them by value(small to high)*/
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getTrader)
                .forEach(System.out::println);



        System.out.println("***********2.QUESTION******************");
        /**What are all the unique cities where the traders work?*/
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);


        System.out.println("***********3.QUESTION******************");
        /**What are all the unique cities where the traders work?*/
        transactions.stream()
                .filter(Trader->Trader.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .forEach(System.out::println);

        System.out.println("***********4.QUESTION******************");
        /**Return a string of all traders names sorted alphabetically*/
         String nameList = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .distinct()
                 .collect(Collectors.joining(", "));
        System.out.println(nameList);

        System.out.println("***********5.QUESTION******************");
        /**Are any traders based in Milan*/
        Optional<Transaction>AnyTraders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .findAny();
        System.out.println(AnyTraders.get());

        System.out.println("***********7.QUESTION******************");
        /**What is the highest value of all the transactions*/
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue) // Extract transaction values
                .max(Integer::compare);
        if (highestValue.isPresent()) {
            System.out.println("Highest transaction value: " + highestValue.get());
        } else {
            System.out.println("No transactions available.");
        }

        System.out.println("***********8.QUESTION******************");
        /**Find the transaction with the smallest value*/
        Optional<Integer> SmallestValue = transactions.stream()
                .map(Transaction::getValue) // Extract transaction values
                .min(Integer::compare);
        if (SmallestValue.isPresent()) {
            System.out.println("Smallest transaction value: " + SmallestValue.get());
        } else {
            System.out.println("No transactions available.");
        }
    }
}
