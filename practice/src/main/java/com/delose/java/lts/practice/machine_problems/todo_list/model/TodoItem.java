package com.delose.java.lts.practice.machine_problems.todo_list.model;

public class TodoItem {

    private String description;
    private boolean isCompleted;

    public TodoItem(String description) {
        this.description = description;
    }

    public TodoItem() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}
