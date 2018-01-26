/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.dao.impl;


import com.op.sb.dao.UserDetailDAO;
import com.op.sb.dto.UserDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nisalsp9
 */
public class UserDetailDAOImpl implements UserDetailDAO{
    
    String ADD_NEW_USER = "INSERT INTO user_details (name, age, home_address, office_address, mobile, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public int addNewUser(Connection connection, UserDetailDTO user) throws SQLException, ClassNotFoundException {

        PreparedStatement PS = connection.prepareStatement(ADD_NEW_USER);
        
        PS.setString(1, user.getName());
        PS.setInt(2, user.getAge());
        PS.setString(3, user.getHomeAddress());
        PS.setString(4, user.getOfficeAddress());
        PS.setString(5, user.getMobile());
        PS.setString(6, user.getPhone());
        PS.setString(7, user.getEmail());
        
        int RST = PS.executeUpdate();
        
        return RST;

    }
    
}
