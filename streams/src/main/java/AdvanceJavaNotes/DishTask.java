package AdvanceJavaNotes;

import java.util.Comparator;

public class DishTask {
    public static void main(String[] args) {

        //Print all dishe's name that less than 400 calories
        System.out.println("********************************");
        DishData.getAll().stream()
                .filter(dish->dish.getCalories()<400)
                .map(Dish::getName)// dish -> dish.getName() -->same
                .forEach(System.out::println); //dish-> System.out.println(dish) --> same


        //Print the length of the name of each dish
        System.out.println("********************************");
        DishData.getAll() //this is our source
                .stream() //we converted stream
                .map(Dish::getName)//intermediate operation
                .map(String::length)//intermediate operation
                .forEach(System.out::println);//terminate operation

        //Print Three the High Caloric Dish Name (>300)
        System.out.println("********************************");
        DishData.getAll().stream()
                .filter(dish->dish.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .forEach(System.out::println);


        //Print all dish name that are below 400 calories in sorted WITH DESENDING!
        System.out.println("********************************");
        DishData.getAll().stream()
                .filter(dish->dish.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .forEach(System.out::println);


    }
}
