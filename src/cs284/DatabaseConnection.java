
package cs284;

import com.mysql.jdbc.PreparedStatement;
import org.mariadb.jdbc.MariaDbConnection;
import org.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import org.mariadb.jdbc.Driver;




/**
 *
 * @author pongz
 */
public class DatabaseConnection {
    
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://http://mydpk.ddns.net:3307/pong284_CS284";
    private String user = "pong284"; // ตามที่เครื่องของคุณตั้งค่าไว้
    private String pass = "123456"; // ตามที่เครื่องของคุณตั้งค่าไว้
    
    
     private MariaDbConnection con = null;
     private Statement s = null;
     public DatabaseConnection() {
        try {
            Class.forName(driver);
            con =     (MariaDbConnection) DriverManager.getConnection("jdbc:mariadb://mydpk.ddns.net:3307/pong284_CS284", "pong284", "123456");
            
            s = con.createStatement();
            
            
            
            
            
           
            System.out.println("เชื่อมต่อฐานข้อมูลสำเร็จ");
            
        } catch (ClassNotFoundException  ex) {
            
            ex.printStackTrace();
            
        }catch(SQLException ex){
           // JOptionPane.showMessageDialog(null, "Conection failed");
        }
    }
     
     
     
     public void registerID(String user, String password ,String firstName, String lastName, String course,String section ) throws SQLException{
         
         
         String sqlInsert;
        sqlInsert = "INSERT INTO Userincourse (user, password , firstName , lastName , course ,  section , number ) VALUES ('"+ user +"', '" + password + "', '"+ firstName +"', '"+ lastName +"', '"+course+"', '"+section+"', NULL)";
         
       
            s.execute(sqlInsert);
        
     }
     
     
     
     
     public void getID(){
         String sql = "SELECT * FROM Userincourse";
        try {
            java.sql.PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet data = pstate.executeQuery();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     public void closeConncetion(){
         
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
       public static void main(String[] args) {
        System.out.println("เริ่มต้นโปรแกรม.........");
        
        DatabaseConnection db = new DatabaseConnection();
              
        //db.registerID();
        System.out.println("\nสิ้นสุดโปรแกรม.........");

    }

     
     
    
}
