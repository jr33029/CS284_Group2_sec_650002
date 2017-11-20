
package cs284;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.mariadb.jdbc.MariaDbConnection;




/**
 *
 * @author pongz
 */
public class DatabaseConnection {
    
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://http://mydpk.ddns.net:3307/pong284_CS284";
    private String user = "pong284"; // เธ•เธฒเธกเธ—เธตเน�เน€เธ�เธฃเธทเน�เธญเธ�เธ�เธญเธ�เธ�เธธเธ“เธ•เธฑเน�เธ�เธ�เน�เธฒเน�เธงเน�
    private String pass = "123456"; // เธ•เธฒเธกเธ—เธตเน�เน€เธ�เธฃเธทเน�เธญเธ�เธ�เธญเธ�เธ�เธธเธ“เธ•เธฑเน�เธ�เธ�เน�เธฒเน�เธงเน�
    
    
     private MariaDbConnection con = null;
     private Statement s = null;
     public DatabaseConnection() {
        try {
            Class.forName(driver);
            con =     (MariaDbConnection) DriverManager.getConnection("jdbc:mariadb://mydpk.ddns.net:3307/pong284_CS284", "pong284", "123456");
            
            s = con.createStatement();
            
            
            
            
            
           
            System.out.println("Connection Successed");
            
        } catch (ClassNotFoundException  ex) {
            
            ex.printStackTrace();
            
        }catch(SQLException ex){
           // JOptionPane.showMessageDialog(null, "Conection failed");
        }
    }
     
     
     
     public boolean registerID(String user, String password ,String firstName, String lastName, String course,String section ) throws SQLException{
         if(hasDuplicatedUser(user)) {
        	 JOptionPane.showMessageDialog(null, "This user has already been used");
        	 return false;
         }else if(user.isEmpty() || password.isEmpty()|| firstName.isEmpty()|| lastName.isEmpty() || course.isEmpty() || section.isEmpty()) {
        	 JOptionPane.showMessageDialog(null, "Please fill all information");
        	 return false;
         }
         
         char[] sec = section.toCharArray();
        for (int i = 0; i < sec.length; i++) {
			if(!Character.isDigit(sec[i])) {
				JOptionPane.showMessageDialog(null, "Please insert only Digit in Section field");
				return false;
			}
		}
         
         
         String sqlInsert;
        sqlInsert = "INSERT INTO Userincourse (user, password , firstName , lastName , course ,  section , number ) VALUES ('"+ user +"', '" + password + "', '"+ firstName +"', '"+ lastName +"', '"+course+"', '"+section+"', NULL)";
         
       
            s.execute(sqlInsert);
            
            JOptionPane.showMessageDialog(null, "Register Successed\n Username: " +user);
        return true;
     }
     
     public boolean hasDuplicatedUser(String user) {
    	 String sql = "SELECT * FROM Userincourse";
    	 java.sql.PreparedStatement pstate;
		try {
			pstate = con.prepareStatement(sql);
			  ResultSet data = pstate.executeQuery();
			  
			  while(data.next()) {
				  if(data.getString("user").equals(user)) {
					  return true;
				  }
				  
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return false;
     }
     
     
     
     public boolean login(String user , String password){
         String sql = "SELECT * FROM Userincourse";
        try {
            java.sql.PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet data = pstate.executeQuery();
            
            boolean userSuccess = false;
            String successUser = null;
            String successPW = null;
            while(data.next()){
                
                if(data.getString("user").equals(user)){
                    userSuccess = true;
                    successUser = data.getString("user");
                    successPW = data.getString("password");
                    break;
                }
                    
            }
            
            if(!userSuccess){
                JOptionPane.showMessageDialog(null, "No user","Error", JOptionPane.ERROR_MESSAGE);
            }else{
                pstate = con.prepareStatement(sql);
                data = pstate.executeQuery();
                
                boolean pwSuccess = false;
               
                 while(data.next()){
                
                     
                    if(successPW.equals(password) && successPW !=null ){
                        pwSuccess = true;

                        return true;
                    }

                   
                
                    
                 }
                 
                  if(!pwSuccess){
                        JOptionPane.showMessageDialog(null, "Wrong Password”" ,"Error", JOptionPane.ERROR_MESSAGE);
                    }
                
            }
                    
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
     }
     
     
     public void closeConncetion(){
         
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
       public static void main(String[] args) {
        System.out.println("เน€เธฃเธดเน�เธกเธ•เน�เธ�เน�เธ�เธฃเน�เธ�เธฃเธก.........");
        
        DatabaseConnection db = new DatabaseConnection();
              
        //db.registerID();
        System.out.println("\nเธชเธดเน�เธ�เธชเธธเธ”เน�เธ�เธฃเน�เธ�เธฃเธก.........");

    }

     
     
    
}
