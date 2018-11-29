package com.in28minutes.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list-todos.do")
public class ListTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("todos", todoService.retrieveTodos());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/list-todos.jsp");
		dispatcher.forward(request, response);
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		todoService.addTodo(new Todo(request.getParameter("todo")));
//		 the above line is equivalent to the following three lines
//		String value = request.getParameter("todo");
//		Todo todo = new Todo(value);
//		todoService.addTodo(todo);

//		request.setAttribute("todos", todoService.retrieveTodos());
//		request.getRequestDispatcher("WEB-INF/views/todo.jsp").forward(request, response);

//		to solve the duplicate servlet problem do following not the above code

//		response.sendRedirect("/todo.do");
//	}
}