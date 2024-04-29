package orderingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.lang.*;
import java.util.Set;
import java.sql.*;


public class LogIn extends JFrame implements ActionListener{

    JFrame frame = new JFrame();
    JButton button;
    JButton signUp;
    JTextField inputUser;
    JPasswordField inputPassword;
    JLabel labelUser;
    JLabel labelPassword;
    JLabel popUpMessage;
    JPanel background;

    //HashMap<String, String> mainAcc;

    LogIn(/*HashMap<String, String> loginInfo*/) {

        //mainAcc = loginInfo;

        background = new JPanel();
        background.setBackground(new Color(254, 241, 2));
        background.setBounds(0, 0, 400, 400 );
        
        inputUser = new JTextField();
        inputUser.setBounds(150, 115, 150, 30);

        inputPassword = new JPasswordField();
        inputPassword.setBounds(150, 175, 150, 30);
      
        labelUser = new JLabel("Username: ");
        labelUser.setBounds(70, 80, 100, 100);

        labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(70, 140, 100, 100);

        popUpMessage = new JLabel();
        popUpMessage.setText("");
        popUpMessage.setBounds(0, 0, 10, 10);        

        button = new JButton("LogIn");
        button.setBounds(60, 240, 100, 30);
        button.setBorder(null);
        button.setForeground(Color.white);
        button.setBackground(new Color (1, 113, 187));
        button.setFocusable(false);
        button.setFont(new Font("Arial",Font.PLAIN,15));
        button.addActionListener(this);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        signUp = new JButton("Create Account");
        signUp.setBounds(170, 240, 140, 30);
        signUp.setBorder(null);
        signUp.setForeground(Color.white);
        signUp.setBackground(new Color (1, 113, 187));
        signUp.setFocusable(false);
        signUp.setFont(new Font("Arial",Font.PLAIN,15));
        signUp.addActionListener(this);
        signUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        frame.add(inputUser);
        frame.add(inputPassword);
        frame.add(labelUser);
        frame.add(labelPassword);   
        frame.add(popUpMessage);
        frame.add(button);
        frame.add(signUp);
        frame.add(background);
        frame.setTitle("LogIn"); 
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
           
    @Override
    public void actionPerformed (ActionEvent e) {
         
        if (e.getSource() == button) {
        String userID = inputUser.getText();
        String password = String.valueOf(inputPassword.getPassword());

        
        String sql = "SELECT Password FROM login.accounts WHERE Username = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "PassWord");
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, userID);
            ResultSet rs = pst.executeQuery();

           
            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                if (storedPassword.equals(password)) {
                    this.dispose();
                    MainPage mainpage = new MainPage();
                   
                } 
                else {
                    popUpMessage.setBounds(160, 210, 500, 10);
                    popUpMessage.setForeground(Color.red);
                    popUpMessage.setText("Incorrect Password");
                }
            } else {         
                popUpMessage.setBounds(160, 150, 500, 10);
                popUpMessage.setForeground(Color.red);
                popUpMessage.setText("Username not found");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
        
        if (e.getSource() == signUp) {
            SignIn createNewAccount = new SignIn();
        }
    }
}