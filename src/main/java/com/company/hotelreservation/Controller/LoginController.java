/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author brian-kamau
 */
public class LoginController {
    /*
    The Static field sets the theme for this application.
    */
        static{
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    
}
    public static void main(String [] args){
        
    }
    
}
