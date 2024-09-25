package com.delose.java.lts.practice.machine_problems.todo_list.model.service;

import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoItem;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoList;

public interface TodoService {

    boolean addTodoItem(TodoItem item);

    TodoList viewTodoList();

    boolean markTodoAsComplete(int index);


}
