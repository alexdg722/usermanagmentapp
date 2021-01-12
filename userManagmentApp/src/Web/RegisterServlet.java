package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RegisterBean;
import Dao.RegisterDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
     }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.sendRedirect("register/register.jsp");
	}
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter out=response.getWriter();
    	 String fullname = request.getParameter("fullname");
    	 String username = request.getParameter("username");
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         String passwordconfirm = request.getParameter("passwordconfirm");
         String contactno = request.getParameter("contactno");
          
         RegisterBean registerBean = new RegisterBean();

         registerBean.setFullname(fullname);
         registerBean.setUsername(username);
         registerBean.setEmail(email);
         registerBean.setPassword(password);
         registerBean.setContactno(contactno); 
          
         RegisterDao registerDao = new RegisterDao();
         
         //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
          String userRegistered = null;
		try {
			if(passwordconfirm.equals(password))
				userRegistered = registerDao.register(registerBean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(passwordconfirm.equals(password))
		{
          if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
          { 
       
              request.getRequestDispatcher("login/login.jsp").include(request, response);
              out.println("<center><p>You have been registered succesfully.</p></center>");
          }
          		else   
          		{
          			request.getRequestDispatcher("Error.jsp").forward(request, response);
          			out.println("<center><p>OOPS...Something went wrong</p></center>");
          		}
         }
				else
				{
					request.getRequestDispatcher("register/register.jsp").include(request, response);
					out.println("<center><p>Passwords don't match.</p></center>");
				}
     }
        
     
}
