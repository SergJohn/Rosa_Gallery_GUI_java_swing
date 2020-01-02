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
import javax.swing.JTextField;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class EditArt extends JFrame {
    
    //public textfields to be accessed by another class
    public JTextField name;
    public JTextField description;
    public JTextField type;
    public JTextField artist;
    Controller controller;
    
    public EditArt(Controller controller, String artID){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(250, 600);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel label = new JLabel("Update Art of ID: " + artID);
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JLabel i_name = new JLabel("Name");
        JLabel i_desc = new JLabel("Description");
        JLabel i_type = new JLabel("Type");
        JLabel artists_idartists = new JLabel("Artist");
        
        name = new JTextField(20);
        description = new JTextField(20);
        type = new JTextField(20);
        artist = new JTextField(20);
        
        p2.add(i_name);
        p2.add(name);
        p2.add(i_desc);
        p2.add(description);
        p2.add(i_type);
        p2.add(type);
        p2.add(artists_idartists);
        p2.add(artist);
        
        
        JButton updateInfo = new JButton("Update");
        p2.add(updateInfo);
        updateInfo.addActionListener((ActionListener) controller);
        updateInfo.setActionCommand("updateArt");
        
               
        this.validate();
        this.repaint();
        
        
    }
    
}
