/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinglogin;

/**
 *
 * @author BERKAY
 */
public class Person {
    
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String question;
    private String answer;
    private String password;
    OracleConnection oracle=OracleConnection.getInstance();

    public Person(String username, String firstName, String lastName, String email, String question, String answer, String password) {
        
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

   
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

 

    public String getQuestion() {
        return question;
    }

  

    public String getAnswer() {
        return answer;
    }

    

    public String getPassword() {
        return password;
    }

    
    
    
    
}
