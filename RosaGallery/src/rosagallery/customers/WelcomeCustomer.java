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
import javax.swing.JTextField;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */
public class WelcomeCustomer extends JFrame {
    
    //textfield public to be accessible outside this class
    public JTextField artID;
    Controller controller;
    
    public WelcomeCustomer (Controller controller){
        
        this.controller = controller;
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        
        //Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        //Panel
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        //Label
        JLabel label = new JLabel("Welcome Sr. Customer " + controller.userLogged.getUn());
        p.setBackground(Color.LIGHT_GRAY);
        label.setForeground(Color.BLACK);
        p.add(label);
        
        //Buttons
        JButton btnUpdate = new JButton("Info");
        p.add(btnUpdate);
        btnUpdate.addActionListener((ActionListener) controller);
        btnUpdate.setActionCommand("b4");
        
        JButton logout = new JButton("Logout");
        p.add(logout);
        logout.addActionListener((ActionListener) controller);
        logout.setActionCommand("b5");
        
        JButton search = new JButton("Search");
        p2.add(search);
        search.addActionListener((ActionListener) controller);
        search.setActionCommand("b22");
        
        JButton favorites = new JButton("Favorites");
        p2.add(favorites);
        favorites.addActionListener((ActionListener) controller);
        favorites.setActionCommand("b6");
        
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "description", "type", "artists"};
        //String[] columnNames2 = new String[100];
        
        //Calling connection in Model
        data = controller.model.connection();
        
        
        // Creating a JTable
        JTable myTable = new JTable(data, columnNames);
        
        myTable.setRowHeight(22);
        
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        
        p2.add(myPane);
        
        //Liking the arts in high level way, no mistakes with clicks. User type the ID of the art and click in a button
        JLabel l = new JLabel("Type the Art ID that you liked: ");
        
        artID = new JTextField(10);
        
        p2.add(l);
        p2.add(artID);
        
        JButton like = new JButton("Like it!");
        p2.add(like);
        like.addActionListener((ActionListener) controller);
        like.setActionCommand("like");
       
        
        this.validate();
        this.repaint();
        
    }
    
}
