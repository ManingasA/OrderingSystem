/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderingsystem;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class productDatabase extends JFrame{
   
    MainPage main;
    ResultSet rs;
   
    public productDatabase(MainPage mainPage) {
        this.main = mainPage;
        
        String instructions = "SELECT IDproduct, ProductName, Price FROM prddatabase WHERE IDproduct = ?;";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "PassWord");
                PreparedStatement pst = conn.prepareStatement(instructions)) {
                pst.setString(1, main.prodIDField.getText());
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    String retrievedProductName = rs.getString("ProductName");
                    String retrievedPrice = rs.getString("Price");
                    
                    main.prodNameField.setText(retrievedProductName);
                    main.priceField.setText(retrievedPrice);
                    main.qtyField.setText("1");
                    
                    double price = Double.parseDouble(retrievedPrice);
                    Integer quantity = Integer.parseInt(main.qtyField.getText());
                    
                    double subT = price * quantity;
                    
                    main.tPriceField.setText(String.valueOf(subT));
                    
                }   
                else {
                    JOptionPane.showMessageDialog(null, "No matching ID found");
                }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
}
    
  
}
          
   