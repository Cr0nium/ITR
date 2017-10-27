package Servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AuthFilter implements Filter{

        
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
          
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute("user");
    //    User user = new User();
     //   user.setUsername("Timur");
     //   user.setPassword("12345");
    //    user.setRole("ADMIN");
        
        if((user != null) && (user.getRole().equals("ADMIN"))) {
        filterChain.doFilter(request, response);
        } else {
        httpResponse.sendRedirect("accesDenied.jsp");
        }
        
      }

    @Override
    public void destroy() {
        
    }
    
}
