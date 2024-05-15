package com.example.splitwisemay24.services;

import com.example.splitwisemay24.exceptions.UserNotFoundException;
import com.example.splitwisemay24.models.Expense;
import com.example.splitwisemay24.models.ExpenseUser;
import com.example.splitwisemay24.models.User;
import com.example.splitwisemay24.repositories.ExpenseUserRepository;
import com.example.splitwisemay24.repositories.UserRepository;
import com.example.splitwisemay24.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        /*
        1. Get the user with the given userId from DB.
        2. Get all the expenses in which this user is involved.
        3. Iterate through all the expenses and find out who has paid extra/lesser
        for every user involved in the above list of expenses.
        4. Use Min Heap and Max Heap to find out the list of transactions required to
        settle up the user.
         */
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id - " + userId + " not found");
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        // Convert a set into list.
        List<Expense> expensesToSettleUp = expenses.stream().toList();

        //Heap Algorithm to settle up the list of expenses.
        List<Expense> finalExpenses = settleUpStrategy.settleUp(expensesToSettleUp);

        return finalExpenses;
    }

    public List<Expense> settleUpGroup(Long groupId) {
         /*
        1. Get the group with the given groupId from DB.
        2. Get all the expenses with in this group.
        3. Iterate through all the expenses and find out who has paid extra/lesser
        for every user involved in the above list of expenses.
        4. Use Min Heap and Max Heap to find out the list of transactions required to
        settle up the user.
         */

        return null;
    }
}


/*
 Expense(E) -> Dinner

 u1, u2, u3, u4

 PaidBy <E, U1, 800> <E, U3, 1200>
 HadToPay <E, U1, 500> <E, U2, 500>  <E, U3, 500>  <E, U4, 500>


 settleUp -> u3

 Get all the expenseUsers in which u3 is involved.
 <E, U3, 1200>
 <E, U3, 500>
 */
