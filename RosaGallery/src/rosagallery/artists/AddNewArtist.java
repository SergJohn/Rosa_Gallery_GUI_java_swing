/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.artists;

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

public class AddNewArtist extends JFrame{
    
    public JTextField name;
    public JTextField address;
    public JTextField website;
    Controller controller;
    
    public AddNewArtist(Controller controller){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(250, 600);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JLabel label = new JLabel("Add New Artist");
        p.add(label);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel art_name = new JLabel("Name");
        JLabel art_address = new JLabel("Address");
        JLabel art_website = new JLabel("Website");
        
        name = new JTextField(20);
        address = new JTextField(20);
        website = new JTextField(20);
        
        
        p2.add(art_name);
        p2.add(name);
        p2.add(art_address);
        p2.add(address);
        p2.add(art_website);
        p2.add(website);
        
        JButton create = new JButton("Add Artist");
        p2.add(create);
        create.addActionListener((ActionListener) controller);
        create.setActionCommand("b20_1");
        
        
        this.validate();
        this.repaint();
        
    }
    
}
