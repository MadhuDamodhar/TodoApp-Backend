package com.TodoApp.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.TodoApp.www.Model.TodoModel;
import com.TodoApp.www.Service.TodoService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/getAllTodos")
	public ResponseEntity<List<TodoModel>> getAllTodos(){
		return new ResponseEntity<List<TodoModel>>(todoService.getAllTodos(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addTodos")
	public ResponseEntity<TodoModel> addTodos(@RequestBody TodoModel todos){
		return new ResponseEntity<TodoModel>(todoService.addTodos(todos),HttpStatus.CREATED);
	}
	 
	@GetMapping("/getTodoById/{id}")
	public ResponseEntity<TodoModel> getTodoById(@PathVariable int id){
		return new ResponseEntity<TodoModel>(todoService.getTodoById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTodoById/{id}")
	public ResponseEntity<TodoModel> deleteTodoById(@PathVariable int id){
		return new ResponseEntity<TodoModel>(todoService.deleteTodoById(id),HttpStatus.OK);
	}
	@PostMapping("/updateTodoById/{id}")
	public ResponseEntity<TodoModel> updateTodoById(@PathVariable int id,@RequestBody TodoModel todo){
	return new ResponseEntity<TodoModel>(todoService.updateTodoById(id,todo),HttpStatus.OK);	
	}
	
}
