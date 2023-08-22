package JavaCollector;

import AdvanceJavaNotes.Dish;
import AdvanceJavaNotes.DishData;
import AdvanceJavaNotes.Type;

import java.util.*;
import java.util.stream.Collectors;

public class JavaCollectors {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,5,6,6,7);

        //toCollection(Suplier) : is used to create collection using collector
        //to collection also provide customization; like return with set or list etc.
        //Collection from the stream
        System.out.println("******To Collection*******");
        List<Integer>numberList = numbers.stream()
                .filter(x-> x%2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));// i passed array list object

        System.out.println(numberList);

        System.out.println("******To Collection with SET*******");
        Set<Integer> numberSet = numbers.stream() //SET NOT ACCEPT DUPLICATE
                .filter(x-> x%2 == 0)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(numberSet);


        //toList() : returns a Collector interface that gathers the input data into a new list
        System.out.println("******To lIST*******");
        List<Integer> numberList2 = numbers.stream()
                .filter(x-> x%2 ==0)
                .collect(Collectors.toList());
        System.out.println(numberList2);

        //toSet() :return a Collector interface that gathers the input data into a new set
        System.out.println("******To Set*******");
      Set<Integer> numberSet2 = numbers.stream()
                .filter(x-> x%2 ==0)
                .collect(Collectors.toSet());
        System.out.println(numberSet2);

        System.out.println("******To Map*******");
        //toMap(Function,Function) : returns a collector interface that gathers the input data into a new map
        //accept key and value, mostly we can use database part
        Map<String,Integer> dishMap = DishData.getAll().stream()
                .collect(Collectors.toMap(Dish::getName,Dish::getCalories));

        System.out.println(dishMap);


        System.out.println("******Counting*******");
        //counting() : returns a Collector that counts the number of the elements
        Long evenCount = numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.counting());
        System.out.println(evenCount);

        System.out.println("******SummingINT()*******");
        //summingInt(ToIntFunction) : returns a Collector that produces the sum of a integer-valued func
        Integer sum = DishData.getAll().stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);


        System.out.println("******AvarageInt(ToIntFunction)*******");
        //AvarageInt(ToIntFunction) : returns the avarage of the integers passed values
        Double coloriAvg = DishData.getAll().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(coloriAvg);


        System.out.println("******joining()*******");
        //joining() : is used to join various elements of a character or string array into a single string object
        List<String> courses = Arrays.asList("Java","JS","TS");
        String str = courses.stream()
                .collect(Collectors.joining(","));
        System.out.println(str);


        System.out.println("******partioningBy()*******");
        //partioningBy() : is used to partition a stream of objects(or set of elements) based on a given predicate
        Map<Boolean,List<Dish>>veggieDish = DishData.getAll().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));

        System.out.println(veggieDish);

        System.out.println("******groupingBy()*******");
        //groupingBY : is used for grouping objects by some property and storing results in a map instance
        Map<Type,List<Dish>> dishtype = DishData.getAll().stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishtype);
    }
}
