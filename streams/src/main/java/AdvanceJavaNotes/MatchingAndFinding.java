package AdvanceJavaNotes;

import java.util.Optional;

public class MatchingAndFinding {
    public static void main(String[] args) {
        /**
         * allMatch:
         * Think of the allMatch operator like a test for a group of things.
         * It checks if every item in a list meets a certain condition.
         * If all of them pass the test, it says "yes, they all match!" and gives you true.
         * But if even one item fails the test, it says "no, not all of them match" and gives you false.
         * */
        //ALL MATCH
        System.out.println("***********************");
        boolean isHealthy = DishData.getAll().stream().allMatch(dish -> dish.getCalories()<1000);
        System.out.println(isHealthy);



        /**
         *anyMatch:
         * The anyMatch operator is like asking if there's a superhero in a group.
         * It checks if at least one item in a list satisfies a specific condition.
         * If there's even a single one that fits the description, it happily says "yes, there's at least one!" and gives you true.
         * But if none of them match, it disappointingly says "nope, there's none" and gives you false.
         * */
        //ANY MATCH
        System.out.println("***********************");
        if (DishData.getAll().stream().anyMatch(Dish::isVegetarian))
            System.out.println("The menu is vegeterian friendly");




        /**
         * noneMatch:
         * Imagine a test where nobody gets full marks.
         * The noneMatch operator does something similar.
         * It checks if none of the items in a list meet a certain condition.
         * If nobody passes the test, it happily says "yes, none of them match!" and gives you true.
         * But if even one person manages to pass, it sadly says "uh-oh, someone matched" and gives you false.
         * */
        //NONE MATCH
        System.out.println("***********************");
       boolean isHealty2 =  DishData.getAll().stream().noneMatch(dish -> dish.getCalories()>=1000);
        System.out.println(isHealty2);



        //FIND ANY
        System.out.println("***********************");
        Optional<Dish> dish = DishData.getAll().stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish.get());



        //FIND First
        System.out.println("***********************");
        Optional<Dish> dish2 = DishData.getAll().stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        System.out.println(dish.get());
    }


}
