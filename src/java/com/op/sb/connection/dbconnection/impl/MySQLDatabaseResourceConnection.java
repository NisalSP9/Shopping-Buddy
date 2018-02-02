/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.connection.dbconnection.impl;

import com.op.sb.connection.dbconnection.DBResourceConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLDatabaseResourceConnection implements DBResourceConnection{
    
      public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_buddy", "newuser", "newuser");

        return connection;

    }
    
}
