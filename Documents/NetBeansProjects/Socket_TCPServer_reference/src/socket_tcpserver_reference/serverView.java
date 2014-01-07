/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_tcpserver_reference;

import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author pad
 */
public class serverView extends JFrame{
    private JButton bStart;
    
    public serverView(){
        super("Database Proxy");
        
        JPanel panelField=new JPanel();
        bStart=new JButton("Start");
        panelField.add(bStart);
        add(panelField);
    }
    
    void addStartButtonListener(ActionListener ListenForButton){
        bStart.addActionListener(ListenForButton);
    } 
    
    public void setEnableStartButton(boolean b){
        bStart.setEnabled(b);
    }
}
