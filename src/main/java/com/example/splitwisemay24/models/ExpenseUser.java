package com.example.splitwisemay24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_users")
public class ExpenseUser extends BaseModel {
    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}

/*


   1                 1
ExpenseUser ----- Expense
   M                 1

   E1U1
   E1U2
   E1U3
 */