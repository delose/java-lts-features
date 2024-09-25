package com.delose.java.lts.practice.machine_problems.todo_list.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.delose.java.lts.practice.machine_problems.todo_list.core.exception.TodoException;

public class TodoList {

    private List<TodoItem> todoItems;

    public TodoList() {
        this.setTodoItems();
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems() {
        if (todoItems == null) {
            todoItems = new ArrayList<>();
        }
    }

    public boolean addTodoItem(TodoItem todoItem) {
        if (todoItem.getDescription() == null) {
            throw new TodoException("Empty description is not allowed.");
        }

        return todoItems.add(todoItem);
    }

    @Override
    public String toString() {
        return todoItems
            .stream()
            .map(item -> item.getDescription().concat(": completed=" + item.isCompleted()))
            .collect(Collectors.joining("\n ", "*".repeat(5).concat("TodoList:\n"), "\n"));
    }

}
