/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mrosa
 */
public class LoginWindow extends JFrame {
    
    public JTextField tf1;
    public JTextField tf2;
    private Controller ControllerInternalRef;
    
    public LoginWindow(Controller controller){
        
        this.ControllerInternalRef = controller;
        
        attributesSetter();
        components();
        validation();
    
    }
    // Setting attributes
    private void attributesSetter(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(250,400);
        this.setTitle("Rosa Gallery - Login");
    }
    
    // Organising components
    private void components(){
                
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        p.setBackground(Color.LIGHT_GRAY);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        //p2.setBackground(Color.LIGHT_GRAY);
        
        JLabel label = new JLabel("Welcome to Rosa Gallery");
        p.add(label);
        label.setForeground(Color.BLACK);
        
        JLabel loginName = new JLabel("Username: ");
        JLabel loginPass = new JLabel("Password: ");
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        
//        this.setContentPane(new JLabel(new ImageIcon("//home//mrosa//Pictures//rosa")));
        
        JButton button = new JButton("Login");
        button.addActionListener((ActionListener) ControllerInternalRef);
        button.setActionCommand("b");
        
                
        JButton button2 = new JButton("Register");
        button2.addActionListener((ActionListener) ControllerInternalRef);
        button2.setActionCommand("b2");
        
        p2.add(loginName);
        p2.add(tf1);
        p2.add(loginPass);
        p2.add(tf2);
        p2.add(button);
        p2.add(button2);
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String getUsername(){
        return tf1.getText();
    }
    public String getPassword(){
        return tf2.getText();
    }
    
    
    
}
