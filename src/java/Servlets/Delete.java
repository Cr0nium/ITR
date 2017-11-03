package Servlets;

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


public class Delete extends DispatcherServlets {
   
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            
            String query = "DELETE FROM resources WHERE id = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("id"));
            pst.executeUpdate();
            request.setAttribute("deleteComplit", "Запись успешно удалена");
            super.forward("/main.jsp", request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("deleteFail", "Возникла ошибка при удалении записи");
            super.forward("/main.jsp", request, response);
        }
    }
       
}
