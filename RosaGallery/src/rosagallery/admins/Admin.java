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

public class Admin extends JFrame{
    
    Controller controller;
    
    public Admin(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        this.setResizable(false);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel label = new JLabel("List of Admins");
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromAdmin");
        
        
        /*
            Listing all art pieces so far in database
        */
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "email", "username", "password"};
        
        
        data = controller.model.adminsList();
        
        
        // Creating a JTable
        JTable myTable = new JTable(data, columnNames);
        
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        //this.add(myPane, BorderLayout.CENTER);
        p2.add(myPane);
        
        /*
            add buttons to create functionalities
        */
        
        JButton add = new JButton("Add New");
        //this.add(items, BorderLayout.CENTER);
        p2.add(add);
        //p2.add(items);
        add.addActionListener((ActionListener) controller);
        add.setActionCommand("b17");
        
        JButton del = new JButton("Delete One");
        //this.add(items, BorderLayout.CENTER);
        p2.add(del);
        //p2.add(items);
        del.addActionListener((ActionListener) controller);
        del.setActionCommand("b18");
        
        
        this.validate();
        this.repaint();
        
    }
    
}
