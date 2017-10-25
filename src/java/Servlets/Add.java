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
    String fio;
    String devaice;
    String SN;
    String stats;
    String date;
    String period; 
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
        fio = request.getParameter("fio");
        devaice = request.getParameter("devaice");
        SN = request.getParameter("SN");
        stats = request.getParameter("stats");
        date = request.getParameter("date");
        period = request.getParameter("period"); 
                
        try {
         //   String query = "INSERT INTO resurces "
         //     + "(fio, devaice, SN, stats, date, period)"            
         //     + " VALUES (?,?,?,?,?,?)";
            String query = "INSERT INTO resurces "
              + "(fio, devaice, SN, stats, date, period)"            
              + " VALUES (?,?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,fio);
            pst.setString(2,devaice);
            pst.setString(3,SN);
            pst.setString(4,stats);
            pst.setString(5,date);
            pst.setString(6,period);
            pst.executeUpdate();
            
            super.forward("/main.jsp", request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }           
    
      
    
    

}
