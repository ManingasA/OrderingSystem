package orderingsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;


public class UsernameAndPassword {
    
    HashMap<String, String> mainAcc = new HashMap<String, String>();
    
    UsernameAndPassword() {
        
        mainAcc.put("admin", "1234"); 
        mainAcc.put("BSIT", "202");
        mainAcc.put("Jonel", "Mamamo");
        mainAcc.put("Sayson", "HindiMahanapEarphones");
    }
    protected HashMap getLoginInfo () {
        return mainAcc;
    }
    
}
