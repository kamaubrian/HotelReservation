/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Model;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John Gachoki
 */
public class BaseTest {
    
    public BaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class Base.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Base instance = new BaseImpl();
        boolean expResult = true;
        boolean result = instance.getConnection();
        assertEquals(expResult, result);

    }

    /**
     * Test of closeConnection method, of class Base.
     */
    @Test
    public void testCloseConnection() throws Exception {
        System.out.println("closeConnection");
        Base instance = new BaseImpl();
        boolean expResult = true;
        boolean result = instance.closeConnection();
        assertEquals(expResult, result);

    }
    @Test
    public void testConfigProperties() throws IOException{
        System.out.println("Test Get Configuration Files");
        Base instance = new BaseImpl();
        ArrayList<String> expectedresult = new ArrayList<>();
        String database_name = "HotelReservation";String password="wamatu";String username ="root";
        expectedresult.add(username);
        expectedresult.add(password);
        expectedresult.add(database_name);
        ArrayList<String> result = new ArrayList<>();
        result = instance.getDatabaseCredentials();
        assertEquals(expectedresult,result);
    }

    public class BaseImpl extends Base {
    }
    
}
