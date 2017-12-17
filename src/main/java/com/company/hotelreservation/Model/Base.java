/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Model;
import com.company.hotelreservation.Model.BaseUtils.BaseUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author John Gachoki
 * This Class Defines Connection to the database;
 */
public abstract class Base implements BaseUtils {
    Properties properties = new Properties();
    private final String username =getDatabaseCredentials().get(0); //Username for XAMPP or WAMP mysql user
    private final String password =getDatabaseCredentials().get(1); //Password for the same
    private final String url = "jdbc:mysql://localhost:3306/"+getDatabaseCredentials().get(2)+"?useSSL=false";
    protected PreparedStatement preparedStatement = null;
    protected Connection connection =null;
    protected ResultSet resultSet = null;
    InputStream input;
    private File logfile = new File("./log");
    private BufferedWriter logwriter;
    protected Statement statement = null;
    
    
    protected Base(){
        String sql;
        try{
            logwriter = new BufferedWriter(new FileWriter(logfile));
            
            
            getConnection();
            statement = connection.createStatement();
            sql="CREATE TABLE IF NOT EXISTS USER("
                    + "ID INT NOT NULL AUTO_INCREMENT,"
                    + "FIRSTNAME VARCHAR(25) NOT NULL,"
                    + "LASTNAME VARCHAR(25) NOT NULL,"
                    + "Username VARCHAR(25) NOT NULL,"
                    + "Password VARCHAR(25) NOT NULL,"
                    + "Created_At TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                    + "PRIMARY KEY(ID))";
            statement.addBatch(sql);
            statement.executeBatch();                                    
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }     
    @Override
    public final boolean getConnection() throws SQLException{              
       connection = DriverManager.getConnection(url, username, password);
        return true;
    }
    @Override
    public final boolean closeConnection() throws SQLException{
       // getConnection();
        if(!connection.isClosed()){
            connection.close();
        }       
        return true;
    }
    public  ArrayList<String> getDatabaseCredentials(){
    
    ArrayList<String>  database_details = new ArrayList<>();

    try{
       logwriter = new BufferedWriter(new FileWriter(logfile,true));

        File propertiesfile = new File("config.properties");
        input = new FileInputStream(propertiesfile);
        properties.load(input);
        database_details.add(properties.getProperty("database_username"));
        database_details.add(properties.getProperty("database_password"));
        database_details.add(properties.getProperty("database_name"));
        
    }catch(Exception ex){
        try {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            logwriter.append(ex.getMessage());
            logwriter.flush();
        } catch (IOException ex1) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }finally{
        if(input!=null){
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
    return database_details;
    
}
    
}
