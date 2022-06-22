import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.security.*;

public class MyServlet implements Filter {
	
    private FilterConfig filterConfig = null;
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;        
    }
    public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain)  throws IOException, ServletException 
    {    
        String password = ((HttpServletRequest) request).getParameter("password");
       
        if (password!=null && password.equals("test") ) {
            chain.doFilter(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Incorrect Password");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("<H1>Incorrect Password</H1>");
            out.println("Sorry, that password was incorrect.");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }
    public void destroy() {
    }
}

