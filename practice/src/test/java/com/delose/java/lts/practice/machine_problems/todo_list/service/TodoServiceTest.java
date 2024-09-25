package com.delose.java.lts.practice.machine_problems.todo_list.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.delose.java.lts.practice.machine_problems.todo_list.core.exception.TodoException;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoItem;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoList;
import com.delose.java.lts.practice.machine_problems.todo_list.model.service.TodoService;
import com.delose.java.lts.practice.machine_problems.todo_list.model.service.impl.TodoServiceImpl;

public class TodoServiceTest {

    private TodoService todoService;

    @BeforeEach
    public void setup() {
        todoService = new TodoServiceImpl();
    }

    @Nested
    @DisplayName("Successful Todo operations")
    class SuccesScenario {

        TodoItem todoItem;

        TodoList todoList;

        @BeforeEach
        public void setup() {
            todoItem = new TodoItem("Eat breakfast");
            todoList = new TodoList();
        }

        @Test
        public void givenValidTodoItem_whenAddTodoItem_thenReuturnTrue() {
            //given
            
            //when
            boolean isAdded = todoService.addTodoItem(todoItem);

            //then
            assertTrue(isAdded);
        }

        @Test
        public void givenTodoListIsNotEmpty_whenViewTodoList_thenReturnTodoListWithTodoItem() {
            //given
            todoItem = new TodoItem("Eat breakfast");
            todoService.addTodoItem(todoItem);
            
            //when
            todoList = todoService.viewTodoList();
            
            //then
            assertTrue(todoList.getTodoItems().size() > 0);

        }

        @Test
        public void givenTodoItemIsDone_whenMarkComplete_thenTodoItemIsCompletedSetToTrue() {
            //given
            TodoItem todoItem1 = new TodoItem("Swim in the pool");
            TodoItem todoItem2 = new TodoItem("Go to gym");
            todoService.addTodoItem(todoItem1);
            todoService.addTodoItem(todoItem2);

            //when
            todoService.markTodoAsComplete(1);

            //then
            assertFalse(todoService.viewTodoList().getTodoItems().get(0).isCompleted());
            assertTrue(todoService.viewTodoList().getTodoItems().get(1).isCompleted());

        }
    
    }

    @Nested
    @DisplayName("Unsuccessful Todo operations")
    class UnsuccesScenario {
        @Test
        public void givenTodoListIsEmpty_whenMarkAsComplete_thenThrowTodoException() {
            //given
            //when & then
            Assertions.assertThrows(TodoException.class, () -> todoService.markTodoAsComplete(0));
        }
    }

}
