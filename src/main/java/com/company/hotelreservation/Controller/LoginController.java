/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Controller;

import com.company.hotelreservation.Model.Login;
import com.company.hotelreservation.View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
            static Login loginmodel = new Login();
            static loginHandler login = new loginHandler();
            
            
            static class loginHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                    String username = loginview.getUsername().getText();
                    String password = loginview.getPassword().getText();
                    if(username.isEmpty()){
                        JOptionPane.showMessageDialog(loginview,"Enter Username");
                        return;
                    }
                    if(password.isEmpty()){
                        JOptionPane.showMessageDialog(loginview, "Enter Password");
                        return;
                    }
                    if(username.equals(loginmodel.getUsername(username)) && password.equals(loginmodel.getPassword(password))){
                        JOptionPane.showMessageDialog(loginview,"Login Success");
                    }else{
                        JOptionPane.showMessageDialog(loginview, "Incorrect Password");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }            
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
        loginview.LoginSystem().addActionListener(login);
        return loginview;
    }
    
}
