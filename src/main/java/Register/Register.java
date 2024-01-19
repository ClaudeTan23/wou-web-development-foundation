package Register;

import java.io.IOException;
import java.security.*;
import java.sql.*;
import java.util.regex.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Repo.Sql;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("Register.jsp").forward(request, response);
//     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> Result = new HashMap<String, String>();
		
		String Username  = request.getParameter("username");
		String Password  = request.getParameter("password");
		String Email     = request.getParameter("email");
		String FirstName = request.getParameter("firstname");
		String LastName  = request.getParameter("lastname");
		
		String regex = "^(.+)@(.+)$";  
		
		if(Username.isEmpty() || Password.isEmpty() || Email.isEmpty() || FirstName.isEmpty() || LastName.isEmpty()) {
			
			Result.put("response", "Invalid Registration");
			request.setAttribute("Result", Result);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
				
			} else {
				
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(Email);  
				
			if(matcher.matches()) {
					
				Sql sqlConn = new Sql(Username, Password, Email, FirstName, LastName);
					
				try {
						
					if(sqlConn.ExistUsername()) {
							
						Result.put("response", "Username already existed");
							
						request.setAttribute("Result", Result);
						request.getRequestDispatcher("Register.jsp").forward(request, response);
							
					} else {
							
						if(sqlConn.Query()) {
							
							response.sendRedirect("/Assignment1/ThankYou");
							
						} else {
							
							Result.put("response", "Error");
							request.setAttribute("Result", Result);
							request.getRequestDispatcher("Register.jsp").forward(request, response);
						}
					}
						
				} catch (ClassNotFoundException | SQLException e) {
					
					Result.put("response", "Error");
					request.setAttribute("Result", Result);
					request.getRequestDispatcher("Register.jsp").forward(request, response);
					e.printStackTrace();
				}
					
			} else {
				
				Result.put("response", "Invalid Email");
				request.setAttribute("Result", Result);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				
			}
		}
		
//		System.out.println("asd");
	}

}
