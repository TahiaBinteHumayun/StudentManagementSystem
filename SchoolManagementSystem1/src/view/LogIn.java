package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField emailtextField;
	private JTextField passTextF;
	private JLabel lblNewLabel;
	private JButton loginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log In into our system");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Contacts\\Downloads\\SchemeSystem_files\\sproslogo\\spros project logo.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel emailLabel = new JLabel("Your Email:");
		emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(emailLabel);
		
		emailtextField = new JTextField();
		emailtextField.setToolTipText("Enter your Email address here...");
		contentPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(passLabel);
		
		passTextF = new JTextField();
		passTextF.setToolTipText("Enter your Password here...");
		contentPane.add(passTextF);
		passTextF.setColumns(10);
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		
		loginButton = new JButton("Log In");
		loginButton.setBackground(new Color(204, 204, 255));
		loginButton.setVerticalAlignment(SwingConstants.CENTER);
		loginButton.setEnabled(true);
		loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		contentPane.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {
//project- right click-build path-add external archieves- mysqlconnector jar
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String email = emailtextField.getText();
				String pass = passTextF.getText();
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/schoolmanagementsystem","root","");  
					//here sonoo is database name, root is username and password  
					Statement stmt=(Statement) con.createStatement();  
					ResultSet rs=(ResultSet) stmt.executeQuery("select * from users where email='"+email+"'");  
					if(rs.next())
					{
						String dbpw = rs.getString(4);
						if(pass.equals(dbpw))
						{
							JOptionPane.showMessageDialog(null, "Login successful.");
						}
						else {JOptionPane.showMessageDialog(null, "Password does not match.");}
					}
					else {JOptionPane.showMessageDialog(null, "Email does not match.");}
					con.close();  
					}
				catch(Exception ea){ System.out.println(ea);}  
					}  
			}
			
		
		);}

	}
	
	
