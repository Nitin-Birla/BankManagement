package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login(){
		
		setLayout(null);
		setTitle("AUTOMATED TELLER MACHINE");
		ImageIcon i1 = new ImageIcon(getClass().getResource("logo.jpg"));
		Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
				
				
		setVisible(true);
		setSize(800,480);
		setLocation(350,200);
		setResizable(false);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200,40,400,40);
		text.setFont(new Font("Osward", Font.BOLD,38));
		add(text);
		
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway", Font.BOLD,28)); 
		cardno.setBounds(120,150,400,30);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		cardTextField.setBounds(300,150,230,30);
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(pinTextField);
		
		
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setForeground(Color.WHITE);
		signup.setBackground(Color.BLACK);
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(Color.WHITE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} 
		else if(e.getSource()==login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "Select * from login where cardnumber = '"+cardnumber+"' and  pinnumber = '" +pinnumber+"'" ;
			
			
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect card number or Pin");
				}
			}catch(Exception ae) {
				System.out.print(ae);
			}	
		} 
		else if(e.getSource()==signup) {
			setVisible(false);
			new Signup1().setVisible(true);
		}
		
	}
	
	
    public static void main(String[] args) {
    	new Login();
    }




	
}
