package Servlets;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends DispatcherServlets {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
    String queryInc;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            queryInc = "SELECT userName FROM users "
                    + "WHERE userName = ?";
            pst = (PreparedStatement) con.prepareStatement(queryInc);
            pst.setString(1,request.getParameter("loginRegister"));
            rs = pst.executeQuery();
            int i=0;
            while (rs.next()){
             i++;
            }
            if (i==0) {
            
            String query = "INSERT INTO users "
              + "(userName, password, role)"            
              + " VALUES (?,?,'USER')";
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("loginRegister"));
            pst.setString(2,request.getParameter("passwordRegister"));
            pst.executeUpdate();
            super.forward("/index.jsp", request, response);
            } else {
            request.setAttribute("userRepeats", "Данный пользователь уже существует");
            super.forward("/index.jsp", request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
