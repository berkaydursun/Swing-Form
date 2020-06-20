/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinglogin;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/*
 String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
        String username="SYSTEM";
        String password="SYSTEM";
        Statement statement=null;
        String namee="BERKAY";
        
        /*
        String sql="INSERT INTO DENEME (isim,soyisim) VALUES ('MUSTAFA','KEMAL')";
            statement=con.createStatement();
            statement.executeUpdate(sql);
            
        */
        /*
        try {
            
            Class.forName ("oracle.jdbc.OracleDriver");
            Connection con =DriverManager.getConnection(dbUrl,username,password);   
            String sql="SELECT *FROM DENEME";
            statement=con.createStatement();
            
            
            ResultSet rs=statement.executeQuery(sql);
            System.out.println("çalış1");
            while(rs.next()){
                System.out.println("Çalış2");
                String item=rs.getString("isim");
                System.out.println(item);
            }
            
            
            
            
            
            
        }
        catch (SQLException ex) {
            System.out.println("OPPS,ERROR");
            Logger.getLogger(JavaOracleOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

*/



/**
 *
 * @author BERKAY
 */
public class OracleConnection {
        
        private String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
        private String username="SYSTEM";
        private String password="SYSTEM";
        private Statement statement=null;
        private Connection con=getConnection();
        private static OracleConnection instance=null;
        
       private OracleConnection(){
        }
       
       public static OracleConnection getInstance(){
         if(instance==null){
         synchronized (OracleConnection.class) {
            if (instance==null) {
            instance=new OracleConnection();
        }
    }
   
}
  return instance;
    }
        
        public Connection getConnection(){
      	 String url="jdbc:oracle:thin:@localhost:1521:xe";
    
        try {
           Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No Found Driver");
        }
        
        try {
           con=(Connection) DriverManager.getConnection(dbUrl,username,password); 
            System.out.println("Connection Succesfull");
            
        } catch (SQLException ex) {
            System.out.println("Connection Unsuccesfull");
        }
    
		return con;
	
    }
        
        
        
        
        public void addPerson(Person p){
        String query="INSERT INTO person(username,firstname,lastname,email,securityquestion,answer,password) VALUES ("+"'"+p.getUsername()+"'"+","+"'"+p.getFirstName()+"'"+","+"'"+p.getLastName()+"'"+","+"'"+p.getEmail()+"'"+","+"'"+p.getQuestion()+"'"+","+"'"+p.getAnswer()+"'"+","+"'"+p.getPassword()+"'"+")";
        
        try {
                statement=(Statement) con.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        public void setNames(JTextField username,JTextField name,JTextField surname,JTextField question){
        String query="SELECT username,firstname,lastname,securityquestion,answer FROM Person where username="+"'"+username.getText()+"'";
        
        try {
                statement=con.createStatement();           
                ResultSet rs=  statement.executeQuery(query);  
                while(rs.next()){
                name.setText(rs.getString("firstname"));
                surname.setText(rs.getString("lastname"));
                question.setText(rs.getString("securityquestion"));
                
                }
          
        }   catch (SQLException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
   

        }
        
        public boolean controlAnswer(JTextField username,JTextField answer,JTextField password){
        String query="SELECT username,answer,password FROM Person where username="+"'"+username.getText()+"'";
        try {
                statement=con.createStatement();           
                ResultSet rs=  statement.executeQuery(query);  
                while(rs.next()){
                String myAnswer=rs.getString("answer");
                String myPassword=rs.getString("password");
                if(answer.getText().equals(myAnswer)){
                    password.setText(myPassword);
                return true;
                }
                }
          
        }   catch (SQLException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
        }
        
        
        
        
        
        public boolean controlUsername(String username){
        String query="SELECT username FROM Person";
        
        try {
                statement=con.createStatement();           
                ResultSet rs=  statement.executeQuery(query);  
                while(rs.next()){
                String Username=rs.getString("username");
                if(username.equals(Username)){
                    return true;
                }
                
                }
          
        }   catch (SQLException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;

        }
        
        
        public boolean controlLogin(String id,String password){
    String sorgu="Select username,password From Person";
        try {
            statement=con.createStatement();           
          ResultSet rs=  statement.executeQuery(sorgu);  
          while(rs.next()){
          String myUsername=rs.getString("username");
          String myPassword=rs.getString("password");
          if(myUsername.equals(id)&&myPassword.equals(password)){
             return true;
          }
          
          }  
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    
    }
        
        
        
}
        
        
    
        
        
    

