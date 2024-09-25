package com.delose.java.lts.practice.machine_problems.todo_list.controller.impl;

import java.util.Scanner;

import com.delose.java.lts.practice.machine_problems.todo_list.controller.TodoController;
import com.delose.java.lts.practice.machine_problems.todo_list.core.constants.Messages;
import com.delose.java.lts.practice.machine_problems.todo_list.core.exception.TodoException;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoItem;
import com.delose.java.lts.practice.machine_problems.todo_list.model.service.TodoService;
import com.delose.java.lts.practice.machine_problems.todo_list.model.service.impl.TodoServiceImpl;
import com.delose.java.lts.practice.machine_problems.todo_list.view.MenuView;
import com.delose.java.lts.practice.machine_problems.todo_list.view.impl.MenuViewImpl;

import java.util.InputMismatchException;

public class TodoControllerImpl implements TodoController {

    private MenuView menuView;
    private TodoService todoService;
    private Scanner scanner;

    public TodoControllerImpl() {
        this.menuView = new MenuViewImpl();
        this.todoService = new TodoServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        
        while (true) {
            try {
                this.menuView.displayNewline(" #".repeat(10));
                this.menuView.displayInline(Messages.DISPLAY_START);
                
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        this.menuView.displayNewline(todoService.viewTodoList().toString());
                        break;
                    case 2:
                        scanner.nextLine();
                        this.menuView.displayInline(Messages.GIVE_TODO_DESCRIPTION);
                        String description = scanner.nextLine();
                        TodoItem todoItem = new TodoItem(description);
                        todoService.addTodoItem(todoItem);
                        this.menuView.displayNewline("Todo item added successfully!");
                        break;
                    case 3:
                        scanner.nextLine();
                        this.menuView.displayInline(Messages.GIVE_TODO_INDEX);
                        int index = scanner.nextInt();
                        todoService.markTodoAsComplete(index);
                        String todoDescription = todoService.viewTodoList().getTodoItems().get(index).getDescription();
                        this.menuView.displayNewline("Todo: '".concat(todoDescription).concat("'is marked as complete!"));
                        break;
                    case 4:
                        this.menuView.displayInline(Messages.DISPLAY_END);
                        scanner.close();
                        return;
                    default:
                        this.menuView.displayNewline("Invalid choice");
                }
            } catch (IllegalStateException | InputMismatchException | TodoException e) {
                this.menuView.displayNewline("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }

}
