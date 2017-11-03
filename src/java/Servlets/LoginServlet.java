package Servlets;

import ru.zalimov.User;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends DispatcherServlets {
    
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String login = request.getParameter("login");
       String password = request.getParameter("password");
       User user = new User();
       
       try {
         
            String query = "SELECT * FROM users WHERE userName = ?;";
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,login);
            rs = pst.executeQuery();
            
            if(rs.next()) {
            user.setUsername(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
       request.getSession().setAttribute("user", user);
       if((login.equals(user.getUsername())) && (password.equals(user.getPassword())) && ("ADMIN".equals(user.getRole()))) {
            super.forward("/main.jsp", request, response);
       } else if((login.equals(user.getUsername())) && (password.equals(user.getPassword()))) {
            super.forward("/main.jsp", request, response);
       } else {
       request.setAttribute("errorMessage", "Логин или пароль указаны неверно");
            super.forward("/index.jsp", request, response);
       }
        
    
       
    }

   
   
}
