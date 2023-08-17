package AdvanceJavaNotes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(1,2,3,4,5,67,7,8,4,3);
        //filter.forEach(x-> System.out.println(x));
        //in this forEach belong to iterator
        myList.forEach(System.out::println); //this is same result with up

        /********FILTER************/
        System.out.println("FILTERRRRRRRRR WITH STREAM WITH CONDITION");
        //convert to stream
        //in this forEach belong to stream operator
       myList.stream()
               .filter(i-> i%3 ==0) //---->intermeditate operator
               .distinct() //---->intermeditate operator(distinct()--> check unique data)
               .forEach(System.out::println); //--->terminal operation

       /********LIMIT************/
        System.out.println("LIMITTT WITH STREAM WITH CONDITION");
        myList.stream()
                .filter(i -> i%2==0)
                .limit(1)//---->intermeditate operator(limit showing with limited number)
                .forEach(System.out::println);//--->terminal operation


        /********SKIP************/
        System.out.println("SKIP WITH STREAM WITH CONDITION");
        myList.stream()
                .filter(i -> i%2==0)
                .skip(2)//---->intermeditate operator(skip)
                .forEach(System.out::println);//--->terminal operation


        /********MAP************/
        System.out.println("MAP WITH STREAM WITH CONDITION");
        myList.stream()
                .map(number->number*2)
                .filter(i-> i%3 ==0)
                .forEach(System.out::println);
    }
}
