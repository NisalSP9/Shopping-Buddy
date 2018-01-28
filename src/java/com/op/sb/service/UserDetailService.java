/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.service;

import com.op.sb.dto.UserDetailDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nisalsp9
 */
public interface UserDetailService {
    
        public int addNewUser(Connection connection, UserDetailDTO user) throws SQLException, ClassNotFoundException;
        public ResultSet getUsers(Connection connection)throws ClassNotFoundException,SQLException;

    
}
