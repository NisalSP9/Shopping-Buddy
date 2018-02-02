/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.service.Impl;

import com.op.sb.dao.AuthDAO;
import com.op.sb.dao.impl.AuthDAOImpl;
import com.op.sb.service.AuthService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author nisalsp9
 */
public class AuthServiceImpl implements AuthService{

    @Override
    public String postAuthCredentials(Connection connection, String username, String Password) throws SQLException, ClassNotFoundException {

        AuthDAO auth = new AuthDAOImpl();
        
        return auth.postAuthCredentials(connection, username, Password);

    }
    
}
