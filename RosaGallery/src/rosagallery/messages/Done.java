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
public class Done extends JFrame{
    
    public Done(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Setting visible to false in order to show only the JPtioinPane, not the Frame
        this.setVisible(false);
        this.setSize(300,300);
        
        JOptionPane.showMessageDialog(this, "Done!!!");
        
        this.validate();
        this.repaint();
    }
    
}
