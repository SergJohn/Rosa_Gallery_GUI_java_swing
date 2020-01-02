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

public class WelcomeScreen extends JFrame {
    
    Controller controller;
    
    public WelcomeScreen(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        
        //Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        //Panels
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        this.add(p3, BorderLayout.EAST);
        
        //Label
        JLabel label = new JLabel("Welcome " + controller.userLogged.getUn());
        p.add(label);
        label.setForeground(Color.BLACK);
        
        //Buttons
        JButton btnShowInfo = new JButton("Info");
        p.add(btnShowInfo);
        btnShowInfo.addActionListener((ActionListener) controller);
        btnShowInfo.setActionCommand("b9");
        
        JButton logout = new JButton("Logout");
        p.add(logout);
        logout.addActionListener((ActionListener) controller);
        logout.setActionCommand("b10");
        
        JButton items = new JButton("Arts");
        p2.add(items);
        items.addActionListener((ActionListener) controller);
        items.setActionCommand("b13");
        
        JButton admins = new JButton("Admins");
        p2.add(admins);
        admins.addActionListener((ActionListener) controller);
        admins.setActionCommand("b16");
        
        
        JButton artists = new JButton("Artists");
        p2.add(artists);
        artists.addActionListener((ActionListener) controller);
        artists.setActionCommand("b19");
        
        /*
            Listing all art pieces so far in database
        */
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "description", "type", "artists"};
        //String[] columnNames2 = new String[100];
        
        // Calling the method on model, storing the results in "data"
        data = controller.model.connection();
        
        
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
