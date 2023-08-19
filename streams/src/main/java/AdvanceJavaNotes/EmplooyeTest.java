package AdvanceJavaNotes;

import java.util.List;

public class EmplooyeTest {
    public static void main(String[] args) {
        System.out.println("*************************");
        //Print all emails - One employee has one email - One to One
        EmployeeData.readAll()//this is already stream method so no need to type again stream
                .map(Employee::getEmpEmail)
                .forEach(System.out::println);


        //Print all phone numbers
        System.out.println("*************************");
        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .forEach(System.out::println);

        //Print with flapMap phoneNumbers
        System.out.println("*************************");
        EmployeeData.readAll()
                .flatMap(employee -> employee.getEmpPhoneNumbers().stream())
                .forEach(System.out::println);

        //Print with flapMap phoneNumbers second way
        System.out.println("*************************");
        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }

}
