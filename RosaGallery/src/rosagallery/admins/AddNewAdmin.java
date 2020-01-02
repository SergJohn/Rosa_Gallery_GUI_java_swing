/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.admins;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class AddNewAdmin extends JFrame{
    
    public JTextField name;
    public JTextField email;
    public JTextField username;
    public JTextField password;
    Controller controller;
    
    public AddNewAdmin(Controller controller){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(250, 600);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JLabel label = new JLabel("Add New Administrator");
        //this.add(label, BorderLayout.NORTH);
        p.add(label);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel adm_name = new JLabel("Name");
        JLabel adm_email = new JLabel("Email");
        JLabel adm_username = new JLabel("Username");
        JLabel adm_password = new JLabel("Password");
        
        name = new JTextField(20);
        email = new JTextField(20);
        username = new JTextField(20);
        password = new JTextField(20);
        
        
        p2.add(adm_name);
        p2.add(name);
        p2.add(adm_email);
        p2.add(email);
        p2.add(adm_username);
        p2.add(username);
        p2.add(adm_password);
        p2.add(password);
        
        JButton create = new JButton("Make Admin");
        //this.add(items, BorderLayout.CENTER);
        p2.add(create);
        //p2.add(items);
        create.addActionListener((ActionListener) controller);
        create.setActionCommand("b17_1");
        
        
        
        this.validate();
        this.repaint();
        
    }
    
    
}
