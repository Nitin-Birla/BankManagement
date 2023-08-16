package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JButton change, back;
	JPasswordField repin, pin;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(getClass().getResource("atm.jpg"));
		Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN");
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
    	pin = new JPasswordField();
    	pin.setFont(new Font("Raleway", Font.BOLD,25));
    	pin.setBounds(330,320,180,25);
    	image.add(pin);
		
		JLabel repintext = new JLabel("RE-Enter New PIN");
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		repintext.setForeground(Color.WHITE);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setResizable(false);
		setUndecorated(true);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== change) {
			
		try{
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null,"Entered PIN does not match");
				return;
			}
			
			if(npin.equals("")){
				JOptionPane.showMessageDialog(null,"Please enter new pin");
				return;
			
		}
			
			if(rpin.equals("")){
				JOptionPane.showMessageDialog(null,"Please re-enter new pin");
				return;
			
		}
			Conn conn = new Conn();
			String query1 = "update bankD set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
			String query3 = "update mngC set pinnumber  = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed succuessfully");
			
			setVisible(false);
			new Transaction(rpin).setVisible(true);
			
		}catch(Exception ae){
			System.out.println(ae);
			
		 }
	}
		else {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
		
}

