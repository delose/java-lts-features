package com.delose.java.lts.practice.machine_problems.todo_list.model.service.impl;

import java.util.List;

import com.delose.java.lts.practice.machine_problems.todo_list.core.exception.TodoException;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoItem;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoList;
import com.delose.java.lts.practice.machine_problems.todo_list.model.service.TodoService;

public class TodoServiceImpl implements TodoService {

    private TodoList todoList;

    public TodoServiceImpl() {
        this.todoList = new TodoList();
    }

    @Override
    public boolean addTodoItem(TodoItem item) {
        if (!item.getDescription().isBlank()) {
            return todoList.addTodoItem(item);
        }

        throw new TodoException("Todo description is empty");
    }

    @Override
    public TodoList viewTodoList() {
        return todoList;
        
    }

    @Override
    public boolean markTodoAsComplete(int index) {
        List<TodoItem> todoItems = this.todoList.getTodoItems();
        if (index > todoItems.size() - 1) {
            throw new TodoException("Invalid index for todo item. Please try again.");
        }
        
        TodoItem todoItem = this.todoList.getTodoItems().get(index);
        todoItem.setCompleted(true);
        return todoItem.isCompleted();
    }

}
