package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Group extends JFrame {

	private JPanel contentPane;
	private JTextField yesAdmin;
	private JTextField yesTeacher;
	private JTextField yesStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Group frame = new Group();
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
	public Group() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Contacts\\Downloads\\SchemeSystem_files\\sproslogo\\spros project logo.PNG"));
		setTitle("Your Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 20, 20));
		JLabel statusLabel = new JLabel("write yes if the statement is true");
		statusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		contentPane.add(statusLabel);
		JLabel isAdminLabel = new JLabel("Are you Admin?");
		isAdminLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contentPane.add(isAdminLabel);
		yesAdmin = new JTextField();
		yesAdmin.setToolTipText("write yes if true");
		contentPane.add(yesAdmin);
		yesAdmin.setColumns(10);
		JLabel isTeacherLabel = new JLabel("Are you a Teacher?");
		isTeacherLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contentPane.add(isTeacherLabel);
		
		yesTeacher = new JTextField();
		yesTeacher.setToolTipText("write yes if true");
		contentPane.add(yesTeacher);
		yesTeacher.setColumns(10);
		JLabel isStudentLabel = new JLabel("Are you a Student?");
		isStudentLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contentPane.add(isStudentLabel);
		yesStudent = new JTextField();
		yesStudent.setToolTipText("write yes if true");
		contentPane.add(yesStudent);
		yesStudent.setColumns(10);
		
		
	}

}
