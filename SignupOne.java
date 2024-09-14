package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fatherTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser datechooser;
    
    SignupOne(){
        setLayout(null); //we have to run the setbound method otherwise it will use border layout bydefault
        Random ran = new Random(); // here we use when we use particular number
        
        random = Math.abs((ran.nextLong() % 9000L)+ 1000L);// abs means absolute
        
        JLabel formno = new JLabel("APPLICATION FORM NO " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,15));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,120,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("raleway",Font.BOLD,14));
        nameTextField.setBounds(300,120,200,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("fathers name:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,170,150,30);
        add(fname);
        
        fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("raleway",Font.BOLD,14));
        fatherTextField.setBounds(300,170,200,30);
        add(fatherTextField);
         
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300,220,200,30);
        add(datechooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,270,150,30); 
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,270,60,30);
        add(male);
        
        female = new JRadioButton("female");
        female.setBounds(400,270,100,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,320,250,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("raleway",Font.BOLD,14));
        emailTextField.setBounds(300,320,200,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital status:");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(100,370,150,30);
        add(marital);
        
        married = new JRadioButton("married");
        married.setBounds(300,370,70,30);
        add(married);
        
        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(400,370,100,30);
        add(unmarried);
        
        ButtonGroup maritalStatus = new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(unmarried);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,420,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("raleway",Font.BOLD,14));
        addressTextField.setBounds(300,420,200,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,470,150,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("raleway",Font.BOLD,14));
        cityTextField.setBounds(300,470,200,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,520,150,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("raleway",Font.BOLD,14));
        stateTextField.setBounds(300,520,200,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setBounds(100,570,150,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,570,200,30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    
    }
    
   public void actionPerformed(ActionEvent ae){
       String formno = "" + random;
       String name = nameTextField.getText();
       String fname = fatherTextField.getText();
       String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText(); // getuicomponent return in textfield that why we concatinate
       String gender = null;
       if(male.isSelected()){
           gender = "male";
       }else{
           gender = "female";
       }
       
       String email = emailTextField.getText();
       String marital = null;
       if(married.isSelected()){
           marital = "married";
       }else{
           marital = "unmarried";
       }
       
       String address = addressTextField.getText();
       String city = cityTextField .getText();
       String state = stateTextField.getText();
       String pin = pincodeTextField.getText();
       
       
       try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is required"); // we use when we want dailog box
           }else{
               Conn c = new Conn();
               String query = "insert into signupNow values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"' ,'"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
               c.s.executeUpdate(query);
               
               setVisible(false);
               new signupTwo(formno).setVisible(true);
           }
       }catch(Exception e){
           System.out.println(e);
       }
   }
   
    public static void main(String[] args){
        new SignupOne();
    }
    
}
