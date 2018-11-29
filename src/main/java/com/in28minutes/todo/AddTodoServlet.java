package com.in28minutes.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/add-todo.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		todoService.addTodo(new Todo(request.getParameter("todo"), category));
//		 the above line is equivalent to the following three lines
//		String value = request.getParameter("todo");
//		Todo todo = new Todo(value);
//		todoService.addTodo(todo);

//		request.setAttribute("todos", todoService.retrieveTodos());
//		request.getRequestDispatcher("WEB-INF/views/todo.jsp").forward(request, response);

//		to solve the duplicate servlet problem do following not the above code

		response.sendRedirect("/list-todos.do");
	}
}