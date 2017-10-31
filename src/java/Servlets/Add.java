package Servlets;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Add extends DispatcherServlets {  
     
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
                        
        try {
         
            String query = "INSERT INTO resurces "
              + "(fio, devaice, SN, stats, date, period)"            
              + " VALUES (?,?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("fio"));
            pst.setString(2,request.getParameter("devaice"));
            pst.setString(3,request.getParameter("SN"));
            pst.setString(4,request.getParameter("stats"));
            pst.setString(5,request.getParameter("date"));
            pst.setString(6,request.getParameter("period"));
            pst.executeUpdate();
            request.setAttribute("addComplit", "Запись успешно добавлена");
            super.forward("/main.jsp", request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }           
    
      
    
    

}
