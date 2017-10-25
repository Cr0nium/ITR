
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StartServlet extends DispatcherServlets {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("Add") != null)super.forward("/Add", request, response);
        else if(request.getParameter("Delete") != null)super.forward("/Delete", request, response);
        else if(request.getParameter("Update") != null)super.forward("/Update", request, response);
    }

    
    

}
