package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.JButton;
import java.awt.Color;

public class Teacher extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField marksTextField;
	private JTextField courseNameTextField;
	private JLabel marksLabel;
	private JLabel studentNameLabel;
	private JTextField studentNametextField;
	private JButton savebtnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
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
	public Teacher() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Contacts\\Downloads\\SchemeSystem_files\\sproslogo\\spros project logo.PNG"));
		setTitle("Enter course grade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));
		
		studentNameLabel = new JLabel("Student name");
		contentPane.add(studentNameLabel);
		
		studentNametextField = new JTextField();
		contentPane.add(studentNametextField);
		studentNametextField.setColumns(10);
		
		JLabel CourseNameLabel = new JLabel("Course name:");
		contentPane.add(CourseNameLabel);
		
		courseNameTextField = new JTextField();
		contentPane.add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		marksLabel = new JLabel("Grade:");
		contentPane.add(marksLabel);
		
		marksTextField = new JTextField();
		contentPane.add(marksTextField);
		marksTextField.setColumns(10);
		
		savebtnNewButton = new JButton("Save");
		savebtnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		savebtnNewButton.setBackground(new Color(102, 205, 170));
		contentPane.add(savebtnNewButton);
		
		savebtnNewButton.addActionListener(new ActionListener() {
			//project- right click-build path-add external archieves- mysqlconnector jar
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String stnname = studentNametextField.getText();
							int marks = Integer.parseInt(marksTextField.getText());
							String courseName = courseNameTextField.getText();
							
							try{  
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagementsystem","root","");  
								//here sonoo is database name, root is username and password  
								PreparedStatement ps =(PreparedStatement) con.prepareStatement("INSERT INTO courses (grade, course_name, student_name) VALUES (?, ?, ?)");
								 
								ps.setInt(1, marks); 
								ps.setString(2, courseName); 
								ps.setString(3, stnname); 
								
								ps.execute();
								JOptionPane.showMessageDialog(null, "Grade published.");
							  }
							catch(Exception eo) {
								System.out.println(eo);
							}
							
							}
						}
						
					
					);
	}

}
