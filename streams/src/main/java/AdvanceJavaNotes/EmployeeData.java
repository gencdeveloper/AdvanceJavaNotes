package AdvanceJavaNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class EmployeeData {
    public static Stream<Employee> readAll(){ //directly stream method
       return Stream.of(
               new Employee(100,"Mike","mike@cydeo.com", Arrays.asList("202324324","32432432423")),
               new Employee(101,"Ozzy","ozzy@cydeo.com", Arrays.asList("202324324","32432432423")),
               new Employee(102,"Peter","peter@cydeo.com", Arrays.asList("202324324","32432432423"))
       );
    }
}
