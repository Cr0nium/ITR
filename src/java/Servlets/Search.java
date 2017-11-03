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

public class Search extends DispatcherServlets {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
    String query;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
                        
        try {
         
            con = DriverManager.getConnection("jdbc:mysql://localhost/itr","root","Nbveh13");
            if(request.getParameter("fioSearch").equals("")) {
            query = "SELECT fio, device, id, SN, stats, date, period FROM resources "
                    + "WHERE device = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("deviceSearch"));
            } 
            else if(request.getParameter("deviceSearch").equals("Выберите устройство:")) {
            query = "SELECT fio, device, id, SN, stats, date, period FROM resources "
                    + "WHERE fio = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,request.getParameter("fioSearch"));
            }       
            else if((request.getParameter("deviceSearch")!=null) && (!request.getParameter("fioSearch").equals(""))) {
            query = "SELECT fio, device, id, SN, stats, date, period FROM resources "
                    + "WHERE fio = ? AND device = ?";
            pst = (PreparedStatement) con.prepareStatement(query);        
            pst.setString(1,request.getParameter("fioSearch"));
            pst.setString(2,request.getParameter("deviceSearch"));
            }
            rs = pst.executeQuery();
            
            List<Item> itemList = new ArrayList<Item>();
            while(rs.next()) {
            Item item = new Item();
               item.setFio(rs.getString("fio"));
               item.setDevice(rs.getString("device"));
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
    super.forward("/search.jsp", request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
   

}
