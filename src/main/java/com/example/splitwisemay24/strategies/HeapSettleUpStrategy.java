package com.example.splitwisemay24.strategies;

import com.example.splitwisemay24.models.Expense;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //TODO
        return null;
    }
}
