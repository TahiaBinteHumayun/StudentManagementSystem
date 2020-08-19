package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField NametextField;
	private JTextField IDTextfield;
	private JTextField emailtextField;
	private JTextField passTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Contacts\\Downloads\\SchemeSystem_files\\sproslogo\\spros project logo.PNG"));
		setTitle("Register in our system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel nameLabel = new JLabel("First Name:");
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(nameLabel);
		
		NametextField = new JTextField();
		contentPane.add(NametextField);
		NametextField.setColumns(10);
		
		JLabel IDLabel = new JLabel("ID:");
		IDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(IDLabel);
		
		IDTextfield = new JTextField();
		contentPane.add(IDTextfield);
		IDTextfield.setColumns(10);
		
		JLabel RegEmailLabel = new JLabel("Your Email:");
		RegEmailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(RegEmailLabel);
		
		emailtextField = new JTextField();
		contentPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel RegpasswordLabel = new JLabel("Password:");
		RegpasswordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(RegpasswordLabel);		
		
		passTextField = new JPasswordField();
		contentPane.add(passTextField);
		passTextField.setColumns(15);
		
		JRadioButton MaleRadioButton = new JRadioButton("Male");
		contentPane.add(MaleRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1);
		
		JRadioButton FemaleRBtn = new JRadioButton("Female");
		contentPane.add(FemaleRBtn);
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3);
		
		JRadioButton OtherRBtn = new JRadioButton("Other");
		contentPane.add(OtherRBtn);
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		
		JButton SignInButton = new JButton("Sign In");
		contentPane.add(SignInButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2);
		
		SignInButton.addActionListener(new ActionListener() {
			//project- right click-build path-add external archieves- mysqlconnector jar
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String name = NametextField.getText();
							String id = IDTextfield.getText();
							String email = emailtextField.getText();
							String pass = passTextField.getText();
							try{  
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con=(Connection) DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/schoolmanagementsystem","root","");  
								//here sonoo is database name, root is username and password  
								java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, name, email, password) VALUES (?, ?, ?, ?)");
								 
								ps.setString(1, id); 
								ps.setString(2, name); 
								ps.setString(3, email); 
								ps.setString(4, pass); 
								ps.execute();
								JOptionPane.showMessageDialog(null, "Registration successful.");
							  }
							catch(Exception eo) {
								System.out.println(eo);
							}
							
							}
						}
						
					
					);
	}

}
