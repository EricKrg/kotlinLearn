package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer phil = new Customer(1,"Phil");

        CustomerDB db = new CustomerDB();
        List<Customer> customerList = db.getCustomers();
        //customerList.add(phil); // that is actually not possible in kotlin, bc it is in immutable list
        // but it is only hidden in kotlin not in java, but you get an ex. when executing this code

        //---
        // catch an ex. from an kotlin method
        try {
            db.addCustomer(phil);
            // an kotlin class needs an explicit throw ano., for the java class to catch it
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //---
        // Static functions need to call the companion object and then the fun
        CustomerDB.Companion.helloWorld();
        // or add an ano. to the kotlin class
        CustomerDB.helloPluto();

    }
}
