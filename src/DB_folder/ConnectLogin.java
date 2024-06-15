package DB_folder;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ConnectLogin {

    private JFrame frame;
    private JTextField accountField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ConnectLogin window = new ConnectLogin();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public ConnectLogin() {
	initialize();
	frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("連線登入");
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("帳號：");
	lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
	lblNewLabel.setBounds(38, 30, 96, 45);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("密碼：");
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 24));
	lblNewLabel_1.setBounds(38, 89, 96, 45);
	frame.getContentPane().add(lblNewLabel_1);
	
	accountField = new JTextField();
	accountField.setBounds(119, 30, 288, 40);
	frame.getContentPane().add(accountField);
	accountField.setColumns(10);
	
	JButton btnNewButton = new JButton("連線");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
            try {
				String account = accountField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if(Connector.connect(account, password)){
					JOptionPane.showMessageDialog(null, "Login Successfully","Login", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Login fail","Login", JOptionPane.ERROR_MESSAGE);
					accountField.setText("");
					passwordField.setText("");
				}
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
	});
	btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 24));
	btnNewButton.setBounds(250, 159, 136, 69);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("返回");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 24));
	btnNewButton_1.setBounds(50, 159, 136, 69);
	frame.getContentPane().add(btnNewButton_1);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(119, 87, 288, 40);
	frame.getContentPane().add(passwordField);
    }
}
