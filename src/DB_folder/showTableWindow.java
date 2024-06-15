package DB_folder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.sql.SQLException;

public class showTableWindow  {

    private JFrame showTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    showTableWindow window = new showTableWindow();
                    window.showTable.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */

    public showTableWindow() {
        initialize();
        showTable.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        showTable = new JFrame();
        showTable.setTitle("Show Table");
        showTable.setBounds(100, 100, 400, 178);
        showTable.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        showTable.getContentPane().setLayout(null);
        showTable.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 364, 92);
        showTable.getContentPane().add(panel);

        JButton btnNewButton = new JButton("Customer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnNewButton.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnNewButton);

        JButton btnBrand = new JButton("Brand");
        btnBrand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnBrand.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnBrand.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnBrand);

        JButton btnModel = new JButton("Model");
        btnModel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnModel.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnModel.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnModel);

        JButton btnVehicle = new JButton("Vehicle");
        btnVehicle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnVehicle.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnVehicle.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnVehicle);

        JButton btnManufacturer = new JButton("Manufacturer");
        btnManufacturer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnManufacturer.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnManufacturer.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnManufacturer);

        JButton btnDealer = new JButton("Dealer");
        btnDealer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnDealer.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnDealer.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnDealer);

        JButton btnSupplier = new JButton("Supplier");
        btnSupplier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnSupplier.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnSupplier.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnSupplier);

        JButton btnPart = new JButton("Part");
        btnPart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.gui.textArea_1.setText("");
                    Connector.show_table(btnPart.getText());
                    showTable.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnPart.setFont(new Font("新細明體", Font.PLAIN, 14));
        panel.add(btnPart);

        JButton btnNewButton_1 = new JButton("Return");
        btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 14));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTable.setVisible(false);
            }
        });
        btnNewButton_1.setBounds(149, 106, 87, 23);
        showTable.getContentPane().add(btnNewButton_1);
    }
}