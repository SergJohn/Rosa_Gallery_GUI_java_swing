/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.customers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class CustomerInfo extends JFrame {
    
    Controller controller;
    
    public CustomerInfo(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        
        //Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        //Panel
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        //Label
        JLabel label = new JLabel("Customer Informations: " + controller.userLogged.getUn());
        label.setForeground(Color.BLACK);
        p.add(label);
        
        //Button to dashboard
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromCusInfo");
        
        String[][] info = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "username", "address", "email", "password"};
       
        // Calling the function to populate the table
        // Passing the user password to do the right selection
        String pass = controller.userLogged.getPw();
        info = controller.model.customerInformations(pass);
        
        
        // Creating a JTable
        JTable myTable = new JTable(info, columnNames);
        
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        //this.add(myPane, BorderLayout.CENTER);
        p2.add(myPane);
        
        JButton edit = new JButton("Edit");
        p2.add(edit);
        edit.addActionListener((ActionListener) controller);
        edit.setActionCommand("b7");
        
        this.validate();
        this.repaint();
    }
    
}
