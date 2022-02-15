/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gbms;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class sql_connect {
    
    Connection connection;
    /**
     * @param args the command line arguments
     */
    
    public void DBConnect(){
        
        try {
               
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GBMS;selectMethod=cursor", "sa", "123456");
            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());           
              /* Create and display the form */
        
         
            
        } catch (Exception e) {
            e.printStackTrace();
            Component frame = null;
            JOptionPane.showMessageDialog(frame,"Retry" );
        }
        
    }
    public static void main(String[] args) {
        
       sql_connect sql=new sql_connect();
       sql.DBConnect();
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GBMS_Frame().setVisible(true);
            }
        });
        
        
        
    }   
    
}
