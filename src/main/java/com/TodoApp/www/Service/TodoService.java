package com.TodoApp.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TodoApp.www.Model.TodoModel;
import com.TodoApp.www.Repo.TodoRepository;

@Service
public class TodoService {
	@Autowired
	TodoRepository todoRepository;
	
	public List<TodoModel> getAllTodos() {
		return todoRepository.findAll();
	}
	
	
	public TodoModel addTodos(TodoModel todos) {
		return todoRepository.save(todos);
	}
	
	
	public TodoModel getTodoById(int id) {
		return todoRepository.findById(id).get();
	}
	
	public TodoModel deleteTodoById(int id) {
		TodoModel Todo=todoRepository.findById(id).get();
		if(Todo!=null) {
			todoRepository.delete(Todo);
			return Todo;
		}
		else {
			return null;
		}
	}
	
	public TodoModel updateTodoById(int id,TodoModel todo) {
		TodoModel oldTodo=todoRepository.findById(id).get();
		if(oldTodo!=null) {
			oldTodo.setId(todo.getId());
			oldTodo.setTask(todo.getTask());
			oldTodo.setDescription(todo.getDescription());
			return todoRepository.save(oldTodo);
		}
		else {
			return null;
		}
	}
}
