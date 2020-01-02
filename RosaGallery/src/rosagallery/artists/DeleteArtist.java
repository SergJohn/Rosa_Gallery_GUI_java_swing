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

public class DeleteArtist extends JFrame{
    
    public JTextField name;
    Controller controller;
    
    public DeleteArtist(Controller controller){
        
        this.controller = controller;
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel label = new JLabel("Delete Artist");
        p.add(label);
        
        JLabel label2 = new JLabel("Insert the name of the artist to be deleted: ");
        p2.add(label2);
        //this.add(label2, BorderLayout.CENTER);
        
        name = new JTextField(20);
        p2.add(name);
        
        JButton del = new JButton("Perform Delete");
        p2.add(del);
        del.addActionListener((ActionListener) controller);
        del.setActionCommand("b21_1");
    }
    
}
