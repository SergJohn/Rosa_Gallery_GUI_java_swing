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

public class Favorites extends JFrame{
    
    Controller controller;
    
    public Favorites(Controller controller){
        
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
//        
        JPanel p3 = new JPanel();
        this.add(p3, BorderLayout.EAST);
        
        //Label
        JLabel label = new JLabel("Welcome to your Favorite Arts, " + controller.userLogged.getUn());
        label.setForeground(Color.BLACK);
        p.add(label);
        
        //Btn back to dashboard
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromFav");
        
        
        /*
            Listing all Favorite art pieces so far in database
        */
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "description", "type", "artists"};
        //String[] columnNames2 = new String[100];
        
        //Cassling the method to find out the favorites to each specific user
        data = controller.model.Favorites(controller.userLogged.getPw());
        
        
        // Creating a JTable
        JTable myTable = new JTable(data, columnNames);
        
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        //this.add(myPane, BorderLayout.CENTER);
        p2.add(myPane);
        
        this.validate();
        this.repaint();
    }
    
}
