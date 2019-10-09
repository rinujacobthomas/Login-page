package first;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main {
public static void main(String [] args) throws SQLException, ClassNotFoundException
{
/*	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");  
	
	if (con != null)
	{
		System.out.println("Connected");
	}
	else
	{
		System.out.println("not Connected");
	}
*/	A a = new A();
}
}
class A extends JFrame implements ActionListener
{

	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	String email,password;
	JCheckBox c1;
	A()
	{
	
	setVisible(true);
	setLayout(null);
	setSize(550, 550);
	getContentPane().setBackground(Color.cyan);;
	setDefaultCloseOperation(3);
	l4 = new JLabel();
	l4.setBounds(180, 170, 200, 10);
	add(l4);
	l3 = new JLabel("Show password");
	l3.setBounds(390,130, 100, 20);
	add(l3);
	
	l5 = new JLabel("New User ?");
	l5.setBounds(110,255, 100, 20);
	add(l5);
	l1 = new JLabel("Email");
	l1.setBounds(150, 35, 100, 10);
	l1.setForeground(Color.BLACK);
	add(l1);
	l2 = new JLabel("Password");
	l2.setBounds(150, 105, 100, 20);
	add(l2);
	 t1 = new JTextField();
	 t1.setBounds(150, 60, 200, 30);
		t1.setForeground(Color.BLACK);
	 add(t1);
	 p1 = new JPasswordField();
	 p1.setBounds(150, 130, 200, 30);
		p1.setForeground(Color.BLACK);
		add(p1);
		b1 = new JButton();
		 b1.setBounds(200, 200, 100, 30);
		 add(b1);
		 b1.setText("Log In");
		 b1.setBackground(Color.LIGHT_GRAY);
		 b1.addActionListener(this);
		 b2 = new JButton();
		 b2.setBounds(200, 250, 100, 30);
		 add(b2);
		 b2.setText("Sign Up");
		 b2.setBackground(Color.LIGHT_GRAY);
		 b2.addActionListener(this);
		 c1 = new JCheckBox();
		 c1.setBounds(370, 130, 20, 20);
		 add(c1);
		 c1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(c1.isSelected())
				{
					p1.setEchoChar((char)0);
				}
				else
				{
					p1.setEchoChar('*');
			
				}
				
			}
		});
	}

	public void actionPerformed(ActionEvent a1) {
		if(a1.getSource()==b1)
		{
			
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
					email = t1.getText();
					password = String.valueOf(p1.getPassword());
					int count=0;
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select email,password1 from a");
					while(rs.next())
					{
						if(rs.getString(1).equals(email)&&rs.getString(2).equals(password))
						{
							//System.out.println("Login Success");
							l4.setForeground(Color.GREEN);
							l4.setText("Login Success");
							count++;
							break;
						}
						
							
					}
					if(count==0)
					{
						//System.out.println("Invalid Email or Password");
						l4.setForeground(Color.RED);
						l4.setText("Invalid Email or Password");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			
			
		}
		else if(a1.getSource()==b2)
		{
			dispose();
			B b = new B();
		}
		
	}
}
class B extends JFrame implements ActionListener
{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5;
	JPasswordField p1;
	JButton b1,b2;
	String firstName,lastName,address,email,phone,password;
	B()
	{
		setVisible(true);
		setLayout(null);
		setSize(500, 500);
		getContentPane().setBackground(Color.cyan);;
		setDefaultCloseOperation(3);
		l1 = new JLabel("First Name");
		l1.setBounds(30, 30, 100, 20);
		l1.setForeground(Color.BLACK);
		add(l1);
		l2 = new JLabel("Last Name");
		l2.setBounds(30, 70, 100, 20);
		add(l2);
		l2.setForeground(Color.BLACK);
		l3 = new JLabel("Address");
		l3.setBounds(30, 110, 100, 20);
		add(l3);
		l3.setForeground(Color.BLACK);
		l4 = new JLabel("Phone Number");
		l4.setBounds(30, 150, 100, 20);
		add(l4);
		l4.setForeground(Color.BLACK);
		l5 = new JLabel("Email");
		l5.setBounds(30, 190, 100, 20);
		add(l5);
		l5.setForeground(Color.BLACK);
		l6 = new JLabel("Password");
		l6.setBounds(30, 230, 100, 20);
		l6.setForeground(Color.BLACK);
		add(l6);
		l7 = new JLabel("Existing User ?");
		l7.setBounds(130, 350, 100, 30);
		add(l7);
		
	 t1 = new JTextField();
	 t1.setBounds(200, 30, 200, 30);
	 add(t1);
	 t2 = new JTextField();
	 t2.setBounds(200, 70, 200, 30);
	 add(t2);
	 t3 = new JTextField();
	 t3.setBounds(200, 110, 200, 30);
	 add(t3);
	 t4 = new JTextField();
	 t4.setBounds(200, 150, 200, 30);
	 add(t4);
	 t5 = new JTextField();
	 t5.setBounds(200, 190, 200, 30);
	 add(t5);
	 p1 = new JPasswordField();
		p1.setBounds(200, 230, 200, 30);
		add(p1);
	 b1 = new JButton();
	 b1.setBounds(220, 300, 100, 30);
	 add(b1);
	 b1.setText("REGISTER");
	 b1.setBackground(Color.LIGHT_GRAY);
	 b1.addActionListener(this);
	 b2 = new JButton();
	 b2.setBounds(220, 350, 100, 30);
	 add(b2);
	 b2.setText("Log In");
	 b2.setBackground(Color.LIGHT_GRAY);
	 b2.addActionListener(this);
	 //l3 = new JLabel("Result");
	// l3.setBounds(170, 130, 300, 20);
	// add(l3);
	 //b2 = new JButton();
	// b2.setBounds(200, 70, 70, 40);
	// add(b2);
	// b2.setText("SUB");
	// b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
		firstName=t1.getText();
		lastName =t2.getText();
		address= t3.getText();
		phone=t4.getText();
		email = t5.getText();
		password = String.valueOf(p1.getPassword());
	 
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
			Statement stn = con.createStatement();
			stn.execute("insert into a values('"+firstName+"','"+lastName+"','"+address+"','"+phone+"','"+email+"','"+password+"')");
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		dispose();
		
		A a2 = new A();
	}
		else
		{
			dispose();
			A a2 = new A();
		}
		}
	}

