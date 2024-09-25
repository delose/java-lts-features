package com.delose.java.lts.practice.machine_problems.todo_list.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.delose.java.lts.practice.machine_problems.todo_list.core.exception.TodoException;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoItem;
import com.delose.java.lts.practice.machine_problems.todo_list.model.TodoList;

public class TodoListTest {

    @Nested
    @DisplayName("Successful Todo operations")
    class SuccesScenario {

        @Test
        public void givenTodoListIsEmpty_whenGetTodoList_thenReturnEmptyTodoItems() {
            //given
            TodoList todoList = new TodoList();
    
            //when
            List<TodoItem> todoItems = todoList.getTodoItems();
    
            //then
            Assertions.assertEquals(List.of(), todoItems);
        }
    
        @Test
        public void givenValidTodoItem_whenAddTodoItem_thenReturnTrue() {
            //given
            TodoList todoList = new TodoList();
            TodoItem todoItem = new TodoItem("Drink water");
    
            //when
            todoList.addTodoItem(todoItem);
    
            //then
            Assertions.assertTrue(todoList.getTodoItems().size() > 0);
        }
    
    }

    @Nested
    @DisplayName("Unsuccessful Todo operations")
    class UnsuccesScenario {
        @Test
        public void givenInvalidTodoItem_whenAddTodoItem_thenThrowTodoException() {
            //given
            TodoList todoList = new TodoList();
            TodoItem todoItem = new TodoItem();

            // when & then
            Assertions.assertThrows(TodoException.class,
                () -> todoList.addTodoItem(todoItem));
        }
    }
}
