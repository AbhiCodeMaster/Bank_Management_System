package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JButton signup,clear,login; // here we access the jButton globally
    JTextField cardTextField;
    JPasswordField password;
    Login(){  // constructor 
        setLayout(null); // here we do custom layout in it because if you put the image it will automaticaly do center
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  // here we put the image on the frame
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // here we do change the size of the image
        ImageIcon i3 = new ImageIcon(i2);  // convert the image to imageIcon reson below
        JLabel label = new JLabel(i3);  // here we can not put image in JLabel so that's way we do convert the image to imageIcon
        label.setBounds(70,10,100,100);  // here we width from left side,length from top and size(width) of image and height of image
        add(label); // than we add here in the label
        
        JLabel text = new JLabel("welcome to ATM"); // here we write the text in the frame
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40); // here we give the dimensions
        add(text); // here we do add
          
        JLabel cardno = new JLabel("card no:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,250,30);
        add(cardno);
        
        cardTextField = new JTextField(); // here we make the textfield
        cardTextField.setBounds(250,150,300,40);
        add(cardTextField);
          
        JLabel pin = new JLabel("PIN:"); 
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,250,250,30);
        add(pin);
        
        password = new JPasswordField(); 
        password.setBounds(250,250,300,40);
        add(password);
        
        login = new JButton("Sign In");
        login.setBounds(250,300,100,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("clear");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("sign up");
        signup.setBounds(250,350,300,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE); // here we change the color in it 
        
        setTitle("AUTOMATE TELLER MACHINE");
        setSize(800,480);
        setLocation(350,200);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            password.setText("");
        }else if(ae.getSource() == login){
            password.setText("");
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
            
    public static void main(String[] args){
        new Login();
        
    }
    
}
