/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.dao;

import com.op.sb.dto.UserDetailDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDetailDAO {

    public int addNewUser(Connection connection, UserDetailDTO user) throws SQLException, ClassNotFoundException;

    public ResultSet getUsers(Connection connection) throws ClassNotFoundException, SQLException;

    public boolean deleteUser(Connection connection, String userID) throws ClassNotFoundException, SQLException;

    public boolean editUser(Connection connection, UserDetailDTO user) throws SQLException, ClassNotFoundException;

}
