package TransactionsTaskSTREAM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
