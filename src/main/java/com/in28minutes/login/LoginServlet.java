package com.in28minutes.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.todo.TodoService;

/*Browser creates and sends http request to the web server
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginService userValidationService = new LoginService();
	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
//		response.getWriter() sends a PrintWriter Object which can send 
//		character text to the client
//
//		String x = " <!DOCTYPE html>" + "<html>" + "<head>" + "<title>Yahoo...</title>" + "</head>" + "<body>" + ""
//				+ "<h1>This is a Heading</h1>" + "<p>This is a paragraph.</p>" + "</body>" + "</html> ";
//		writer.println(x);

		String nameParameter = request.getParameter("name");// here "name" is the key of key value pair of parameter

		request.setAttribute("name", nameParameter);// here the "name" is name with which name it is accessed in jsp
		request.setAttribute("password", request.getParameter("password"));

//		remember that request.getParameter(arg0) not an request.getAttribute(arg0) Error Log

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");

		dispatcher.forward(request, response);

//		request.getRequestDispatcher("WEB-INF/views/login.jsp").include(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		request.setAttribute("name", name);
		boolean userValid = userValidationService.isUserValid(name, password);

		if (userValid) {
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/list-todos.do");

		} else {
			request.setAttribute("errorMessage", "UserName or Password is Wrong");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
