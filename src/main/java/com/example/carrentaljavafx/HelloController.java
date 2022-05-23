package com.example.carrentaljavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    public Car_Rental_Repository data;
    Scanner s = new Scanner(System.in);
    int i=0;
    @FXML
    private ComboBox<String> print;
    @FXML
    private ComboBox<String> file;
    @FXML
    private ComboBox<String> binary;
    @FXML
    private Button remove;
    @FXML
    private Button add;
    @FXML
    private Button reserve;
    @FXML
    private Pane pane;
    @FXML
    private Label dates;
    @FXML
    private TextField name;
    @FXML
    private TextField model;
    @FXML
    private TextField price;
    @FXML
    private TextField namersrv;
    @FXML
    private TextField day;
    @FXML
    private TextField month;
    @FXML
    private TextField year;
    @FXML
    private TextField txtmany;
    @FXML
    private Label txtwho;
    @FXML
    private Label txtif;
    @FXML
    private TextField txtwhat;
    @FXML
    private Label txtmany1;
    @FXML
    private Button chkmany;
    @FXML
    private Button chkwho;
    @FXML
    private Button chkif;
    @FXML
    private Button chkwhat;
    @FXML
    private TableView<Car_Rental> table;
    ObservableList<String> list = FXCollections.observableArrayList("Print All", "Print Rented", "Print Available");
    ObservableList<String> list1 = FXCollections.observableArrayList("Read File", "Write File");
    ObservableList<String> list2 = FXCollections.observableArrayList("Read Binary", "Write Binary");
    public TableColumn<Car_Rental, Integer> colId;
    public TableColumn<Car_Rental, String> colName;
    public TableColumn<Car_Rental, String> colModel;
    public TableColumn<Car_Rental, Integer> colPrice;

    Car_Rental_Repository_Text r = new Car_Rental_Repository_Text(data);
    Car_Rental_Repository_Binary b = new Car_Rental_Repository_Binary(data);



    @FXML
    protected void initialize()
    {
        chkif.setTooltip(new Tooltip("Check if a car is rented"));
        chkwho.setTooltip(new Tooltip("Check who is renting a car"));
        chkwhat.setTooltip(new Tooltip("Check what cars a name has rented"));
        chkmany.setTooltip(new Tooltip("Check how many cars a name has rented"));
        data = new Car_Rental_Repository(new ArrayList<Car_Rental>());
        print.setItems(list);
        file.setItems(list1);
        binary.setItems(list2);
        colId.setCellValueFactory(new PropertyValueFactory<Car_Rental, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Car_Rental, String>("name"));
        colModel.setCellValueFactory(new PropertyValueFactory<Car_Rental, String>("model"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Car_Rental, Integer>("price"));
        i++;
        Car_Rental c1 = new Car_Rental(i, 150,"Suzuki","Ignis");
        table.getItems().add(c1);
        data.add_car(c1);
        i++;
        Car_Rental c2 = new Car_Rental(i, 300,"BMW","X6");
        table.getItems().add(c2);
        data.add_car(c2);
    }

    @FXML
    protected void PressAdd()
    {
        i++;
        String n = name.getText();
        String m = model.getText();
        int p = Integer.parseInt(price.getText());
        if (n!=null && m!=null && p!=0) {
            Car_Rental c1 = new Car_Rental(i, p, n, m);
            data.add_car(c1);
            table.getItems().add(c1);
        }
        name.clear();
        model.clear();
        price.clear();
    }

    @FXML
    protected void PressRemove()
    {
            Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
            int a;
            a = selectedItem.getId();
            data.remove_car(a);
            table.getItems().remove(selectedItem);
            System.out.println(selectedItem.getId());
            data.print_all();
            i--;
    }

    @FXML
    protected void PressPrint()
    {
            String a = print.getValue();
            if (a == "Print All")
            {
                table.getItems().clear();
                for(Car_Rental elem : data.data)
                {
                    table.getItems().add(elem);
                }
            }
            if (a == "Print Rented")
            {
                table.getItems().clear();
                for(Car_Rental elem : data.data)
                {
                    if(elem.getDay()!=0)
                        table.getItems().add(elem);
                }
            }
            if (a == "Print Available")
            {
                table.getItems().clear();
                for(Car_Rental elem : data.data)
                {
                    if(elem.getDay()==0)
                        table.getItems().add(elem);
                }
            }
    }


    @FXML
    protected void PressReserve()
    {
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        String n = namersrv.getText();
        int m = Integer.parseInt(day.getText());
        int o = Integer.parseInt(month.getText());
        int p = Integer.parseInt(year.getText());
        selectedItem.setRent(n);
        selectedItem.setYear(p);
        selectedItem.setMonth(o);
        selectedItem.setDay(m);
        data.print_rented();
        namersrv.clear();
        day.clear();
        month.clear();
        year.clear();
    }

    @FXML
    protected void PressCancel()
    {
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        selectedItem.setRent(null);
        selectedItem.setYear(0);
        selectedItem.setMonth(0);
        selectedItem.setDay(0);
        data.print_rented();
    }
    @FXML
    protected void PressShow()
    {
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem.getDay()!=0)
        {
            dates.setText(selectedItem.getRent() + ": " + selectedItem.getDay() + "/" + selectedItem.getMonth() + "/" + selectedItem.getYear());
        }
    }
    @FXML
    protected void PressFile()
    {
        String a = file.getValue();
        if (a == "Read File")
        {
            if(data.size_data() != 0)
            {
                for(int j = 0; j <= data.size_data(); j++)
                    data.remove_car(1);
                table.getItems().clear();
            }
            r.readFromFile();
            data.print_all();
            for(Car_Rental elem : data.data)
            {
                table.getItems().add(elem);
            }
        }
        if (a == "Print File")
        {
            r.writeToFile();
        }
    }

    @FXML
    protected void PressBinary()
    {
        String a = binary.getValue();
        if (a == "Read Binary")
        {
            if(data.size_data() != 0)
            {
                for(int j = 0; j <= data.size_data(); j++)
                    data.remove_car(1);
                table.getItems().clear();
            }
            b.readFromBinary();
            for(Car_Rental elem : data.data)
            {
                table.getItems().add(elem);
            }
        }
        if (a == "Print Binary")
        {
            b.writeToBinary();
        }
    }

    @FXML
    protected void PressWho()
    {
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        if(selectedItem.getDay()!=0)
        {
            txtwho.setText(selectedItem.getRent());
        }
    }

    @FXML
    protected void PressMany()
    {
        int k = 0;
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        for(Car_Rental elem : data.data)
        {
            if(elem.getRent() != null)
                if(elem.getRent().equals(txtmany.getText()))
                    k++;
        }
        txtmany1.setText(Integer.toString(k));
    }

    @FXML
    protected void PressWhat()
    {
        table.getItems().clear();
        for(Car_Rental elem : data.data)
        {
            if(elem.getRent() != null)
                if(elem.getRent().equals(txtwhat.getText()))
                    table.getItems().add(elem);
        }
        txtwhat.clear();
    }

    @FXML
    protected void PressIf()
    {
        Car_Rental selectedItem = table.getSelectionModel().getSelectedItem();
        if(selectedItem.getDay()!=0)
        {
            txtif.setText("Rented");
        }
        else
        {
            txtif.setText("Not rented");
        }
    }
}