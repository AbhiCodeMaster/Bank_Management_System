package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener{
    
    JTextField emailTextField,addressTextField,addharTextField;
    JButton next;
    JRadioButton yes,No,choice,choices;
    JComboBox InOccupation,Education,Income,relegion,Category;
    String formno;
    signupTwo(String formno){
        this.formno = formno;
        setLayout(null); //we have to run the setbound method otherwise it will use border layout bydefault
        
        
        JLabel AdditionalDetails = new JLabel("page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,15));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);
        
        JLabel religions = new JLabel("Religion:");
        religions.setFont(new Font("Raleway",Font.BOLD,15));
        religions.setBounds(100,120,100,30);
        add(religions);
        
        String valReligion[] = {"Hindu","Muslim","Christian","Other"};
        relegion = new JComboBox(valReligion);
        relegion.setBounds(300,120,200,30);
        add(relegion);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(100,170,150,30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,170,200,30);
        add(Category);
         
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        String valIncome[] = {"NULL","1,000-10,000","10,000-50,000","50,000-1,00,000"};
        Income = new JComboBox(valIncome);
        Income.setBounds(300,220,200,30);
        add(Income);
        
        
        JLabel gender = new JLabel("Educational Qualification:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,270,200,30); 
        add(gender);
        
        String valEducation[] = {"Graducation pursuing","12th pass","10th pass","Graducation"};
        Education = new JComboBox(valEducation);
        Education.setBounds(300,270,200,30);
        add(Education);
        
        JLabel Occupation = new JLabel("Occupation");
        Occupation.setBounds(100,320,150,30);
        Occupation.setFont(new Font("Raleway",Font.BOLD,15));
        add(Occupation);
        
        String valOccupation[] = {"currently posted","jobless"};
        InOccupation = new JComboBox(valOccupation);
        InOccupation.setBounds(300,320,200,30);
        add(InOccupation);
        
        JLabel panNo = new JLabel("PanNo:");
        panNo.setFont(new Font("Raleway",Font.BOLD,15));
        panNo.setBounds(100,370,200,30);
        add(panNo);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("raleway",Font.BOLD,14));
        addressTextField.setBounds(300,370,200,30);
        add(addressTextField);
        
        JLabel addharNo = new JLabel("Addhar Number:");
        addharNo.setFont(new Font("Raleway",Font.BOLD,15));
        addharNo.setBounds(100,420,150,30);
        add(addharNo);
        
        addharTextField = new JTextField();
        addharTextField.setFont(new Font("raleway",Font.BOLD,14));
        addharTextField.setBounds(300,420,200,30);
        add(addharTextField);
        
        JLabel Email = new JLabel("Email");
        Email.setFont(new Font("Raleway",Font.BOLD,15));
        Email.setBounds(100,470,50,30);
        add(Email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,15));
        emailTextField.setBounds(300,470,200,30);
        add(emailTextField);
        
        JLabel seniorcitizen = new JLabel("Senior citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,15));
        seniorcitizen.setBounds(100,520,150,30);
        add(seniorcitizen);
        
        yes = new JRadioButton("yes");
        yes.setBounds(300,520,50,30);
        add(yes);
        
        No = new JRadioButton("No");
        No.setBounds(400,520,50,30);
        add(No);
        
        ButtonGroup select = new ButtonGroup();
        select.add(yes);
        select.add(No);
        
        JLabel ExistingAccount = new JLabel("Existing Account:");
        ExistingAccount.setFont(new Font("Raleway",Font.BOLD,15));
        ExistingAccount.setBounds(100,570,150,30);
        add(ExistingAccount);
        
        choice = new JRadioButton("yes");
        choice.setBounds(300,570,50,30);
        add(choice);
        
        choices = new JRadioButton("No");
        choices.setBounds(400,570,50,30);
        add(choices);
        
        ButtonGroup select2 = new ButtonGroup();
        select2.add(choice);
        select2.add(choices);
        
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
       
       String sreligion = (String) relegion.getSelectedItem();
       String scategory = (String) Category.getSelectedItem();
       String sincome = (String) Income.getSelectedItem();
       String seducation = (String) Education.getSelectedItem();
       String soccupation = (String) InOccupation.getSelectedItem();
       String seniorcitizen = null;
       if(yes.isSelected()){
           seniorcitizen = "yes";
       }else if(No.isSelected()){
           seniorcitizen = "No";
       }
       String email = emailTextField.getText();
       String ExistingAccount = null;
       if(choice.isSelected()){
           ExistingAccount = "NO";
       }else if(choices.isSelected()){
           ExistingAccount = "yes";
       }
       String span = addressTextField.getText();
       String saddhar = addharTextField.getText();
       
       try{
           Conn c = new Conn();
           String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saddhar+"','"+seniorcitizen+"','"+ExistingAccount+"','"+email+"')";
           c.s.executeUpdate(query);
           
        
       }
       catch(Exception e){
           System.out.print(e);
       }
   }
   
    public static void main(String[] args){
        new signupTwo("");
    }
    
}
