package com.TodoApp.www.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TodoApp.www.Model.TodoModel;
@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Integer> {

}
