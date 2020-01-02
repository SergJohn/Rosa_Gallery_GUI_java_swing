/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.customers;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class formEditInfo extends JFrame {
    
    //public textfields to be visible in other classes
    public JTextField name;
    public JTextField username;
    public JTextField address;
    public JTextField email;
    public JTextField password;
    Controller controller;
    
    public formEditInfo(Controller controller){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(250, 600);
        
        JPanel p = new JPanel();
        this.add(p);
        
        JLabel cus_name = new JLabel("Name");
        JLabel cus_username = new JLabel("Username");
        JLabel cus_address = new JLabel("Address");
        JLabel cus_email = new JLabel("Email");
        JLabel cus_password = new JLabel("Password");
        
        name = new JTextField(20);
        username = new JTextField(20);
        address = new JTextField(20);
        email = new JTextField(20);
        password = new JTextField(20);
        
        p.add(cus_name);
        p.add(name);
        p.add(cus_username);
        p.add(username);
        p.add(cus_address);
        p.add(address);
        p.add(cus_email);
        p.add(email);
        p.add(cus_password);
        p.add(password);
        
                
        JButton updateInfo = new JButton("Update");
        p.add(updateInfo);
        updateInfo.addActionListener((ActionListener) controller);
        updateInfo.setActionCommand("b8");
        
               
        this.validate();
        this.repaint();
    }
}
