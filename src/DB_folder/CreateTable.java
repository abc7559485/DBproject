package DB_folder;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
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



        ResultSet rs = stmt.executeQuery("SHOW TABLES;");     /*將所有表全部移除，須執行三次左右*/
        stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
        while (rs.next()) {
            String tableName = rs.getString(1);
            try {
                // Drop each table
                stmt.executeUpdate("DROP TABLE IF EXISTS " + tableName + " CASCADE;");
                System.out.println("Table " + tableName + " dropped successfully");
            } catch (SQLException e) {
                System.err.println("Error dropping table " + tableName + ": " + e.getMessage());
            }
        }
        stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");


//
        String Brand =  "CREATE TABLE IF NOT EXISTS Brand (" +
                        "brand_ID INTEGER NOT NULL AUTO_INCREMENT," +
                        "brand_name VARCHAR(45) NOT NULL UNIQUE," +
                        "PRIMARY KEY (brand_ID)" +
                        ")";
       stmt.executeUpdate(Brand);
       System.out.println("Brand create successfully");
//
        String Model =  "CREATE TABLE IF NOT EXISTS Model (" +
                        "model_ID INTEGER NOT NULL AUTO_INCREMENT," +
                        "brand_ID INTEGER NOT NULL," +
                        "model_name VARCHAR(45) NOT NULL UNIQUE," +
                        "type enum('SUV', 'SRV', 'CRV') NOT NULL," +
                        "PRIMARY KEY (model_ID, brand_ID)," +
                        "FOREIGN KEY (brand_ID) REFERENCES Brand(brand_ID)" +
                        "ON UPDATE CASCADE ON DELETE CASCADE"+
                        ")";
        stmt.executeUpdate(Model);
        System.out.println("Model create successfully");

        String Vehicle =    "CREATE TABLE IF NOT EXISTS Vehicle (" +
                            "VIN INTEGER NOT NULL UNIQUE," +
                            "model_ID INTEGER NOT NULL," +
                            "color VARCHAR(45) NOT NULL," +
                            "engine VARCHAR(45) NOT NULL," +
                            "transmission VARCHAR(45) NOT NULL," +
                            "PRIMARY KEY (VIN)," +
                            "FOREIGN KEY (model_ID) REFERENCES Model(model_ID)" +
                            "ON UPDATE CASCADE ON DELETE CASCADE" +
                            ")";

        stmt.executeUpdate(Vehicle);
        System.out.println("Vehicle create successfully");
//
//
        String Part =   "CREATE TABLE IF NOT EXISTS Part (" +
                        "part_ID INTEGER AUTO_INCREMENT," +
                        "part_name VARCHAR(45) NOT NULL," +
                        "PRIMARY KEY (part_ID)" +
                        ")";
        stmt.executeUpdate(Part);
        System.out.println("Part create successfully");

//        String ModelPart =  "CREATE TABLE IF NOT EXISTS ModelPart (" +
//                            "model_ID INTEGER NOT NULL," +
//                            "part_ID INTEGER NOT NULL," +
//                            "PRIMARY KEY (model_ID, part_ID)," +
//                            "FOREIGN KEY (model_ID) REFERENCES Model(model_ID)" +
//                            "ON UPDATE CASCADE ON DELETE CASCADE," +
//                            "FOREIGN KEY (part_ID) REFERENCES Part(part_ID)" +
//                            "ON UPDATE CASCADE ON DELETE CASCADE" +
//                            ")";
//        stmt.executeUpdate(ModelPart);
//        System.out.println("ModelPart create successfully");

//
        String Supplier =   "CREATE TABLE IF NOT EXISTS Supplier (" +
                            "supplier_ID INTEGER AUTO_INCREMENT," +
                            "supplier_name VARCHAR(45) NOT NULL," +
                            "PRIMARY KEY (supplier_ID)" +
                            ")";
        stmt.executeUpdate(Supplier);
        System.out.println("Supplier create successfully");

        String Production = "CREATE TABLE IF NOT EXISTS Production (" +
                            "production_ID INTEGER AUTO_INCREMENT," +
                            "part_ID INTEGER NOT NULL," +
                            "supplier_ID INTEGER NOT NULL," +
                            "manufacture_date DATE NOT NULL," +
                            "UNIQUE (part_ID, supplier_ID,manufacture_date)," +
                            "PRIMARY KEY (production_ID)," +
                            "FOREIGN KEY (supplier_ID) REFERENCES Supplier(supplier_ID) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE," +
                            "FOREIGN KEY (part_ID) REFERENCES Part(part_ID) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE" +
                            ")";
        stmt.executeUpdate(Production);
        System.out.println("Production create successfully");

        String VehiclePart =    "CREATE TABLE IF NOT EXISTS VehiclePart (" +
                "VIN INTEGER NOT NULL," +
                "production_ID INTEGER NOT NULL," +
                "PRIMARY KEY (VIN, production_ID)," +
                "FOREIGN KEY (VIN) REFERENCES Vehicle(VIN)" +
                "ON UPDATE CASCADE ON DELETE CASCADE," +
                "FOREIGN KEY (production_ID) REFERENCES Production(production_ID)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";
        stmt.executeUpdate(VehiclePart);
        System.out.println("VehiclePart create successfully");

//
//        String SupplierPart =   "CREATE TABLE IF NOT EXISTS SupplierPart (" +
//                                "supplier_ID INTEGER NOT NULL," +
//                                "part_ID INTEGER NOT NULL," +
//                                "PRIMARY KEY (supplier_ID, part_ID) ," +
//                                "FOREIGN KEY (supplier_ID) REFERENCES Supplier(supplier_ID)" +
//                                "ON UPDATE CASCADE ON DELETE CASCADE," +
//                                "FOREIGN KEY (part_ID) REFERENCES Part(part_ID)" +
//                                "ON UPDATE CASCADE ON DELETE CASCADE" +
//                                ")";
//        stmt.executeUpdate(SupplierPart);
//        System.out.println("SupplierPart create successfully");
//
        String Manufacturer =   "CREATE TABLE IF NOT EXISTS Manufacturer (" +
                                "manufacturer_ID INTEGER AUTO_INCREMENT," +
                                "manufacturer_name VARCHAR(45) NOT NULL," +
                                "type ENUM('assembly', 'part')," +
                                "PRIMARY KEY (manufacturer_ID)" +
                                ")";
        stmt.executeUpdate(Manufacturer);
        System.out.println("Manufacturer create successfully");
//
        String ManufacturerPart =   "CREATE TABLE IF NOT EXISTS ManufacturerPart (" +
                                    "manufacturer_ID INTEGER NOT NULL, " +
                                    "part_ID INTEGER NOT NULL, " +
                                    "PRIMARY KEY (manufacturer_ID, part_ID), " +
                                    "FOREIGN KEY (manufacturer_ID) REFERENCES Manufacturer(manufacturer_ID) " +
                                    "ON UPDATE CASCADE ON DELETE CASCADE," +
                                    "FOREIGN KEY (part_ID) REFERENCES Part(part_ID)" +
                                    "ON UPDATE CASCADE ON DELETE CASCADE" +
                                    ")";
        stmt.executeUpdate(ManufacturerPart);
        System.out.println("ManufacturerPart create successfully");
//
        String Dealer = "CREATE TABLE IF NOT EXISTS Dealer (" +
                        "dealer_ID INTEGER AUTO_INCREMENT," +
                        "dealer_name VARCHAR(45) NOT NULL," +
                        "address VARCHAR(45) NOT NULL," +
                        "phone_number VARCHAR(10) NOT NULL," +
                        "PRIMARY KEY (dealer_ID)" +
                        ")";
        stmt.executeUpdate(Dealer);
        System.out.println("Dealer create successfully");
//
        String Inventory =  "CREATE TABLE IF NOT EXISTS Inventory (" +
                            "inventory_ID INTEGER AUTO_INCREMENT," +
                            "dealer_ID INTEGER NOT NULL, " +
                            "supplier_ID INTEGER NOT NULL, " +
                            "VIN INTEGER NOT NULL, " +
                            "is_sold BOOLEAN NOT NULL DEFAULT FALSE," +
                            "order_date DATE NOT NULL DEFAULT CURDATE()," +
                            "PRIMARY KEY (inventory_ID), " +
                            "UNIQUE (dealer_ID, supplier_ID, VIN)," +
                            "FOREIGN KEY (dealer_ID) REFERENCES Dealer(dealer_ID) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE," +
                            "FOREIGN KEY (supplier_ID) REFERENCES Supplier(supplier_ID) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE," +
                            "FOREIGN KEY (VIN) REFERENCES Vehicle(VIN)" +
                            "ON UPDATE CASCADE ON DELETE CASCADE" +
                            ")";
        stmt.executeUpdate(Inventory);
        System.out.println("Inventory create successfully");

        String Customer =   "CREATE TABLE IF NOT EXISTS Customer (" +
                            "customer_ID INTEGER AUTO_INCREMENT," +
                            "customer_name VARCHAR(45) NOT NULL," +
                            "address VARCHAR(45) NOT NULL," +
                            "phone_number VARCHAR(10) NOT NULL," +
                            "gender ENUM('Male', 'Female') DEFAULT NULL," +
                            "income INTEGER DEFAULT NULL," +
                            "type ENUM('Individual', 'Company')," +
                            "PRIMARY KEY(customer_ID)" +
                            ")";
        stmt.executeUpdate(Customer);
        System.out.println("Customer create successfully");
//
        String Sales =  "CREATE TABLE IF NOT EXISTS Sales (" +
                        "sale_ID INTEGER NOT NULL AUTO_INCREMENT, " +
                        "customer_ID INTEGER NOT NULL, " +
                        "inventory_ID INTEGER NOT NULL," +
                        "purchase_date DATE NOT NULL, " +
                        "amounts INTEGER NOT NULL DEFAULT 0, " +
                        "PRIMARY KEY (sale_ID), " +
                        "FOREIGN KEY (customer_ID) REFERENCES Customer(customer_ID) " +
                        "ON UPDATE CASCADE ON DELETE CASCADE," +
                        "FOREIGN KEY (inventory_ID) REFERENCES Inventory(inventory_ID)" +
                        "ON UPDATE CASCADE ON DELETE CASCADE" +
                        ")";
        stmt.executeUpdate(Sales);
        System.out.println("Sales create successfully");
        //stmt.executeUpdate("ALTER TABLE Sales ADD amount INTEGER NOT NULL DEFAULT 0");
       // stmt.executeUpdate("DELETE FROM Sales");
       // stmt.executeUpdate("UPDATE Sales SET amount = 750000");

        System.out.println("Add successfully");
        stmt.close();
        connection.close();
    }
}
