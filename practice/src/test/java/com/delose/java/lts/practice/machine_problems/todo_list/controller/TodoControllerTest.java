package com.delose.java.lts.practice.machine_problems.todo_list.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.delose.java.lts.practice.machine_problems.todo_list.controller.TodoController;
import com.delose.java.lts.practice.machine_problems.todo_list.controller.impl.TodoControllerImpl;

public class TodoControllerTest {
    
    private TodoController todoController;

    @BeforeEach
    public void setup() {
        todoController = new TodoControllerImpl();
    }
    
    @Nested
    @DisplayName("Success Scenarios")
    class SuccessScenarios {
        
        @Test
        @Disabled
        public void testStart() {
            Assertions.assertDoesNotThrow(() -> todoController.start());
        }

    }
}
