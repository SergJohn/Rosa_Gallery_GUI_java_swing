/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.admins;

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

public class AdminsInfo extends JFrame {
    
    Controller controller;
    
    public AdminsInfo(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        
        //Defining a Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        
        JLabel label = new JLabel("Admin Informations: " + controller.userLogged.getUn());
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromAdminInfo");
        
        String[][] info = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "email", "username", "password"};
       
        // Calling the function to populate the table
        String pass = controller.userLogged.getPw();
        info = controller.model.adminInformations(pass);
        
        
        // Creating a JTable
        JTable myTable = new JTable(info, columnNames);
        
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        //this.add(myPane, BorderLayout.CENTER);
        p2.add(myPane);
        
        JButton edit = new JButton("Edit");
        p2.add(edit);
        edit.addActionListener((ActionListener) controller);
        edit.setActionCommand("b11");
        
        this.validate();
        this.repaint();
    }
    
}
