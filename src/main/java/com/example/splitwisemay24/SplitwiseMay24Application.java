package com.example.splitwisemay24;

import com.example.splitwisemay24.commands.CommandExecutor;
import com.example.splitwisemay24.commands.SettleUpUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ScopeMetadata;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseMay24Application {
    @Autowired
    private static CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseMay24Application.class, args);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();

            commandExecutor.execute(input);
        }
    }

}

/*

Settle Up requirement


Controller -> Service -> Repository

SettleUpController
SettleUpService
 */
