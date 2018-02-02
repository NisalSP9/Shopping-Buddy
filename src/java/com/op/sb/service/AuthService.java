/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author nisalsp9
 */
public interface AuthService {
        public String postAuthCredentials(Connection connection, String username, String Password) throws SQLException, ClassNotFoundException;

}
