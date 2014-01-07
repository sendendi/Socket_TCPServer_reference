/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_tcpserver_reference;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pad
 */
public class serverController {
    private serverModel myServerModel;
    private serverView myServerView;
    private TCPServer mServer;
    
    public serverController(serverModel myServerModel, serverView myServerView){
        this.myServerModel=myServerModel;
        this.myServerView=myServerView;
        
        this.myServerView.addStartButtonListener(new startConnection());
    }
    
    class startConnection implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //disable Start Button
            myServerView.setEnableStartButton(false);
            
            //creates the object OnMessageReceived asked by the TCPServer constructor
            mServer =new TCPServer(new TCPServer.OnMessageReceived() {

                @Override
                //this method declared in the interface from TCPServer class is implemented here
                //this method is actually a callback method, because it will run every time when it will be called from
                //TCPServer class (at the while loop)
                public void messageReceived(String message) {
                    //get the Results from DB and sends it back to the Caller (Client)
                    mServer.sendMessage(myServerModel.getDBResults(message));
                }
            });
            mServer.start();
        }
    }
}
