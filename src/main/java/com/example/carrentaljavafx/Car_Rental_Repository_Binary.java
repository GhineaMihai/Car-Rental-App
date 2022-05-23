package com.example.carrentaljavafx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class Car_Rental_Repository_Binary {
    private String filename;
    private Car_Rental_Repository Repo;
    int k = 0;

    public Car_Rental_Repository_Binary(Car_Rental_Repository Repo) {
        this.Repo = Repo;
    }

    public Car_Rental_Repository_Binary() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("properties.txt"));
            String FileName = properties.getProperty("filenameBINARY");
            if (FileName == null) {
                FileName = "InputBinary";
                System.err.println("Requests file not found. Using default" + FileName);
            }

            this.filename = FileName;
            this.readFromBinary();
        } catch (IOException var3) {
            System.err.println("Error reading the configuration file" + var3);
        }

    }

    public void readFromBinary() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\Java\\CarRentalJavaFX\\InputBinary"));

            try {
                for(int i = 0; i < this.k; ++i) {
                    Car_Rental c = (Car_Rental)in.readObject();
                    this.Repo.add_car(c);
                }
            } catch (Throwable var5) {
                try {
                    in.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            in.close();
        } catch (ClassNotFoundException | IOException var6) {
            var6.printStackTrace();
        }

    }

    public void writeToBinary() {
        try {
            ObjectOutputStream e = new ObjectOutputStream(new FileOutputStream("D:\\Java\\CarRentalJavaFX\\InputBinary"));

            try {
                for(int i = 1; i <= this.Repo.size_data(); ++i) {
                    ++this.k;
                    e.writeObject(this.Repo.data.get(i - 1));
                }
            } catch (Throwable var5) {
                try {
                    e.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            e.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}
