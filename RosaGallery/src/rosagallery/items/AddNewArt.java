/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.items;

import java.awt.BorderLayout;
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

public class AddNewArt extends JFrame{
    
    //making visible outside class
    public JTextField name;
    public JTextField description;
    public JTextField type;
    public JTextField artist;
    Controller controller;
    
    public AddNewArt(Controller controller){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(250, 600);
        
        //Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        //Panels
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JLabel label = new JLabel("Add New Piece Of Art");
        p.add(label);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        //Lables
        JLabel i_name = new JLabel("Name");
        JLabel i_desc = new JLabel("Description");
        JLabel i_type = new JLabel("Type");
        JLabel artists_idartists = new JLabel("Artist");
        
        //declaring
        name = new JTextField(20);
        description = new JTextField(20);
        type = new JTextField(20);
        artist = new JTextField(20);
        
        //Adding
        p2.add(i_name);
        p2.add(name);
        p2.add(i_desc);
        p2.add(description);
        p2.add(i_type);
        p2.add(type);
        p2.add(artists_idartists);
        p2.add(artist);
        
        //Button
        JButton create = new JButton("Add Master Piece");
        p2.add(create);
        create.addActionListener((ActionListener) controller);
        create.setActionCommand("b14_1");
        
        
        this.validate();
        this.repaint();
    }
    
}
