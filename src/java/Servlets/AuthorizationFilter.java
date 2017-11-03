package Servlets;

import ru.zalimov.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorizationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute("user");
        if((user != null) && (user.getRole().equals("ADMIN"))) {
        filterChain.doFilter(request, response);
        } else {
        httpResponse.sendRedirect("accessDenied.jsp");
        }
      }

    @Override
    public void destroy() {
        
    }
}
