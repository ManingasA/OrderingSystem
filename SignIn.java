
package orderingsystem;

import java.util.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.Border;

public class SignIn extends JFrame implements ActionListener{
    
    JFrame frame = new JFrame();
    JPanel background;
    JButton create;
    JTextField firstName, surName, username;
    JPasswordField password;
    JLabel firstNameLabel, surNameLabel, usernameLabel, passwordLabel;
    
    //HashMap<String, String> mainAcc;
    SignIn() {
        //mainAcc = signUpInfo;
        
        background = new JPanel();
        background.setBackground(new Color(254, 241, 2));
        background.setBounds(0, 0, 400, 450 );
        
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(60, 80, 150, 10);
          
        surNameLabel = new JLabel("Surname:");
        surNameLabel.setBounds(60, 130, 150, 10);
               
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(60, 180, 150, 10);
         
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 230, 150, 10);
       
        firstName = new JTextField();
        firstName.setBounds(140, 70, 150, 30);
        
        surName = new JTextField();
        surName.setBounds(140, 120, 150, 30);
        
        username = new JTextField();
        username.setBounds(140, 170, 150, 30);
        
        password = new JPasswordField();
        password.setBounds(140, 220, 150, 30);
       
        
        create = new JButton("Create");
        create.setBounds(140, 330, 100, 30);
        create.setBorder(null);
        create.setForeground(Color.white);
        create.setBackground(new Color (1, 113, 187));
        create.setFocusable(false);
        create.setFont(new Font("Arial",Font.PLAIN,15));
        create.addActionListener(this);
        create.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        frame.add(firstNameLabel);
        frame.add(surNameLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(firstName);
        frame.add(surName);
        frame.add(username);
        frame.add(password);
        frame.add(create);
        frame.add(background);
        frame.setTitle("Sign Up");
        frame.setSize(400, 450);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
        String sql = "INSERT INTO login.accounts (FirstName, LastName, Username, Password) VALUES (?, ?, ?, ?)";
        
        
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "PassWord");
              PreparedStatement pst = conn.prepareStatement(sql)) {
            
               String name = firstName.getText();
               String lastName = surName.getText();
               String uName = username.getText();
               String pWord = password.getText();
         
               if (name.isEmpty() || lastName.isEmpty() || uName.isEmpty() || pWord.isEmpty()) {
                   JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
               }
               
               else {
                   pst.setString(1, name);
                   pst.setString(2, lastName);
                   pst.setString(3, uName);
                   pst.setString(4, pWord);
                   
                   int registered = pst.executeUpdate();
                   if(registered > 0) {
                       JOptionPane.showMessageDialog(this, "Registered Succesful!", "Registered", JOptionPane.INFORMATION_MESSAGE);
                       this.dispose();
                       new LogIn();
                       
                   }
               }pst.close();
               conn.close();
               
        } 
        
       catch(SQLException sqle) {
           
       }
    
}}
             

