/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.connection.factory;

import com.op.sb.connection.dbconnection.DBResourceConnection;
import com.op.sb.connection.dbconnection.impl.MySQLDatabaseResourceConnection;


public class DatabaseResourceFactory {
    public static DBResourceConnection getFactoryConnection(){
    
        return new MySQLDatabaseResourceConnection();
    
    }
}
