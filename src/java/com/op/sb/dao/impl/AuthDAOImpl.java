/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.dao.impl;

import com.op.sb.dao.AuthDAO;
import java.sql.Connection;
import java.sql.SQLException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

/**
 *
 * @author nisalsp9
 */
public class AuthDAOImpl implements AuthDAO {

    @Override
    public String postAuthCredentials(Connection connection, String username, String Password) throws SQLException, ClassNotFoundException {

        String JWT = null;

        // We need a signing key, so we'll create one just for this example. Usually
// the key would be read from your application configuration instead.
        Key key = MacProvider.generateKey();

        JWT = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return JWT;

    }

}
