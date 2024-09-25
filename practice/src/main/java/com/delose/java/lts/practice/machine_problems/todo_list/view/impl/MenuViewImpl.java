package com.delose.java.lts.practice.machine_problems.todo_list.view.impl;

import com.delose.java.lts.practice.machine_problems.todo_list.view.MenuView;

public class MenuViewImpl implements MenuView {

    @Override
    public void displayInline(String message) {
        System.out.print(message);
    }
    @Override
    public void displayNewline(String message) {
        System.out.println(message);
    }
}
