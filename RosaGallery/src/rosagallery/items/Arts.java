/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.items;

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

public class Arts extends JFrame{
    
    public JTextField idArtUp;
    Controller controller;
    
    public Arts(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(470, 600);
        this.setResizable(false);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        this.add(p3, BorderLayout.EAST);
      
        JLabel label = new JLabel("Piece of Arts");
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromArt");
        
        //JLabel labelEdit = new JLabel("Edit a piece of art!");
        JLabel labelEdit2 = new JLabel("Enter ID of the Art to be updated: ");
        
        idArtUp = new JTextField(5);
        
        
        /*
            Listing all art pieces so far in database
        */
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "description", "type", "artists"};
        //String[] columnNames2 = new String[100];
        
        
        data = controller.model.connection();
        
        
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
        p2.add(add);
        add.addActionListener((ActionListener) controller);
        add.setActionCommand("b14");
        
        JButton del = new JButton("Delete One");
        p2.add(del);
        del.addActionListener((ActionListener) controller);
        del.setActionCommand("b15");
        
        p2.add(labelEdit2);
        p2.add(idArtUp);
        
        JButton editArt = new JButton("Edit");
        p2.add(editArt);
        editArt.addActionListener((ActionListener) controller);
        editArt.setActionCommand("editArt");
        
        
        this.validate();
        this.repaint();
    }
    
}
