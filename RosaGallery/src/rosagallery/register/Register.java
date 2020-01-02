/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.register;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Register extends JFrame{
   
    public JTextField tfname;
    public JTextField tfemail;
    public JTextField tfaddress;
    public JTextField tfusername;
    public JTextField tfpwd;
    private Controller ControllerInternalRef;
        
    public Register(Controller controller) {
        
        this.ControllerInternalRef = controller;
        
        this.setVisible(true);
        this.setSize(250, 400);
        this.setTitle("Rosa Gallery - Register");
        this.setResizable(false);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel label = new JLabel("Create a Rosa Gallery Account");
        label.setForeground(Color.BLACK);
        JLabel name = new JLabel("Name");
        JLabel email = new JLabel("Email");
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JLabel address = new JLabel("Address");
        
        tfname = new JTextField(20);
        tfemail = new JTextField(20);
        tfaddress = new JTextField(20);
        tfusername = new JTextField(20);
        tfpwd = new JTextField(20);
        
        JButton button = new JButton("Confirm");
        button.addActionListener((ActionListener) ControllerInternalRef);
        button.setActionCommand("b3");
        
        p.add(label);
        
        p2.add(name);
        p2.add(tfname);
        p2.add(email);
        p2.add(tfemail);
        p2.add(address);
        p2.add(tfaddress);
        p2.add(username);
        p2.add(tfusername);
        p2.add(password);
        p2.add(tfpwd);
        p2.add(button);
        
        this.validate();
        this.repaint();
        
    }
    
    public String getName2(){
        return tfname.getText();
    }
    public String getEmail(){
        return tfemail.getText();
    }
    public String getUsername(){
        return tfusername.getText();
    }
    public String getPassword(){
        return tfpwd.getText();
    }
    public String getAddress(){
        return tfaddress.getText();
    }
    
    
}
