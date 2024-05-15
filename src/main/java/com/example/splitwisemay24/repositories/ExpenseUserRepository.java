package com.example.splitwisemay24.repositories;

import com.example.splitwisemay24.models.ExpenseUser;
import com.example.splitwisemay24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findByUser(User user);
}
