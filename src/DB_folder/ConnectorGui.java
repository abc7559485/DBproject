package DB_folder;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectorGui {
	static JFrame frame;
	static JTextArea textArea_1;
	static JTextArea textArea;
	//static DefaultTableModel model;
	static JScrollPane scrollPane_1;
	static JScrollPane scrollPane_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectorGui window = new ConnectorGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectorGui() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setTitle("資料庫");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setText("請輸入查詢");
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textArea.setText("");
			}
		});
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(false);
//		textArea.setBounds(10, 529, 653, 22);
//		frame.getContentPane().add(textArea);
		textArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					try{
						if(Connector.connected){
							String sql = textArea.getText();
							System.out.println(sql);
							textArea_1.setText("");
							DBThread t = new DBThread(sql, true);
							t.start();
							textArea.setText("");
						}
						else{
							textArea_1.append("Please connect first\n");
							textArea.setText("");
						}

					}
					catch(Exception s){
						s.printStackTrace();
						textArea_1.append("查詢失敗，請檢查輸入語句是否正確\n");
					}
				}
			}
		});
		JScrollPane scrollPane2 = new JScrollPane(textArea);
		scrollPane2.setBounds(10, 513, 653, 43);
		frame.getContentPane().add(scrollPane2);

		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(Connector.connected){
						String sql = textArea.getText();
						System.out.println(sql);
						textArea_1.setText("");
						DBThread t = new DBThread(sql, true);
						t.start();
						textArea.setText("");
					}
					else{
						textArea_1.append("Please connect first\n");
						textArea.setText("");
					}

				}
				catch(Exception s){
					s.printStackTrace();
					textArea_1.append("查詢失敗，請檢查輸入語句是否正確\n");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton.setBounds(673, 528, 101, 23);
		frame.getContentPane().add(btnNewButton);

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 112, 653, 403);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane(textArea_1);
		scrollPane.setBounds(10, 450, 653, 53);

		frame.getContentPane().add(scrollPane);

		scrollPane_1 = new JScrollPane(Connector.table);
		scrollPane_1.setBounds(10, 112, 653, 330);
		frame.getContentPane().add(scrollPane_1);



		JButton btnNewButton_1 = new JButton("查詢一");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Connector.connected){
                    try {
                        Connector.query1();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
				else{
					textArea_1.append("Please connect first\n");
				}

			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton_1.setBounds(673, 112, 101, 38);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("查詢二");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Connector.connected){
                    try {
                        Connector.query2();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
				else{
					textArea_1.append("Please connect first\n");
				}

			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(673, 160, 101, 38);
		frame.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("查詢三");
		btnNewButton_1_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Connector.connected){
                    try {
                        Connector.query3();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
				else{
					textArea_1.append("Please connect first\n");
				}
			}
		});
		btnNewButton_1_2.setBounds(673, 208, 101, 38);
		frame.getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("查詢四");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Connector.connected){
                    try {
                        Connector.query4();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
				else{
					textArea_1.append("Please connect first\n");
				}
			}
		});
		btnNewButton_1_3.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton_1_3.setBounds(673, 256, 101, 38);
		frame.getContentPane().add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("查詢五");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Connector.connected){
                    try {
                        Connector.query5();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
				else{
					textArea_1.append("Please connect first\n");
				}
			}
		});
		btnNewButton_1_4.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton_1_4.setBounds(673, 304, 101, 38);
		frame.getContentPane().add(btnNewButton_1_4);

		JButton btnNewButton_2 = new JButton("連線");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DBThread t = new DBThread("", false);
                t.start();
            }
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 24));
		btnNewButton_2.setBounds(10, 10, 106, 92);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("離線");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
					textArea_1.setText("");
                    Connector.disconnect();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
		});
		btnNewButton_2_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		btnNewButton_2_1.setBounds(668, 10, 106, 92);
		frame.getContentPane().add(btnNewButton_2_1);

		JLabel lblNewLabel_1 = new JLabel("資料庫查詢系統");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(264, 26, 231, 57);
		frame.getContentPane().add(lblNewLabel_1);

		scrollPane_2 = new JScrollPane(Connector.tableList);
		scrollPane_2.setBounds(673, 355, 101, 148);
		frame.getContentPane().add(scrollPane_2);

		JLabel text = new JLabel("當前Tables");
		text.setFont(new Font("新細明體", Font.PLAIN, 14));
		text.setBounds(673, 503, 101, 24);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(text);
	}


}

