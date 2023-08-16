package bank_management_system;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {
	
	JTextField pan,aadhar;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion, category, education, occupation,incomecategory;
	String formno;
	
	
	Signup2(String formno){
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
	JLabel additionalDetails = new JLabel("Page 2: Additional Details " );
	additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
	additionalDetails.setBounds(290,80,400,30);
	add(additionalDetails);
	
	JLabel reli = new JLabel("Religion:");
	reli.setFont(new Font("Raleway", Font.BOLD,22));
	reli.setBounds(100,140,100,30);
	add(reli);
	
	String valReligion[] = {"Hindu", "Muslim", "Sikh","Cristian","Others"};
	religion = new JComboBox(valReligion);
	religion.setBounds(300,140,400,30);;
	religion.setBackground(Color.WHITE);
	add(religion);
	

	JLabel cat = new JLabel("Category:");
	cat.setFont(new Font("Raleway", Font.BOLD,20));
	cat.setBounds(100,190,200,30);
	add(cat);
	
	String valcategory[] = {"General","OBC", "SC","ST", "others"};
	category = new JComboBox(valcategory);
	category.setBounds(300,190,400,30);
	category.setBackground(Color.WHITE);
	add(category);
	
	JLabel income = new JLabel("Income:");
	income.setFont(new Font("Raleway", Font.BOLD,20));
	income.setBounds(100,240,200,30);
	add(income);
	
	String incomecatagory[] = {"Null","<1,50,000", "<2,50,000","<5,00,000", "Upto 10,00,000"};
    incomecategory = new JComboBox(incomecatagory);
	incomecategory.setBounds(300,240,400,30);
	incomecategory.setBackground(Color.WHITE);
	add(incomecategory);
	
	
	
	
	JLabel edu = new JLabel("Educational:");
	edu.setFont(new Font("Raleway", Font.BOLD,20));
	edu.setBounds(100,290,200,30);
	add(edu);
		
	JLabel qua = new JLabel("Qualification:");
	qua.setFont(new Font("Raleway", Font.BOLD,20));
	qua.setBounds(100,315,200,30);
	add(qua);
	
	String educationValues[] = {"Non-Graduation","Graduate","Post-Graduate","Doctorate","Others"};
	
	education = new JComboBox(educationValues);
	education.setBounds(300,315,400,30);
	education.setBackground(Color.WHITE);
	add(education);
	
	

	
	
	JLabel occu = new JLabel("Occupation:");
	occu.setFont(new Font("Raleway", Font.BOLD,20));
	occu.setBounds(100,390,200,30);
	add(occu);
	
	String occupationValues[] = {"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
	occupation = new JComboBox(occupationValues);
	occupation.setBounds(300,390,400,30);
	occupation.setBackground(Color.WHITE);
	add(occupation);
	
	
	JLabel panno = new JLabel("PAN Number:");
	panno.setFont(new Font("Raleway", Font.BOLD,20));
	panno.setBounds(100,440,200,30);
	add(panno);
	
	pan = new JTextField();
	pan.setFont(new Font("Raleway", Font.BOLD,20));
	pan.setBounds(300,440,400,30);
	add(pan);
	
	
	
	JLabel aad = new JLabel("Aadhar Number:");
	aad.setFont(new Font("Raleway", Font.BOLD,20));
	aad.setBounds(100,490,200,30);
	add(aad);
	
	aadhar= new JTextField();
	aadhar.setFont(new Font("Raleway", Font.BOLD,20));
	aadhar.setBounds(300,490,400,30);
	add(aadhar);
	
	
	JLabel seniorcit = new JLabel("Senior Citizen:");
	seniorcit.setFont(new Font("Raleway", Font.BOLD,20));
	seniorcit.setBounds(100,540,200,30);
	add(seniorcit);
	
	syes = new JRadioButton("YES");
	syes.setBounds(300,540,100,30);
	syes.setBackground(Color.WHITE);
	add(syes);
	
	sno = new JRadioButton("NO");
	sno.setBounds(450,540,100,30);
	sno.setBackground(Color.WHITE);
	add(sno);
	

	ButtonGroup seniorgroup = new ButtonGroup();
	seniorgroup.add(syes);
	seniorgroup.add(sno);
	
	
	
	
	JLabel existingacc = new JLabel("Existing Account:");
	existingacc.setFont(new Font("Raleway", Font.BOLD,20));
	existingacc.setBounds(100,590,200,30);
	add(existingacc);
	
	eyes = new JRadioButton("YES");
	eyes.setBounds(300,590,100,30);
	eyes.setBackground(Color.WHITE);
	add(eyes);
	
	eno = new JRadioButton("NO");
	eno.setBounds(450,590,100,30);
	eno.setBackground(Color.WHITE);
	add(eno);
	

	ButtonGroup existinggroup = new ButtonGroup();
	existinggroup.add(eyes);
	existinggroup.add(eno);
	

	
	JButton next = new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setBounds(620,660,80,30);
	next.setFont(new Font("Raleway",Font.BOLD,14));
	next.addActionListener(this);
	add(next); 
	
	getContentPane().setBackground(Color.WHITE);
	setSize(850,800);
	setLayout(null);
	setLocation(350,10);
	setVisible(true);
}

	
 
@Override
public void actionPerformed(ActionEvent e) {
	
	String sreligion= (String) religion.getSelectedItem();
	String scategory= (String) category.getSelectedItem();
	String sincome = (String) incomecategory.getSelectedItem();
	String seducation = (String) education.getSelectedItem();
	String soccupation = (String) occupation.getSelectedItem();
	String seniorcitizen = null;
	if(syes.isSelected()) {
		seniorcitizen = "YES";
	}
	else if(sno.isSelected()) {
		seniorcitizen = "NO";
	}
	
	
	String existingaccount = null;
	if(eyes.isSelected()) {
		existingaccount = "YES";
	}
	else if(eno.isSelected()) {
		existingaccount = "NO";
	}
	
	
	
	String span = pan.getText();
	String saadhar = aadhar.getText();
	
	
	 try {
			Conn c = new Conn();
			String query = "Insert into mngB values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"',  '"+span+"', '"+saadhar+"', '"+seniorcitizen+"' , '"+existingaccount+"')";
		    c.s.executeUpdate(query);
		    
		    setVisible(false);
		    new Signup3(formno).setVisible(true);
		    
	} catch (Exception ee) {
		System.out.println(ee);
	}
	 	
}

public static void main(String[] args){
	   new Signup2("");
}

}


