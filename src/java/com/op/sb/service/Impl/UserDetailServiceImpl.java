/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.service.Impl;

import com.op.sb.dao.UserDetailDAO;
import com.op.sb.dao.impl.UserDetailDAOImpl;
import com.op.sb.dto.UserDetailDTO;
import com.op.sb.service.UserDetailService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nisalsp9
 */
public class UserDetailServiceImpl implements UserDetailService {

    @Override
    public int addNewUser(Connection connection, UserDetailDTO user) throws SQLException, ClassNotFoundException {

        UserDetailDAO userDAO = new UserDetailDAOImpl();

        return userDAO.addNewUser(connection, user);

    }

    @Override
    public ResultSet getUsers(Connection connection) throws ClassNotFoundException, SQLException {

        UserDetailDAO userDAO = new UserDetailDAOImpl();

        return userDAO.getUsers(connection);

    }

}
