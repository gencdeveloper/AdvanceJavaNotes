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
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(milanBased);



        System.out.println("***********6.QUESTION******************");
        /**Print the values of all transactions from the traders living in Cambridge*/
        transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambdridge"))
                                .map(Transaction::getValue)
                                        .forEach(System.out::println);




        System.out.println("***********7.QUESTION******************");
        /**What is the highest value of all the transactions*/
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue) // Extract transaction values
                .reduce(Integer::max);
        System.out.println(highestValue.get());

        System.out.println("***********8.QUESTION******************");
        /**Find the transaction with the smallest value*/
        Optional<Transaction> SmallestValue = transactions.stream()
                .reduce((t1,t2)->t1.getValue()< t2.getValue() ? t1: t2);
        System.out.println(SmallestValue.get());

    }
}
