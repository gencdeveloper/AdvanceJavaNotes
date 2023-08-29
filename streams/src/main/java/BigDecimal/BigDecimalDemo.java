package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 174.56;
        double d2 = 174.26;

        System.out.println(d1-d2);

        /***If you work with like double value, don't use it!
         * instead of that you can use BigDecimal object! it will be easier then double**/
        BigDecimal b1 = new BigDecimal("174.56");
        BigDecimal b2 = new BigDecimal("174.26");

        System.out.println(b1.subtract(b2));

        /**Scaling and Rounding*/
        BigDecimal number1 = new BigDecimal(23.12);
        System.out.println(number1.setScale(1, RoundingMode.CEILING));
        System.out.println(number1.setScale(2, RoundingMode.CEILING));
        System.out.println(number1.setScale(2, RoundingMode.FLOOR));

        /**They are object because of that we are using compareTo*/
        System.out.println(new BigDecimal("2").compareTo(new BigDecimal("2")));
        System.out.println(new BigDecimal("2").compareTo(new BigDecimal("3")));
        System.out.println(new BigDecimal("3").compareTo(new BigDecimal("2")));

        /**BigDecimals are imutable*/
    }
}
