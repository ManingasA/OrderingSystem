package orderingsystem;

//imports all the necessary class to use
import java.util.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class MainPage extends JFrame implements ActionListener, KeyListener, MouseListener{
    
    //the frame
        JFrame mainPage = new JFrame();
    //the three panels (colored in grey)
        JPanel register, table, receipt;
    //texts in the topPanel
        JLabel productID, productName, quantity, price, totalprice;
    //fields in the topPanel
        JTextField prodIDField, prodNameField, qtyField, priceField, tPriceField,
                totalTextField, payTextField, balanceTextField;
    //buttons in the topPanel
        JButton plusButton, minusButton, addButton, printBillButton;         
    //texts in the rightPanel    
        JLabel payLabel, totalLabel, balanceLabel;
    //table in the bottomPanel
        JTable bottomTable;
        Object[] column = {"Product ID", "Product Name", "Quantity", "Price"};
        DefaultTableModel model = new DefaultTableModel();
       
        JScrollPane scrollPane;
        
        
    //texts in the receipts
        JLabel productReceipt, qTYReceipt, priceReceipt, subTotalReceipt,
                cashReceipt, changeReceipt, separator, thankYouMessage, date, time;
    //prints out the date and time
        Date currentDate = new Date();
    //formats the time
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    //formats the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLLL dd, yyyy");
            
          
    MainPage(){
        
        //top panel
        register = new JPanel();
        register.setBackground(new Color(200, 203, 218));
        register.setBounds(15, 15, 935, 170);
        
        productID = new JLabel("Product ID");
        productID.setBounds(50, 40, 150, 30);
        productID.setFont(new Font("Arial", Font.PLAIN, 20));
        
        prodIDField = new JTextField();
        prodIDField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent enew) {
        if (enew.getKeyCode() == KeyEvent.VK_ENTER) {
            productDatabase func = new productDatabase(MainPage.this);
        }
        }
        });
        prodIDField.setFont(new Font ("Arial", Font.PLAIN, 15));
        prodIDField.setBounds(45, 80, 100, 30);
        
        productName = new JLabel("Product Name");
        productName.setBounds(220, 40, 150, 30);
        productName.setFont(new Font("Arial", Font.PLAIN, 20));
        
        prodNameField = new JTextField();
        prodNameField.setFont(new Font ("Arial", Font.PLAIN, 15));
        prodNameField.setBounds(170, 80, 220, 30);
        
        quantity = new JLabel("Quantity");
        quantity.setBounds(430, 40, 150, 30);
        quantity.setFont(new Font("Arial", Font.PLAIN, 20));
        
        qtyField = new JTextField();
        qtyField.setFont(new Font ("Arial", Font.PLAIN, 15));
        qtyField.setBounds(420, 80, 100, 30);
        
        plusButton = new JButton();
        plusButton.setBounds(530, 70, 30, 20);
        plusButton.setBackground(Color.green);
        plusButton.addActionListener(this);
        plusButton.setFocusable(false);
        
        minusButton = new JButton();
        minusButton.setBounds(530, 100, 30, 20);
        minusButton.setBackground(Color.red);
        minusButton.addActionListener(this);
        minusButton.setFocusable(false);
               
        price = new JLabel("Price");
        price.setBounds(600, 40, 150, 30);
        price.setFont(new Font("Arial", Font.PLAIN, 20));
        
        priceField = new JTextField();
        priceField.setFont(new Font ("Arial", Font.PLAIN, 15));
        priceField.setBounds(590, 80, 100, 30);
        
        totalprice = new JLabel("Total");
        totalprice.setBounds(750, 40, 150, 30);
        totalprice.setFont(new Font("Arial", Font.PLAIN, 20));
        
        tPriceField = new JTextField("0.0");
        tPriceField.setFont(new Font ("Arial", Font.PLAIN, 15));
        //tPriceField.setEnabled(false);
        tPriceField.setBounds(745, 80, 100, 30);
        
        addButton = new JButton("Add");
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color (1, 113, 187));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addButton.setBounds(745, 130, 130, 40);
    
    //bottomPanel

        bottomTable = new JTable();
        model.setColumnIdentifiers(column);
        bottomTable.setModel(model);
        bottomTable.setBackground(Color.white);
        bottomTable.setForeground(Color.black);
        bottomTable.setSelectionBackground(Color.red);
        bottomTable.setSelectionForeground(Color.white);
        bottomTable.setFont(new Font("Arial", Font.PLAIN, 20));
        bottomTable.setRowHeight(30);
        bottomTable.addMouseListener((MouseListener) this);
        bottomTable.setAutoCreateRowSorter(false);
    
        scrollPane = new JScrollPane(bottomTable);
        scrollPane.setForeground(Color.red);
        scrollPane.setBackground(Color.white);
        scrollPane.setBounds(15, 200, 935, 460);
        
        
        table = new JPanel();
        table.setBackground(new Color(200, 203, 218));
        table.setBounds(15, 200, 935, 460);
        
        /*String column[] = 
        {
            "Hello", "Second", "Third"
        };
        String data[][] =
        {
            {"hello ulit", "hello ulit", "hello ulit"},
            {"Hello", "Papamo", "Hinde"}
        };*/
        
        
        //bottomTable.setBounds(30, 230, 600, 300);    
    
    //Total, Pay, Balance

        totalLabel = new JLabel("Total");
        totalLabel.setBounds(1120, 15, 150, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        totalTextField = new JTextField();
        totalTextField.setBounds(1080, 50, 150, 30);
        totalTextField.setFont(new Font("Arial", Font.BOLD, 25));
       //totalTextField.setEditable(false);
        
        payLabel = new JLabel("Pay");
        payLabel.setBounds(1125, 90, 150, 30);
        payLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        payTextField = new JTextField();
        payTextField.setBounds(1080, 130, 150, 30);
        payTextField.setFont(new Font("Arial", Font.BOLD, 25));
        payTextField.addKeyListener(this);
        
        
        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(1110, 170, 150, 30);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        balanceTextField = new JTextField();
        balanceTextField.setBounds(1080, 210, 150, 30);
        balanceTextField.setFont(new Font("Arial", Font.BOLD, 25));
        
        printBillButton = new JButton("Print Bill");
        printBillButton.setBounds(1090, 265, 120, 40);
        printBillButton.addActionListener(this);
        printBillButton.setFont(new Font("Arial", Font.BOLD, 15));
        printBillButton.setFocusable(false);
        printBillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    //Texts that will appear in the receipt panel

        date = new JLabel("Date: " + dateFormat.format(currentDate));
        time = new JLabel("Time: " + timeFormat.format(currentDate));
        separator = new JLabel("============================================");
        
        productReceipt = new JLabel("Product");  
        qTYReceipt = new JLabel("Quantity");
        priceReceipt = new JLabel("Price");
        subTotalReceipt = new JLabel();
        cashReceipt = new JLabel();
        changeReceipt = new JLabel();
        thankYouMessage = new JLabel("Thank you for your purchase!");
        
    //Receipt panel    
        receipt = new JPanel();
        receipt.setBackground(new Color(210, 213, 218));
        receipt.setBounds(960, 320, 375, 340);
           
    //adds all the elements created in the frame
    //adds all the elements for the receipt panel
        mainPage.add(date);
        mainPage.add(time);
        mainPage.add(separator);
        mainPage.add(cashReceipt);
        mainPage.add(productReceipt);
        mainPage.add(qTYReceipt);
        mainPage.add(priceReceipt);
        mainPage.add(thankYouMessage);
        mainPage.add(subTotalReceipt);
        mainPage.add(changeReceipt);
        mainPage.add(receipt);
    //adds all the elements for the top panel    
        mainPage.add(minusButton);
        mainPage.add(plusButton);
        mainPage.add(addButton);
        mainPage.add(prodIDField);
        mainPage.add(prodNameField);
        mainPage.add(qtyField);
        mainPage.add(priceField);
        mainPage.add(tPriceField);
        mainPage.add(totalprice);
        mainPage.add(price);
        mainPage.add(quantity);
        mainPage.add(productName);
        mainPage.add(productID); 
        mainPage.add(register);
    //adds all the elements for the bottom panel    
    //  mainPage.add(bottomTable);
        mainPage.add(scrollPane);
        mainPage.add(table);  
    //adds all the elements for the Total, Pay, Balance section   
        mainPage.add(printBillButton);
        mainPage.add(balanceTextField);
        mainPage.add(balanceLabel);
        mainPage.add(payTextField);
        mainPage.add(payLabel);
        mainPage.add(totalTextField);
        mainPage.add(totalLabel);
        
    //settings of our frame
        mainPage.setSize(1365, 720);
        mainPage.setResizable(false);
        mainPage.setTitle("Ordering System");  
        mainPage.setLayout(null);
        mainPage.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPage.setVisible(true);
     
        
     //ignore the comment below this text
     //frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        
    }
       
        
    //the codes from here down to the bottom is what makes the buttons, textfields, etc, interactive
    @Override
    public void actionPerformed(ActionEvent e) {
        //this code is not yet finished
           
        
            if (e.getSource() == prodIDField) {
                prodIDField.getText();          
            }
        //this code is not yet finished but this code makes the addbutton interactive and will perform
        //task once pressed
            if (e.getSource () == addButton) {
                   
               /*double subTotal = Double.parseDouble(tPriceField.getText());
               double totalField = Double.parseDouble(totalTextField.getText());
               
               double total1 = subTotal + totalField;
               String total = String.valueOf(total1);
               
               totalTextField.setText(total);*/
                
               if (prodIDField.getText().equals("") || prodNameField.getText().equals("") ||
                       qtyField.getText().equals("") || priceField.getText().equals("")){ 
                   JOptionPane.showMessageDialog(this, "Please Enter All Data");
               }
               else {
                  Object[]rows = {prodIDField.getText(), prodNameField.getText(), qtyField.getText(), priceField.getText()}; 

                  model.addRow(rows);
               /*String column[] = 
               {
                "Product ID", "Product Name", "Quantity", "Price"
               };
        String data[][] =
               {{
               prodIDField.getText(), prodNameField.getText(), qtyField.getText(), priceField.getText()
               }};
               DefaultTableModel tblModel = (DefaultTableModel)bottomTable.getModel();
               tblModel.addRow(data);              
               //bottomTable.getTableHeader().setBounds(15, 220, 935, 460);
               //this.add(bottomTable.getTableHeader());
               bottomTable.setBounds(15, 200, 935, 460);*/
               JOptionPane.showMessageDialog(this, "Data Added Successfully!");
        
        //this code will erase all the text in the textfield above whenever the addbutton is pressed
               
               prodIDField.setText("");
               prodNameField.setText("");
               qtyField.setText("");
               priceField.setText("");
               
               
               totalTextField.setText(tPriceField.getText());
               tPriceField.setText("");
               
               //totalTextField.setEditable(false);   
               }
            
               
                /* String printedProdId = prodIDField.getText();
                String printedProdName = prodNameField.getText();
                String printedQty = qtyField.getText();
                String printedPrice = priceField.getText();
                String printedTotalPrice = tPriceField.getText();*/    
            }
        
            if(e.getSource() == plusButton) {
                Integer quantityTable = Integer.valueOf(qtyField.getText());
                quantityTable++;
                qtyField.setText(quantityTable.toString());
                
                Double price = Double.parseDouble(priceField.getText());
                String subtotal = String.valueOf(quantityTable * price);
                tPriceField.setText(subtotal);
                
                
            }
            
            if(e.getSource() == minusButton) {
                Integer quantityTable = Integer.valueOf(qtyField.getText());
                quantityTable--;
                qtyField.setText(quantityTable.toString());
                
                Double price = Double.valueOf(priceField.getText());
                String subtotal = String.valueOf(quantityTable * price);
                tPriceField.setText(subtotal);
            }
            
        //this code will print out the receipt once the printBill button is pressed
            if(e.getSource() == printBillButton) {
                date.setBounds(990, 320, 150, 100);
                time.setBounds(990, 340, 100, 100);
                separator.setBounds(990, 360, 350, 100);
                productReceipt.setBounds(990, 375, 100, 100);
                qTYReceipt.setBounds(1070, 375, 100, 100);
                priceReceipt.setBounds(1150, 375, 100, 100);
                thankYouMessage.setBounds(1080, 590, 180, 100);
                subTotalReceipt.setBounds(1200, 480, 100, 100);
                cashReceipt.setBounds(1200, 500, 100, 100);
                changeReceipt.setBounds(1200, 520, 100, 100);
                                       
                        //String name = payTextField.getText();
                        //name.setBounds();
            }
           
    }
//the code below will make it so that when the user typed a key, it will respond
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
//the code below will make it so that when the user pressed a key, it will respond
//the code below will get the text in the total, pay, and balance field and turn them into integers
//and calculate them
    
    
    @Override
    public void keyPressed(KeyEvent e) {
       
        try {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            double num1 = Double.parseDouble(totalTextField.getText());   
            double num2 = Double.parseDouble(payTextField.getText());
            String result = String.valueOf(num2 - num1);
            
            if (num2 < num1) {
                JOptionPane.showMessageDialog(null, "GAGO KULANG!");
                balanceTextField.setText("");
            }
            else {
            balanceTextField.setText(result); 
            
            subTotalReceipt.setText("Subtotal: " + " ₱" + totalTextField.getText());
            cashReceipt.setText("      Cash: " + " ₱" + payTextField.getText());
            changeReceipt.setText(" Change: " + " ₱" + result);            
            }
        }
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Only enter numbers.");
        }

        
       /*try {
       if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           productDatabase data = new productDatabase();
           
           String enteredId = prodIDField.getText();
           String productName = data.getProductName();
           String productPrice = data.getPrice();
           
           
       }
       }
       catch (NumberFormatException nme) {
           nme.printStackTrace();
       }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        if (e.getSource() == bottomTable) {
               int SelectedRowIndex = bottomTable.getSelectedRow();
               if(SelectedRowIndex != -1) {
               int option = JOptionPane.showConfirmDialog
               (null, "Do you want to delete the selected row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
               if(option == JOptionPane.YES_OPTION) {
                   model.removeRow(SelectedRowIndex);
               }
              
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
    
    }

