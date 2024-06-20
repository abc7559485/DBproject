package DB_folder;
import java.sql.*;

public class CreateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://0.tcp.jp.ngrok.io:11051/411177005";

        String user = "411177005";
        String password = "411177005";
        Class.forName(driver);
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, user, password);
        //gui.textArea_1.append("Success: Connected to the database!\n");
        System.out.println("Success: Connected to the database!");

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Brand (brand_name) VALUES" +
                "('Toyota')," +
                "('Ford')," +
                "('BMW')," +
                "('Honda');");

        stmt.executeUpdate("INSERT INTO Model (brand_ID, model_name, type) VALUES" +
                "(1, 'Corolla', 'SUV')," +
                "(1, 'Camry', 'SRV')," +
                "(1, 'RAV4', 'CRV')," +
                "(2, 'F-150', 'SUV')," +
                "(2, 'Mustang', 'SRV')," +
                "(2, 'Explorer', 'CRV')," +
                "(3, '3 Series', 'SUV')," +
                "(3, '5 Series', 'SRV')," +
                "(3, 'X5', 'CRV')," +
                "(4, 'Civic', 'SUV')," +
                "(4, 'Accord', 'SRV')," +
                "(4, 'CR-V', 'CRV');");

        stmt.executeUpdate("INSERT INTO Part (part_name) VALUES" +
                "('Alternator')," +
                "('Battery')," +
                "('Brake Pads')," +
                "('Clutch')," +
                "('Exhaust System')," +
                "('Fuel Injector')," +
                "('Radiator')," +
                "('Spark Plug')," +
                "('Starter Motor')," +
                "('Suspension')," +
                "('Timing Belt')," +
                "('Turbocharger')," +
                "('Water Pump')," +
                "('Waboo transmission')," +
                "('Air Filter');");

        stmt.executeUpdate("INSERT INTO Supplier (supplier_name) VALUES" +
                "('Supplier A')," +
                "('Supplier B')," +
                "('Getrag');");

        stmt.executeUpdate("INSERT INTO Customer (customer_name, address, phone_number, gender, income, type) VALUES" +
                "('Alice Smith', '321 Elm St', '5554321', 'Female', 50000, 'Individual')," +
                "('Bob Johnson', '654 Maple St', '5555678', 'Male', 60000, 'Individual')," +
                "('Charlie Brown', '987 Birch St', '5558765', NULL, NULL, 'Company')," +
                "('David Clark', '111 Cedar St', '5551234', 'Male', 55000, 'Individual')," +
                "('Eva Johnson', '222 Pine St', '5552345', 'Female', 52000, 'Individual')," +
                "('Frank White', '333 Oak St', '5553456', NULL, NULL, 'Company')," +
                "('Grace Lee', '444 Maple St', '5554567', 'Female', 65000, 'Individual')," +
                "('Hannah Kim', '555 Birch St', '5555678', 'Female', 49000, 'Individual')," +
                "('Ian Green', '666 Cedar St', '5556789', NULL, NULL, 'Company')," +
                "('Jack Brown', '777 Elm St', '5557890', 'Male', 63000, 'Individual')," +
                "('Karen Black', '888 Pine St', '5558901', 'Female', 58000, 'Individual')," +
                "('Leo Thompson', '999 Oak St', '5559012', NULL, NULL, 'Company')," +
                "('Mia Wilson', '100 Birch St', '5550123', 'Female', 61000, 'Individual')," +
                "('Noah Davis', '200 Cedar St', '5551235', 'Male', 53000, 'Individual')," +
                "('Olivia Martinez', '300 Maple St', '5552346', 'Female', 71000, 'Individual')," +
                "('Paul Anderson', '400 Elm St', '5553457', NULL, NULL, 'Company')," +
                "('Quinn Young', '500 Pine St', '5554568', 'Female', 48000, 'Individual')," +
                "('Rachel Harris', '600 Oak St', '5555679', 'Female', 67000, 'Individual')," +
                "('Sam Walker', '700 Birch St', '5556780', 'Male', 59000, 'Individual')," +
                "('Tina Hall', '800 Cedar St', '5557891', 'Female', 56000, 'Individual')," +
                "('Uma Scott', '900 Maple St', '5558902', NULL, NULL, 'Company')," +
                "('Victor King', '101 Elm St', '5559013', 'Male', 80000, 'Individual')," +
                "('Wendy Carter', '202 Pine St', '5550124', 'Female', 51000, 'Individual')," +
                "('Xander Perez', '303 Oak St', '5551236', NULL, NULL, 'Company')," +
                "('Yara Morgan', '404 Birch St', '5552347', 'Female', 66000, 'Individual')," +
                "('Zachary Bell', '505 Cedar St', '5553458', 'Male', 75000, 'Individual');");

        stmt.executeUpdate("INSERT INTO Dealer (dealer_name, address, phone_number) VALUES" +
                "('Dealer 1', '123 Main St', '5551234')," +
                "('Dealer 2', '456 Oak St', '5555678')," +
                "('Dealer 3', '789 Pine St', '5558765');");

        stmt.executeUpdate("INSERT INTO Manufacturer (manufacturer_name, type) VALUES" +
                "('Manufacturer X', 'assembly')," +
                "('Manufacturer Y', 'part')," +
                "('Manufacturer Z', 'part');");

        stmt.executeUpdate("INSERT INTO Vehicle (VIN, model_ID, color, engine, transmission) VALUES" +
                "(1001, 1, 'Red', 'V4', 'Automatic')," +
                "(1002, 1, 'Blue', 'V4', 'Manual')," +
                "(1003, 1, 'White', 'V6', 'Automatic')," +
                "(1004, 2, 'Black', 'V6', 'Manual')," +
                "(1005, 2, 'Silver', 'V6', 'Automatic')," +
                "(1006, 2, 'Gray', 'V8', 'Manual')," +
                "(1007, 3, 'Red', 'V6', 'Automatic')," +
                "(1008, 3, 'Blue', 'V4', 'Manual')," +
                "(1009, 3, 'White', 'V4', 'Automatic')," +
                "(1010, 4, 'Black', 'V8', 'Automatic')," +
                "(1011, 4, 'Silver', 'V6', 'Manual')," +
                "(1012, 4, 'Gray', 'V8', 'Automatic')," +
                "(1013, 5, 'Red', 'V6', 'Manual')," +
                "(1014, 5, 'Blue', 'V8', 'Automatic')," +
                "(1015, 5, 'White', 'V6', 'Manual')," +
                "(1016, 6, 'Black', 'V8', 'Automatic')," +
                "(1017, 6, 'Silver', 'V6', 'Manual')," +
                "(1018, 6, 'Gray', 'V8', 'Automatic')," +
                "(1019, 7, 'Red', 'V4', 'Manual')," +
                "(1020, 7, 'Blue', 'V6', 'Automatic')," +
                "(1021, 7, 'White', 'V4', 'Manual')," +
                "(1022, 8, 'Black', 'V8', 'Automatic')," +
                "(1023, 8, 'Silver', 'V6', 'Manual')," +
                "(1024, 8, 'Gray', 'V8', 'Automatic')," +
                "(1025, 9, 'Red', 'V4', 'Automatic')," +
                "(1026, 9, 'Blue', 'V6', 'Manual')," +
                "(1027, 9, 'White', 'V6', 'Automatic')," +
                "(1028, 10, 'Black', 'V4', 'Manual')," +
                "(1029, 10, 'Silver', 'V6', 'Automatic')," +
                "(1030, 10, 'Gray', 'V4', 'Manual')," +
                "(1031, 11, 'Red', 'V6', 'Automatic')," +
                "(1032, 11, 'Blue', 'V8', 'Manual')," +
                "(1033, 11, 'White', 'V4', 'Automatic')," +
                "(1034, 12, 'Black', 'V6', 'Manual')," +
                "(1035, 12, 'Silver', 'V4', 'Automatic')," +
                "(1036, 12, 'Gray', 'V8', 'Manual');");

        stmt.executeUpdate("INSERT INTO Production (part_ID, supplier_ID, manufacture_date) VALUES" +
                "(1, 1, '2023-01-10')," +
                "(2, 1, '2023-01-15')," +
                "(3, 1, '2023-02-20')," +
                "(4, 2, '2023-02-25')," +
                "(5, 2, '2023-03-15')," +
                "(6, 2, '2023-04-18')," +
                "(7, 3, '2023-04-20')," +
                "(8, 3, '2023-05-22')," +
                "(9, 3, '2023-05-25')," +
                "(10, 1, '2023-06-18')," +
                "(11, 1, '2023-06-20')," +
                "(12, 2, '2023-07-10')," +
                "(13, 2, '2023-07-15')," +
                "(14, 3, '2023-08-10')," +
                "(15, 3, '2023-08-15');");

        stmt.executeUpdate("INSERT INTO VehiclePart (VIN, production_ID) VALUES" +
                "(1001, 1)," +
                "(1001, 2)," +
                "(1002, 3)," +
                "(1002, 4)," +
                "(1003, 5)," +
                "(1003, 6)," +
                "(1004, 7)," +
                "(1004, 8)," +
                "(1005, 9)," +
                "(1005, 10)," +
                "(1006, 11)," +
                "(1006, 12)," +
                "(1007, 13)," +
                "(1007, 14)," +
                "(1008, 15)," +
                "(1008, 1)," +
                "(1009, 2)," +
                "(1009, 3)," +
                "(1010, 4)," +
                "(1010, 5)," +
                "(1011, 6)," +
                "(1011, 7)," +
                "(1012, 8)," +
                "(1012, 9)," +
                "(1013, 10)," +
                "(1013, 11)," +
                "(1014, 12)," +
                "(1014, 13)," +
                "(1015, 14)," +
                "(1015, 15)," +
                "(1016, 1)," +
                "(1016, 2)," +
                "(1017, 3)," +
                "(1017, 4)," +
                "(1018, 5)," +
                "(1018, 6)," +
                "(1019, 7)," +
                "(1019, 8)," +
                "(1020, 9)," +
                "(1020, 10)," +
                "(1021, 11)," +
                "(1021, 12)," +
                "(1022, 13)," +
                "(1022, 14)," +
                "(1023, 15)," +
                "(1023, 1)," +
                "(1024, 2)," +
                "(1024, 3)," +
                "(1025, 4)," +
                "(1025, 5)," +
                "(1026, 6)," +
                "(1026, 7)," +
                "(1027, 8)," +
                "(1027, 9)," +
                "(1028, 10)," +
                "(1028, 11)," +
                "(1029, 12)," +
                "(1029, 13)," +
                "(1030, 14)," +
                "(1030, 15)," +
                "(1031, 1)," +
                "(1031, 2)," +
                "(1032, 3)," +
                "(1032, 4)," +
                "(1033, 5)," +
                "(1033, 6)," +
                "(1034, 7)," +
                "(1034, 8)," +
                "(1035, 9)," +
                "(1035, 10)," +
                "(1036, 11)," +
                "(1036, 12);");

        stmt.executeUpdate("INSERT INTO ManufacturerPart (manufacturer_ID, part_ID) VALUES" +
                "(1, 1)," +
                "(1, 2)," +
                "(1, 3)," +
                "(1, 4)," +
                "(1, 5)," +
                "(2, 6)," +
                "(2, 7)," +
                "(2, 8)," +
                "(2, 9)," +
                "(2, 10)," +
                "(3, 11)," +
                "(3, 12)," +
                "(3, 13)," +
                "(3, 14)," +
                "(3, 15)," +
                "(1, 6)," +
                "(2, 1)," +
                "(3, 2)," +
                "(1, 8)," +
                "(3, 10)," +
                "(1, 11)," +
                "(2, 12)," +
                "(1, 14)," +
                "(2, 15);");

        stmt.executeUpdate("INSERT INTO Inventory (dealer_ID, supplier_ID, VIN, is_sold, order_date) VALUES" +
                "(1, 1, 1001, FALSE, '2022-10-02')," +
                "(1, 2, 1002, TRUE, '2023-01-29')," +
                "(1, 3, 1003, FALSE, '2020-10-12')," +
                "(2, 1, 1004, TRUE, '2023-08-21')," +
                "(2, 2, 1005, FALSE, '2021-07-17')," +
                "(2, 3, 1006, TRUE, '2021-10-12')," +
                "(3, 1, 1007, FALSE, '2022-03-07')," +
                "(3, 2, 1008, TRUE, '2021-01-19')," +
                "(3, 3, 1009, FALSE, '2020-07-26')," +
                "(1, 1, 1010, TRUE, '2024-03-31')," +
                "(1, 2, 1011, FALSE, '2022-01-09')," +
                "(1, 3, 1012, TRUE, '2022-01-08')," +
                "(2, 1, 1013, FALSE, '2020-09-06')," +
                "(2, 2, 1014, TRUE, '2020-03-15')," +
                "(2, 3, 1015, FALSE, '2020-08-28')," +
                "(3, 1, 1016, TRUE, '2021-11-23')," +
                "(3, 2, 1017, FALSE, '2023-05-01')," +
                "(3, 3, 1018, TRUE, '2023-04-20')," +
                "(1, 1, 1019, FALSE, '2023-11-05')," +
                "(1, 2, 1020, TRUE, '2021-02-27')," +
                "(1, 3, 1021, FALSE, '2020-09-15')," +
                "(2, 1, 1022, TRUE, '2023-06-24')," +
                "(2, 2, 1023, FALSE, '2022-07-29')," +
                "(2, 3, 1024, TRUE, '2023-05-08')," +
                "(3, 1, 1025, FALSE, '2021-08-30')," +
                "(3, 2, 1026, TRUE, '2023-04-21')," +
                "(3, 3, 1027, FALSE, '2023-08-22')," +
                "(1, 1, 1028, TRUE, '2021-07-31')," +
                "(1, 2, 1029, FALSE, '2021-03-26')," +
                "(1, 3, 1030, TRUE, '2020-07-17')," +
                "(2, 1, 1031, FALSE, '2020-10-13')," +
                "(2, 2, 1032, TRUE, '2020-10-05')," +
                "(2, 3, 1033, FALSE, '2020-02-06')," +
                "(3, 1, 1034, TRUE, '2021-12-18')," +
                "(3, 2, 1035, FALSE, '2023-07-23')," +
                "(3, 3, 1036, TRUE, '2023-02-16');");

        stmt.executeUpdate("INSERT INTO Sales (customer_ID, inventory_ID, purchase_date, amounts) VALUES" +
                "(1, 2, '2024-06-01', 1000000)," +
                "(2, 4, '2024-06-02', 980000)," +
                "(3, 6, '2024-06-03', 760000)," +
                "(4, 8, '2024-06-04', 1320000)," +
                "(5, 10, '2024-06-05', 540000)," +
                "(6, 12, '2024-06-06', 780000)," +
                "(7, 14, '2024-06-07', 600000)," +
                "(8, 16, '2024-06-08', 1200000)," +
                "(9, 18, '2024-06-09', 700000)," +
                "(10, 20, '2024-06-10', 880000)," +
                "(11, 22, '2024-06-11', 990000)," +
                "(12, 24, '2024-06-12', 1550000)," +
                "(13, 26, '2024-06-13', 480000)," +
                "(14, 28, '2024-06-14', 620000)," +
                "(15, 30, '2024-06-15', 730000)," +
                "(16, 32, '2024-06-16', 830000)," +
                "(17, 34, '2024-06-17', 890000)");
    }
}
