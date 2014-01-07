/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_tcpserver_reference;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author pad
 */
public class serverModel {
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "androidpcdb";
    private String driver = "com.mysql.jdbc.Driver";// add library "MySQL JDBC Driver" in Folder "Library"
    private String userName = "root"; 
    private String password = "";
    
    private String resultDB="";

    public String getDBResults(String query){
        //calling mServer in the controller
        //here only getting "resultDB"
        Statement stmt=null;
        ResultSet rs=null;
        Connection conn=null;
        try{
            //this.query=query;
            Class.forName(driver).newInstance();
            conn=(Connection) DriverManager.getConnection(url+dbName, userName, password);
            stmt=(Statement) conn.createStatement();
            rs=stmt.executeQuery(query);
            
            ResultSetMetaData meta=(ResultSetMetaData) rs.getMetaData();
            int numberOfColumns=meta.getColumnCount();
            Object[] rowData=new Object[numberOfColumns];
            resultDB="";
            while(rs.next()){
                for (int i=0; i< rowData.length;++i){
                    resultDB+=String.valueOf(rs.getObject(i+1));
                    resultDB+="*";
                }
            }
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
            try{
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //mServer.sendMessage(resultDB);
        return resultDB;
    }
}
