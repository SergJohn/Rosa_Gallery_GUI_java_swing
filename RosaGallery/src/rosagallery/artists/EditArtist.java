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
import javax.swing.JTextField;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class EditArtist extends JFrame{
    
    //declaring textfield public in order to get data in other classes
    public JTextField name;
    public JTextField address;
    public JTextField website;
    Controller controller;
    
    public EditArtist(Controller controller, String artistID){
        
        this.controller = controller;
        
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(250, 600);
        
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
        JLabel label = new JLabel("Update Artist of ID: " + artistID);
        label.setForeground(Color.BLACK);
        p.add(label);
        
        JLabel art_name = new JLabel("Artist Name");
        JLabel art_address = new JLabel("Address");
        JLabel art_website = new JLabel("Website");
        
        //Textfield
        name = new JTextField(20);
        address = new JTextField(20);
        website = new JTextField(20);
        
        p2.add(art_name);
        p2.add(name);
        p2.add(art_address);
        p2.add(address);
        p2.add(art_website);
        p2.add(website);
        
        //Button
        JButton updateInfo = new JButton("Update");
        p2.add(updateInfo);
        updateInfo.addActionListener((ActionListener) controller);
        updateInfo.setActionCommand("updateArtist");
        
               
        this.validate();
        this.repaint();
    }
    
}
