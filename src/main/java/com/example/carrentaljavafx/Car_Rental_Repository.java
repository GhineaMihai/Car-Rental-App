package com.example.carrentaljavafx;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Car_Rental_Repository {
    public ArrayList<Car_Rental> data;

    public Car_Rental_Repository(ArrayList<Car_Rental> data) {
        this.data = data;
    }

    void add_car(Car_Rental Car) {
        this.data.add(Car);
    }

    void remove_car(int i) {
        if (this.data.size() >= i) {
            this.data.remove(i - 1);

            for(int j = i - 1; j < this.data.size(); ++j) {
                ((Car_Rental)this.data.get(j)).setId(((Car_Rental)this.data.get(j)).getId() - 1);
            }
        } else {
            System.out.println("That id does not exist");
        }

    }

    void print_all() {
        Iterator var1 = this.data.iterator();

        while(var1.hasNext()) {
            Car_Rental elem = (Car_Rental)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = elem.getId();
            var10000.println("Id: " + var10001 + " Price: " + elem.getPrice() + " Name: " + elem.getName() + " Model: " + elem.getModel());
        }

    }

    void print_rented() {
        boolean ok = false;
        Iterator var2 = this.data.iterator();

        while(var2.hasNext()) {
            Car_Rental elem = (Car_Rental)var2.next();
            if (elem.getDay() != 0) {
                ok = true;
                PrintStream var10000 = System.out;
                int var10001 = elem.getId();
                var10000.println("Id: " + var10001 + " Price: " + elem.getPrice() + " Name: " + elem.getName() + " Model: " + elem.getModel());
            }
        }

        if (!ok) {
            System.out.println("There are no rented cars");
        }

    }

    void print_available() {
        boolean ok = false;
        Iterator var2 = this.data.iterator();

        while(var2.hasNext()) {
            Car_Rental elem = (Car_Rental)var2.next();
            if (elem.getDay() == 0) {
                ok = true;
                PrintStream var10000 = System.out;
                int var10001 = elem.getId();
                var10000.println("Id: " + var10001 + " Price: " + elem.getPrice() + " Name: " + elem.getName() + " Model: " + elem.getModel());
            }
        }

        if (!ok) {
            System.out.println("There are no available cars");
        }

    }

    void reserve(int i, int d, int m, int y, String name) {
        if (((Car_Rental)this.data.get(i - 1)).getDay() == 0) {
            ((Car_Rental)this.data.get(i - 1)).setDay(d);
            ((Car_Rental)this.data.get(i - 1)).setMonth(m);
            ((Car_Rental)this.data.get(i - 1)).setYear(y);
            ((Car_Rental)this.data.get(i - 1)).setRent(name);
        } else {
            System.out.println("That car is already rented");
        }

    }

    void cancel(int i) {
        if (((Car_Rental)this.data.get(i - 1)).getDay() != 0) {
            ((Car_Rental)this.data.get(i - 1)).setDay(0);
            ((Car_Rental)this.data.get(i - 1)).setMonth(0);
            ((Car_Rental)this.data.get(i - 1)).setYear(0);
            ((Car_Rental)this.data.get(i - 1)).setRent((String)null);
        } else {
            System.out.println("That car is not rented");
        }

    }

    void reservation_date(int i) {
        if (((Car_Rental)this.data.get(i - 1)).getDay() != 0) {
            PrintStream var10000 = System.out;
            int var10001 = ((Car_Rental)this.data.get(i - 1)).getDay();
            var10000.println(var10001 + "/" + ((Car_Rental)this.data.get(i - 1)).getMonth() + "/" + ((Car_Rental)this.data.get(i - 1)).getYear());
        } else {
            System.out.println("That car is not rented");
        }

    }

    int size_data() {
        return this.data.size();
    }
}
