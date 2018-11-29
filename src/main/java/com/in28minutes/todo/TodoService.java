package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo("Learn Web Application Development", "Study"));
		todos.add(new Todo("Learn Spring MVC", "Study"));
		todos.add(new Todo("learn Spring Rest services", "Study"));
	}

	public List<Todo> retrieveTodos() {
		return todos;
	}

	public boolean addTodo(Todo todo) {
		return todos.add(todo);
	}

	public boolean deleteTodo(Todo todo) {
		return todos.remove(todo);
	}

}
