package com.example.splitwisemay24.commands;

public interface Command {
    void execute(String input);

    boolean matches(String input);
}
