/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.admins;

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

public class AdminsFormEditInfo extends JFrame {
    
    public JTextField name;
    public JTextField email;
    public JTextField username;
    public JTextField password;
    Controller controller;
    
    public AdminsFormEditInfo(Controller controller){
        
        this.controller = controller;
        
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(250, 600);
        
        JPanel p = new JPanel();
        this.add(p);
        
        JLabel adm_name = new JLabel("Name");
        JLabel adm_email = new JLabel("Email");
        JLabel adm_username = new JLabel("Username");
        JLabel adm_password = new JLabel("Password");
        
        name = new JTextField(20);
        email = new JTextField(20);
        username = new JTextField(20);
        password = new JTextField(20);
        
        p.add(adm_name);
        p.add(name);
        p.add(adm_email);
        p.add(email);
        p.add(adm_username);
        p.add(username);
        p.add(adm_password);
        p.add(password);
        
        
        JButton updateInfo = new JButton("Update");
        p.add(updateInfo);
        updateInfo.addActionListener((ActionListener) controller);
        updateInfo.setActionCommand("b12");
        
               
        this.validate();
        this.repaint();
    }
    
}
