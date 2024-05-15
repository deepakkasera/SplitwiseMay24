package com.example.splitwisemay24.commands;

import java.util.List;

public class SettleUpGroupCommand implements Command {
    @Override
    public void execute(String input) {

    }

    @Override
    public boolean matches(String input) {

        List<String> words = List.of(input.split(" "));

        return words.size() == 3 && words.get(1).equals("SettleUp");
    }
}
