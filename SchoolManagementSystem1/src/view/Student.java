package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField courseNameTextField;
	private JButton gobtn;
	private JTextField studentNametextField;
	private JLabel stdnNamelblNewLabel;
	private JLabel courseNamelblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 20, 20));
		
		JLabel instructionLabel = new JLabel("Enter the course name that's grade you want to check-");
		instructionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(instructionLabel);
		
		stdnNamelblNewLabel = new JLabel("Student Name:");
		contentPane.add(stdnNamelblNewLabel);
		
		studentNametextField = new JTextField();
		contentPane.add(studentNametextField);
		studentNametextField.setColumns(10);
		
		courseNamelblNewLabel = new JLabel("Course Name:");
		contentPane.add(courseNamelblNewLabel);
		
		courseNameTextField = new JTextField();
		contentPane.add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		gobtn = new JButton("Go");
		gobtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(gobtn);
	
	    gobtn.addActionListener(new ActionListener() {
		//project- right click-build path-add external archieves- mysqlconnector jar
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String courseName = courseNameTextField.getText();
						String studentName = studentNametextField.getText();
						try{  
							Class.forName("com.mysql.jdbc.Driver");  
							Connection con=(Connection) DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/schoolmanagementsystem","root","");  
							//here sonoo is database name, root is username and password  
							Statement stmt=(Statement) con.createStatement();  
							
							ResultSet rs=(ResultSet) stmt.executeQuery("select * from courses where student_name='"+studentName+"'");  
							if(rs.next())
							{
								String c_n = rs.getString(2);
								int g = rs.getInt(1);
								//String s_n = rs.getString(3);
								
								if(courseName.equals(c_n))
								{
										JOptionPane.showMessageDialog(null, "The grade you got in "+c_n+" is "+g);
									
								}
								else {JOptionPane.showMessageDialog(null, "Course name does not match.");}
							}
							else {JOptionPane.showMessageDialog(null, "Student name does not match.");}
							con.close();  
							}
						catch(Exception ea){ System.out.println(ea);}  
							}  
					}
					
				
				);}
				

}
