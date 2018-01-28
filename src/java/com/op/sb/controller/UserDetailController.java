/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.controller;

import com.op.sb.connection.factory.DatabaseResourceFactory;
import com.op.sb.dto.UserDetailDTO;
import com.op.sb.service.Impl.UserDetailServiceImpl;
import com.op.sb.service.UserDetailService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author nisalsp9
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection connection = DatabaseResourceFactory.getFactoryConnection().getConnection();

            UserDetailService service = new UserDetailServiceImpl();

            ResultSet resultSet = service.getUsers(connection);

            JSONArray jSONArray = new JSONArray();

            while (resultSet.next()) {

                JSONObject json = new JSONObject();

                json.put("user_id", resultSet.getInt(1));
                json.put("name", resultSet.getString(2));
                json.put("age", resultSet.getInt(3));
                json.put("home", resultSet.getString(4));
                json.put("office", resultSet.getString(5));
                json.put("mobile", resultSet.getString(6));
                json.put("phone", resultSet.getString(7));
                json.put("email", resultSet.getString(8));

                jSONArray.put(json);

            }

            PrintWriter out = response.getWriter();

            out.print(jSONArray);

            connection.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BufferedReader reader = request.getReader();

            JSONObject jsonObject = new JSONObject(reader.readLine());

            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            String home = jsonObject.getString("home");
            String office = jsonObject.getString("office");
            String mobile = jsonObject.getString("mobile");
            String phone = jsonObject.getString("phone");
            String email = jsonObject.getString("email");

            UserDetailDTO user = new UserDetailDTO(0, name, age, home, office, mobile, phone, email);

            Connection connection = DatabaseResourceFactory.getFactoryConnection().getConnection();

            UserDetailService service = new UserDetailServiceImpl();

            boolean rst = 0 < service.addNewUser(connection, user);

            connection.close();

            if (rst) {

                PrintWriter pw = response.getWriter();
                pw.print("Saved....!");

            } else {

                PrintWriter pw = response.getWriter();
                pw.print("Something went wrong....!");

            }

        } catch (JSONException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("JSONException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("ClassNotFoundException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("SQLException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        try {
            BufferedReader reader = req.getReader();

            JSONObject jsonObject = new JSONObject(reader.readLine());

            String id = jsonObject.getString("user_id");

            Connection connection = DatabaseResourceFactory.getFactoryConnection().getConnection();

            UserDetailService service = new UserDetailServiceImpl();

            service.deleteUser(connection, id);
            connection.close();
        }  catch (JSONException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("JSONException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("ClassNotFoundException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("SQLException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        try {
            BufferedReader reader = req.getReader();

            JSONObject jsonObject = new JSONObject(reader.readLine());

            int user_id = jsonObject.getInt("user_id");
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            String home = jsonObject.getString("home");
            String office = jsonObject.getString("office");
            String mobile = jsonObject.getString("mobile");
            String phone = jsonObject.getString("phone");
            String email = jsonObject.getString("email");

            UserDetailDTO user = new UserDetailDTO(user_id, name, age, home, office, mobile, phone, email);

            Connection connection = DatabaseResourceFactory.getFactoryConnection().getConnection();

            UserDetailService service = new UserDetailServiceImpl();

            boolean rst = service.editUser(connection, user);

            if (rst) {

                PrintWriter pw = response.getWriter();
                pw.print("Updated....!");

            } else {

                PrintWriter pw = response.getWriter();
                pw.print("Something went wrong....!");

            }

        } catch (JSONException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("JSONException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("ClassNotFoundException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            PrintWriter pw = response.getWriter();
            pw.print("SQLException occurred....! Read log for more infor");
            Logger.getLogger(UserDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
