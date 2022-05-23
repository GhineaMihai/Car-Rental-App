package com.example.carrentaljavafx;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        Car_Rental_Repository data;
        ArrayList<String> renters = new ArrayList<String>();
        int re[] = new int[10];
        int o = 0;
        data = new Car_Rental_Repository(new ArrayList<Car_Rental>());
        int i = 1;
        data.add_car(new Car_Rental(i, 300,"BMW","X6"));
        i = i + 1;
        Car_Rental c1 = new Car_Rental(i, 150,"Suzuki","Ignis");
        data.add_car(c1);
        Scanner s = new Scanner(System.in);

        Car_Rental_Repository_Text r = new Car_Rental_Repository_Text(data);
        Car_Rental_Repository_Binary b = new Car_Rental_Repository_Binary(data);

        System.out.println("0 - Stop");
        System.out.println("1 - Add car for rental (price, name, model)");
        System.out.println("2 - Remove car from rental (id)");
        System.out.println("3 - Print all cars");
        System.out.println("4 - Print only rented cars");
        System.out.println("5 - Print only available cars");
        System.out.println("6 - Reserve a car(id, only available cars)");
        System.out.println("7 - Cancel a reservation(id, only reserved cars)");
        System.out.println("8 - Show reservation date(id, only reserved cars)");
        System.out.println("9 - Read from file into repository (Input.txt) ");
        System.out.println("10 - Write from repository into file (Output.txt) ");
        System.out.println("11 - Read from binary file into repository (InputBinary) ");
        System.out.println("12 - Write from repository into binary file (OutputBinary) ");
        System.out.println("13 - Check how many cars a name has rented ");
        System.out.println("14 - Check who is renting a car ");
        System.out.println("15 - Check what cars a name has rented ");
        System.out.println("16 - Check if a car is rented ");
        System.out.println("17 - Print all the people that have rented at least a car ");
        boolean z = true;
        while(z)
        {
            int a=s.nextInt();
            if (a == 1)
            {
                i++;
                int p;
                String n;
                String m;
                String h;
                System.out.print("Car rental price: ");
                p = s.nextInt();
                h = s.nextLine();
                System.out.print("Car name: ");
                n = s.nextLine();
                System.out.print("Car model: ");
                m = s.nextLine();
                data.add_car(new Car_Rental(i, p, n, m));
            }

            if (a == 2)
            {
                System.out.print("Select the id of the car you want to be removed");
                int h=s.nextInt();
                data.remove_car(h);
                i--;

            }

            if (a == 3)
            {
                data.print_all();
            }

            if (a == 4)
            {
                data.print_rented();
            }

            if (a == 5)
            {
                data.print_available();
            }

            if (a == 6)
            {
                int id;
                int d;
                int m;
                int y;
                String name;
                System.out.println("Choose the id of the car you want to rent");
                id = s.nextInt();
                System.out.println("Choose the rental date: ");
                System.out.print("Day: ");
                d = s.nextInt();
                System.out.print("Month: ");
                m = s.nextInt();
                System.out.print("Year: ");
                y = s.nextInt();
                System.out.print("What is your name? ");
                String rs = s.nextLine();
                rs = s.nextLine();
                data.reserve(id, d, m, y, rs);
            }

            if (a == 7)
            {
                int id;
                System.out.println("Choose the id of the car you want to cancel the reservation of");
                id = s.nextInt();
                data.cancel(id);
            }

            if (a == 8)
            {
                int id;
                System.out.println("Choose the id of the car of which you want to see the reservation date");
                id = s.nextInt();
                data.reservation_date(id);
            }

            if (a == 9)
            {
                if(data.size_data() != 0)
                    for(int j = 0; j <= data.size_data(); j++)
                        data.remove_car(1);
                r.readFromFile();
            }

            if (a == 10)
            {
                r.writeToFile();
            }

            if (a == 11)
            {
                if(data.size_data() != 0)
                    for(int j = 0; j <= data.size_data(); j++)
                        data.remove_car(1);
                b.readFromBinary();
            }

            if (a == 12)
            {
                b.writeToBinary();
            }

            if (a == 13)
            {
                System.out.println("What is your name? ");
                String nm = s.nextLine();
                nm = s.nextLine();
                int k = 0;
                for (int j = 0; j < data.size_data(); j++)
                {
                    if (data.data.get(j).getRent() != null && nm.equals(data.data.get(j).getRent()))
                    {
                        k++;
                    }
                }
                System.out.println("You have rented " + k + " car(s) ");
            }

            if (a == 14)
            {
                System.out.println("Select the id of the car you want to check ");
                int h=s.nextInt();
                System.out.println(data.data.get(h-1).getRent());
            }

            if (a == 15)
            {
                System.out.println("What is the name you want to check? ");
                String nm = s.nextLine();
                nm = s.nextLine();
                int k = 0;
                for (int j = 0; j < data.size_data(); j++)
                {
                    if (nm.equals(data.data.get(j).getRent()))
                    {
                        System.out.println(data.data.get(j).getId());
                    }
                }
            }

            if (a == 16)
            {
                System.out.println("Select the id of the car you want to check ");
                int h=s.nextInt();
                if(data.data.get(h-1).getDay() == 0)
                {
                    System.out.println("Car is not rented ");
                }
                else
                {
                    System.out.println("Car is rented ");
                }
            }

            if (a == 17)
            {
                for (int j = 0; j < data.size_data(); j++)
                {
                    if(data.data.get(j).getRent() != null)
                        System.out.print(data.data.get(j).getRent() + " ");
                }
            }

            if (a == 0)
            {
                z = false;
            }
            if (a > 17 || a < 0)
            {
                System.out.println("Please choose one of the options (1-8) ");
            }
        }
    }
}
