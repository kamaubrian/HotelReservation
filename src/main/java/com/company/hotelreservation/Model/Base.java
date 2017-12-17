/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Model;
import com.company.hotelreservation.Model.BaseUtils.BaseUtils;
import java.io.File;
import java.io.FileInputStream;
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
    public static String username ="root"; //Username for XAMPP or WAMP mysql user
    public static String password ="wamatu"; //Password for the same
    public static String url = "jdbc:mysql://localhost:3306/HotelReservation?useSSL=false";
    protected PreparedStatement preparedStatement = null;
    protected Connection connection =null;
    protected ResultSet resultSet = null;
    InputStream input;
    protected Statement statement = null;
    
    
    protected Base(){
        String sql;
        try{
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
    public ArrayList<String> getDatabaseCredentials() throws IOException{
    
    ArrayList<String>  database_details = new ArrayList<>();
    
    try{
        File propertiesfile = new File("config.properties");
        input = new FileInputStream(propertiesfile);
        properties.load(input);
        database_details.add(properties.getProperty("database_name"));
        database_details.add(properties.getProperty("database_password"));
        database_details.add(properties.getProperty("database_username"));
        
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
        if(input!=null){
            input.close();
        }
    }
      
    return database_details;
    
}
    
}
