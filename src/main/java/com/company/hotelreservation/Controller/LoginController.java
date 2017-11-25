/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Controller;

import com.company.hotelreservation.View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
            static LoginView loginview = new LoginView();
            static loginHandler login = new loginHandler();
            
            
            static class loginHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
            
            
            
            
        }
                
    }
            
        static class SignUpHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    
}    
      
    public static void main(String [] args){
        showLogin();
    }
    public static JFrame showLogin(){
        loginview.setLocationRelativeTo(null);
        loginview.setResizable(false);
        loginview.setVisible(true);
        loginview.setTitle("Hotel Reservation");
        return loginview;
    }
    
}
