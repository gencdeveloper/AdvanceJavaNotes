package AdvanceJavaNotes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,5,3,9);
        int result = numbers.stream().reduce(0,(a,b) -> a+b);
        System.out.println(result);

        //No initial value
        Optional<Integer> result2 = numbers.stream().reduce((a, b) -> a+b);
        System.out.println(result2);

        //Max and Min
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        System.out.println("Min : "+min.get());
        System.out.println("Max : "+max.get());
        System.out.println("Sum: "+sum.get());


        //Task: How would you count the number of dishes in a stream using the map and reduce methods?
        int dishCount = DishData.getAll().stream() //: This gives us a Stream representing a list or collection of dish items. It retrieves a Stream containing a set of dish items.
                .map(d->1) //This operation generates the number 1 for each dish item, creating a new Stream containing these 1s. In other words, it assigns a value of 1 to each dish item.
                .reduce(0,(a,b)-> a+b);//: This operation sums up the 1s generated in the previous step, ultimately returning the total count of dishes.

       long dCount =  DishData.getAll().stream().count();
        System.out.println(dCount);

    }
}
