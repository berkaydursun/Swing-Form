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
public class Main {

    /**
     * @param args the command line arguments
     */
    OracleConnection oracle=OracleConnection.getInstance();
    
    public static void main(String[] args) {

        new Home().setVisible(true);
        
    }
    
}