/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.artists;

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

public class Artists extends JFrame{
    
    public JTextField idArtistUp;
    Controller controller;
    
    public Artists(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(460, 600);
        this.setResizable(false);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel label = new JLabel("List of Artists");
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromArtist");
        
        
        //JLabel labelEdit = new JLabel("Edit a piece of art!");
        JLabel labelEdit2 = new JLabel("Enter ID of the Artist to be updated: ");
        
        idArtistUp = new JTextField(5);
        
        
        /*
            Listing all art pieces so far in database
        */
        
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "artist name", "addrees", "website"};
        
        // Calling method on model, storing results inside "data" array
        data = controller.model.artistsList();
        
        
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
        add.setActionCommand("b20");
        
        JButton del = new JButton("Delete One");
        p2.add(del);
        del.addActionListener((ActionListener) controller);
        del.setActionCommand("b21");
        
        p2.add(labelEdit2);
        p2.add(idArtistUp);
        
        JButton editArtist = new JButton("Edit");
        p2.add(editArtist);
        editArtist.addActionListener((ActionListener) controller);
        editArtist.setActionCommand("editArtist");
        
        
        this.validate();
        this.repaint();
    }
    
}
