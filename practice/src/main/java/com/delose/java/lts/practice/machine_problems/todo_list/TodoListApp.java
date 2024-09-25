package com.delose.java.lts.practice.machine_problems.todo_list;

import com.delose.java.lts.practice.machine_problems.todo_list.controller.TodoController;
import com.delose.java.lts.practice.machine_problems.todo_list.controller.impl.TodoControllerImpl;

public class TodoListApp {

    public static void main(String[] args) {

        TodoController todoController = new TodoControllerImpl();
        todoController.start();
        
    }
}
