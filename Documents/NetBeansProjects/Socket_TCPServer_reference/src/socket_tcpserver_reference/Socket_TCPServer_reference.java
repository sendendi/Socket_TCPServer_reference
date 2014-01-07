/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_tcpserver_reference;

/**
 *
 * @author pad
 */
public class Socket_TCPServer_reference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        serverView myServerView=new serverView();
        serverModel myServerModel=new serverModel();
        
        serverController myServerController=new serverController(myServerModel, myServerView);
        myServerView.setVisible(true);
        myServerView.setSize(200, 200);
        
        
    }
}
