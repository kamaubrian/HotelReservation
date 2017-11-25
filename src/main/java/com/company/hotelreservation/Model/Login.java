/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Model;
import java.sql.*;
/**
 *
 * @author John Gachoki
 * 
 * 
 */
public class Login extends Base{
    public String getUsername(String username) throws SQLException{
        String user ="";
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM USER WHERE Username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = resultSet.getString("Username");
            }           
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return user;     
    }
    public String getPassword(String password) throws SQLException{
        String pass="";
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM USER WHERE Password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                pass = resultSet.getString("Password");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return pass;
    }
    public boolean addUser(String fname,String lname,String username,String passwrd) throws SQLException{
        String sql;
        try{
            getConnection();
            sql="INSERT INTO USER(FIRSTNAME,LASTNAME,Username,Password) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,passwrd);
            preparedStatement.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        
       return true;
    }
}
