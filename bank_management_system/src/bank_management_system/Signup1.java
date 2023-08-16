package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener{
	long random;
	JTextField nameTextField ,fnameTextField ,emailTextField, addressTextField,cityTextField,stateTextField ,pincodeTextField;
	JButton next;
	JRadioButton male, female, other, others,married,unmarried;
	JDateChooser date;
	
	Signup1(){
		
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L)+1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD,22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField  = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD,20));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname );
		
		fnameTextField= new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD,20));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob); 
			
		date  = new JDateChooser();
		date.setBounds(300,240,400,30);
		date.setForeground(new Color(105,105,105));
		add(date);
		 
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,290,80,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		others = new JRadioButton("Other");
		others.setBounds(630,290,100,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(others);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway", Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD,20));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		JLabel marital = new JLabel("Marital:");
		marital.setFont(new Font("Raleway", Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD,20));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField= new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD,20));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		
		JLabel pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway", Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD,14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		JButton next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620,660,80,30);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.addActionListener(this);
		add(next); 
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		
		setLocation(350,10);
		setVisible(true);
	}
	
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = "" + random; // converting into string 
		String fname = fnameTextField.getText();
		String name = nameTextField.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String gender =null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "female";
		}
		else if(others.isSelected()) {
			gender = "others";
		}
		
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "married";
		}
		else if(unmarried.isSelected()) {
			marital = "unmarried";
		}
		else if(other.isSelected()) {
			marital = "other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
				
			}else {
				try {
				//Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmng","root","9171445717");
				//Statement stmt = con.createStatement();
					Conn c = new Conn();
				String query = "insert into mngA values('"+formno+"', '"+name+"', '"+fname+"','"+dob+"', '"+gender+"', '"+email+"',  '"+marital+"', '"+address+"', '"+city+"' , '"+state+"','"+pincode+"' )";
			    c.s.executeUpdate(query); 
				}
				catch (Exception ae) {
					System.out.println(ae);
				}
			           
			    setVisible(false);
	    new Signup2(formno).setVisible(true);
			    }
		} catch (Exception ee) {
			System.out.println(ee);
		} 
		
	}
	
	 public static void main(String[] args){
    	 new Signup1();
     }
	
}
