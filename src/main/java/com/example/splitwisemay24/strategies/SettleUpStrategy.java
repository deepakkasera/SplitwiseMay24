package com.example.splitwisemay24.strategies;

import com.example.splitwisemay24.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
