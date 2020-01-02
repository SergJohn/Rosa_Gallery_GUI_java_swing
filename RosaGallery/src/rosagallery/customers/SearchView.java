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
import javax.swing.JTextField;
import rosagallery.login.Controller;

/**
 *
 * @author mrosa
 */

public class SearchView extends JFrame{
    
    public JTextField artName;
    public JTextField artType;
    public JTextField artistName;
    Controller controller;
    
    public SearchView(Controller controller){
        
        this.controller = controller;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(400, 600);
        this.setResizable(false);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        JLabel label = new JLabel("Search Art Pieces");
        JLabel i_name = new JLabel("Art Name");
        JLabel i_type = new JLabel("Art Type");
        JLabel artists_idartists = new JLabel("Artist ID");
        
        artName = new JTextField(20);
        artType = new JTextField(20);
        artistName = new JTextField(20);
        
        p.setBackground(Color.LIGHT_GRAY);
        p.add(label);
        
        JButton back = new JButton("dashboard");
        p.add(back);
        back.addActionListener((ActionListener) controller);
        back.setActionCommand("backFromSearch");
        
        
        p2.add(i_name);
        p2.add(artName);
        JButton searchName = new JButton("Search");
        p2.add(searchName);
        searchName.addActionListener((ActionListener) controller);
        searchName.setActionCommand("SearchByName");
        
        p2.add(i_type);
        p2.add(artType);
        JButton searchType = new JButton("Search");
        p2.add(searchType);
        searchType.addActionListener((ActionListener) controller);
        searchType.setActionCommand("SearchByType");
        
        p2.add(artists_idartists);
        p2.add(artistName);
        JButton searchArtist = new JButton("Search");
        p2.add(searchArtist);
        searchArtist.addActionListener((ActionListener) controller);
        searchArtist.setActionCommand("SearchByArtistId");
        
               
        this.validate();
        this.repaint();
    }
    
}
