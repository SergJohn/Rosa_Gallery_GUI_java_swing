/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.customers;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class SearchResultsName extends JFrame{
    
    Controller controller;
    
    public SearchResultsName(Controller controller){
        
        this.controller = controller;
        
        this.setVisible(true);
        this.setSize(500, 600);
        this.setResizable(false);
        
        //Layout Manager
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        //Panel
        JPanel p = new JPanel();
        this.add(p, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        this.add(p2, BorderLayout.CENTER);
        
        //Label
        JLabel label = new JLabel("Results Search piece of art by Art Name");
        p.setBackground(Color.LIGHT_GRAY);
        p.add(label);
       
        String[][] data = null;
        
        // Definning columnNames
        String[] columnNames = {"id", "name", "description", "type", "artists"};
        
        data = controller.model.searchByName(controller);
        
        // Creating a JTable
        JTable myTable = new JTable(data, columnNames);
        
        myTable.setRowHeight(22);
        
        // Creating a JScrollPane
        JScrollPane myPane = new JScrollPane(myTable);
        
        //this.add(myPane, BorderLayout.CENTER);
        p2.add(myPane);
        
        
        this.validate();
        this.repaint();
    }
}
