package com.example.splitwisemay24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    List<ExpenseUser> expenseUsers;
}

// Expense ----- ExpenseUser
