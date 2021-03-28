package com.control.money.demo.controller;

import com.control.money.demo.model.Expenses;
import com.control.money.demo.service.ExpensesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ExpensesController {

    private final ExpensesService expensesService;
    private final RestTemplate restClient;

    public ExpensesController(ExpensesService expensesService, RestTemplate restClient) {
        this.expensesService = expensesService;
        this.restClient = restClient;
    }

    @GetMapping("/expenses")
    public Map<Date, List<Expenses>> showAll() {
        List<Expenses> list = expensesService.findAll();
        Map<Date, List<Expenses>> map = list
                .stream()
                .collect(Collectors.groupingBy(Expenses::getDate));
        return map;
    }

    @PostMapping("/expenses")
    public Expenses save(@RequestBody Expenses expenses) {
        expenses.setId(expensesService.count());
        return expensesService.save(expenses);
    }

    @DeleteMapping("/expenses")
    public List<Expenses> deleteByDate(@RequestParam("date")
                                           @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Expenses> deleteExpenses = new ArrayList<>();
        deleteExpenses = expensesService.deleteByDate(date);
        return deleteExpenses;
    }

    @GetMapping("/total")
    public Map<String, Object> getTotal(@RequestParam String base) {

        double total = expensesService.getTotal(base);

        Map<String, Object> map = new HashMap<>();

        map.put("total", total);

        return map;
    }
}
