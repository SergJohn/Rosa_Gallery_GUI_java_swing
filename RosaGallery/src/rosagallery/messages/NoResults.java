/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.messages;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mrosa
 */
public class NoResults extends JFrame{
    
    public NoResults(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        this.setSize(300,300);
        
        JOptionPane.showMessageDialog(this, "No Results Found! Try Again");
        
        this.validate();
        this.repaint();
    }
    
}
