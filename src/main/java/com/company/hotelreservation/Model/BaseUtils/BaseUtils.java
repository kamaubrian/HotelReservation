/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.hotelreservation.Model.BaseUtils;
import java.sql.*;
/**
 *
 * @author John Gachoki
 */
public interface BaseUtils {
    public boolean getConnection() throws SQLException;
    public boolean closeConnection() throws SQLException;
}
