package DB_folder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class Connector {
	public static ConnectorGui gui;
	public static Connection connection;
	public static boolean connected = false;
	public static Statement stmt;
	public static JTable table = new JTable();
	static JList<String> tableList = new JList<>();
	Connector(ConnectorGui gui){
		super();
		this.gui = gui;
	}

	public static boolean connect(String account, String pass) throws ClassNotFoundException, SQLException {
		// Load the MariaDB DB_folder.Connector/J driver
		try{
			if(!connected){
				String driver = "org.mariadb.jdbc.Driver";
				String url = "jdbc:mariadb://0.tcp.jp.ngrok.io:12592/" + account ;
				Class.forName(driver);
				// Establish the connection
				connection = DriverManager.getConnection(url, account, pass);
				gui.textArea_1.append("Success: Connected to the database!\n");
				System.out.println("Success: Connected to the database!");
				stmt = connection.createStatement();
				connected = true;
				ArrayList<String> tableNames = getTableNames();
				DefaultListModel<String> listmodel = new DefaultListModel<>();
				for(String tableName : tableNames){
					listmodel.addElement(tableName);
				}
				tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableList.addListSelectionListener(e -> {
					if(!e.getValueIsAdjusting()){
						String selectedTable = tableList.getSelectedValue();
						if(selectedTable != null){
                            try {
                                show_table(selectedTable);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
					}
				});
				tableList.setModel(listmodel);
				return true;
			}
			else{
				gui.textArea_1.append("Error: Connection has exited!\n");
				System.out.println("Error: Connection has exited!");
				return false;
			}

		}
		catch(ClassNotFoundException e) {
			gui.textArea_1.append("Error: MariaDB JDBC driver not found!\n");
			System.err.println("Error: MariaDB JDBC driver not found!");
		}
		catch (SQLException e) {
			gui.textArea_1.append("Error: Connection failed!\n");
			System.err.println("Error: Connection failed!");
		}
		return false;
	}

	private static ArrayList<String> getTableNames() throws SQLException {
		ArrayList<String> tableNames = new ArrayList<>();
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
		while(tables.next()){
			String tableName = tables.getString("TABLE_NAME");
			tableNames.add(tableName);
		}
		tables.close();
		return tableNames;
	}

	public static void disconnect() throws SQLException {
		try{
			if(connected) {
				connection.close();
				System.out.println("Success: Disconnected from the database!");
				gui.textArea_1.append("Success: Disconnected from the database!\n");
				connected = false;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
			else{
				gui.textArea_1.append("Error: Please connect to database first!\n");
				System.err.println("Error: Please connect to database first!");
			}
		}
		catch(SQLException e) {
			gui.textArea_1.append("Error: Disconnect failed\n");
			System.err.println("Error: Disconnect failed!");
		}
	}

	public static void show_table(String tableName) throws SQLException{
		String sql = "SELECT * FROM " + tableName;
		gui.textArea_1.append("Current Table: " + tableName + "\n");
		query(sql);
	}

	public static void query(String sql) throws SQLException {
		try (ResultSet resultSet = stmt.executeQuery(sql)) {
			ResultSetTableModel model = new ResultSetTableModel(resultSet);
			table.setModel(model);


		} catch (SQLException e) {
			e.printStackTrace();
			gui.textArea_1.append("Error: Query failed\n");
		}
	}
	public static void showTable() throws SQLException{   		 /*顯示當前所有table*/
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
		while (tables.next()) {
			String tableName = tables.getString("TABLE_NAME");
			gui.textArea_1.append(tableName + "\n");
		}
	}
	public static void query1() throws SQLException {
		gui.textArea_1.setText("Suppose that it is found that transmissions made by supplier Getrag between two given dates are defective.\n"  +
				               "Find the VIN of each car containing such a transmission and the customer to which it was sold.\n" +
							   "If your design allows, suppose the defective transmissions all come from only one of Getrag’s plants\n");
		String sql = "SELECT DISTINCT c.customer_ID, v.VIN, c.customer_name " +
				"FROM Customer c "+
				"JOIN Sales s ON s.customer_ID=c.customer_ID " +
				"JOIN Inventory i ON s.inventory_ID = i.inventory_ID " +
				"JOIN Vehicle v ON v.VIN = i.VIN " +
				"JOIN VehiclePart vp ON v.VIN = vp.VIN " +
				"JOIN Production p ON vp.production_ID = p.production_ID " +
				"JOIN Supplier sp ON sp.supplier_ID = p.supplier_ID " +
				"WHERE sp.supplier_name = 'Getrag' " +
				"AND p.manufacture_date BETWEEN '2023-08-01' AND '2023-08-15' " +
				"ORDER BY c.customer_ID ";

		query(sql);
	}
	public static void query2() throws SQLException {
		gui.textArea_1.setText("Find the dealer who has sold the most (by dollar-amount) in the past year.\n");
		String sql = 	"SELECT d.dealer_ID, d.dealer_name, SUM(s.amounts) AS total_sales " +
						"FROM Sales s " +
						"JOIN Inventory i ON s.inventory_ID = i.inventory_ID " +
						"JOIN Dealer d ON i.dealer_ID = d.dealer_ID " +
						"WHERE s.purchase_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) " +
						"GROUP BY d.dealer_ID, d.dealer_name " +
						"ORDER BY total_sales DESC " +
						"LIMIT 1;";
		query(sql);
	}

	public static void query3() throws SQLException {
		gui.textArea_1.setText("Find the top 2 brands by unit sales in the past year.\n");
		String sql = 	"SELECT b.brand_ID, b.brand_name, COUNT(*) AS unit_sales " +
						"FROM Sales s " +
						"JOIN Inventory i ON s.inventory_ID = i.inventory_ID " +
						"JOIN Vehicle v ON i.VIN = v.VIN " +
						"JOIN Model m ON v.model_ID = m.model_ID " +
						"JOIN Brand b ON m.brand_ID = b.brand_ID " +
						"WHERE s.purchase_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) " +
						"GROUP BY b.brand_ID, b.brand_name " +
						"ORDER BY unit_sales DESC " +
						"LIMIT 2;";
		query(sql);
	}
	public static void query4() throws SQLException {
		gui.textArea_1.setText("In what month(s) do SUVs sell best?\n");
		String sql = 	"SELECT " +
						"MONTH(Sales.purchase_date) AS sale_month, " +
						"COUNT(*) AS suv_sales_count " +
						"FROM Sales " +
						"JOIN Inventory ON Sales.inventory_ID = Inventory.inventory_ID " +
						"JOIN Vehicle ON Inventory.VIN = Vehicle.VIN " +
						"JOIN Model ON Vehicle.model_ID = Model.model_ID " +
						"WHERE Model.type = 'SUV' " +
						"GROUP BY sale_month " +
						"ORDER BY suv_sales_count DESC";
		query(sql);
	}
	public static void query5() throws SQLException {
		gui.textArea_1.setText("Find those dealers who keep a vehicle in inventory for the longest average time.\n");
		String sql = 	"SELECT d.dealer_ID, d.dealer_name, \n" +
						"AVG(DATEDIFF(IFNULL(s.purchase_date, CURDATE()), i.order_date)) AS avg_days_in_inventory\n" +
						"FROM Dealer d\n" +
						"JOIN Inventory i ON d.dealer_ID = i.dealer_ID\n" +
						"LEFT JOIN Sales s ON i.inventory_ID = s.inventory_ID\n" +
						"GROUP BY d.dealer_ID, d.dealer_name\n" +
						"ORDER BY avg_days_in_inventory DESC\n" +
						"LIMIT 1;";
		query(sql);
	}

}
