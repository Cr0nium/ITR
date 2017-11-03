package Servlets;

import ru.zalimov.Item;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Searche extends DispatcherServlets {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
    String query;

    
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
            if(request.getParameter("fioSearche").equals("")) {
            query = "SELECT fio, devaice, id, SN, stats, date, period FROM resurces "
                    + "WHERE devaice = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("devaiceSearche"));
            } 
            else if(request.getParameter("devaiceSearche").equals("Выберите устройство:")) {
            query = "SELECT fio, devaice, id, SN, stats, date, period FROM resurces "
                    + "WHERE fio = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("fioSearche"));
            }       
            else if((request.getParameter("devaiceSearche")!=null) && (!request.getParameter("fioSearche").equals(""))) {
            query = "SELECT fio, devaice, id, SN, stats, date, period FROM resurces "
                    + "WHERE fio = ? AND devaice = ?";
            pst = (PreparedStatement) con.prepareStatement(query);        
            pst.setString(1,request.getParameter("fioSearche"));
            pst.setString(2,request.getParameter("devaiceSearche"));
            }
            rs = pst.executeQuery();
            
            List<Item> itemList = new ArrayList<Item>();
            while(rs.next()) {
            Item item = new Item();
               item.setFio(rs.getString("fio"));
               item.setDevaice(rs.getString("devaice"));
               item.setId(rs.getInt("id"));
               item.setSN(rs.getString("SN"));
               item.setStats(rs.getString("stats"));
               item.setDate(rs.getString("date"));
               item.setPeriod(rs.getInt("period"));
               itemList.add(item);
            }
            request.setAttribute("itemlist", itemList);          
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } 
    super.forward("/searche.jsp", request, response);
    }

   
   

}
