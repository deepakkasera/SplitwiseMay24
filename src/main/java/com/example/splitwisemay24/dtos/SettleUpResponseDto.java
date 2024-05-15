package com.example.splitwisemay24.dtos;

import com.example.splitwisemay24.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    private List<Expense> expenses;
    private ResponseStatus responseStatus;
}
