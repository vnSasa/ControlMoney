package com.control.money.demo.repository;

import com.control.money.demo.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    @Transactional
    List<Expenses> deleteByDate(Date date);
}
