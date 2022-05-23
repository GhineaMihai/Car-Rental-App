package com.example.carrentaljavafx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class Car_Rental_Repository_Text {
    private String filename;
    private Car_Rental_Repository Repo;

    public Car_Rental_Repository_Text(Car_Rental_Repository Repo) {
        this.Repo = Repo;
    }

    public Car_Rental_Repository_Text() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("properties.txt"));
            String FileName = properties.getProperty("filenameTXT");
            if (FileName == null) {
                FileName = "Input.txt";
                System.err.println("Requests file not found. Using default" + FileName);
            }

            this.filename = FileName;
            this.readFromFile();
        } catch (IOException var3) {
            System.err.println("Error reading the configuration file" + var3);
        }

    }

    public void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\CarRentalJavaFX\\Input.txt"));

            String st;
            while((st = br.readLine()) != null) {
                String[] el = st.split(",");
                if (el.length != 4) {
                    System.err.println("Not a valid number of attributes" + st);
                } else {
                    try {
                        int Id = Integer.parseInt(el[0]);
                        int price = Integer.parseInt(el[1]);
                        Car_Rental c = new Car_Rental(Id, price, el[2], el[3]);
                        this.Repo.add_car(c);
                    } catch (NumberFormatException var7) {
                        System.err.println("The ID is not a valid number" + el[0]);
                    }
                }
            }
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public void writeToFile() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\CarRentalJavaFX\\Output.txt");

            try {
                for(int i = 1; i <= this.Repo.size_data(); ++i) {
                    int var10000 = ((Car_Rental)this.Repo.data.get(i - 1)).getId();
                    String line = var10000 + "," + ((Car_Rental)this.Repo.data.get(i - 1)).getPrice() + "," + ((Car_Rental)this.Repo.data.get(i - 1)).getName() + "," + ((Car_Rental)this.Repo.data.get(i - 1)).getModel();
                    pw.println(line);
                }
            } catch (Throwable var5) {
                try {
                    pw.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            pw.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}
