package com.control.money.demo.service;

import com.control.money.demo.config.RestTemplateClient;
import com.control.money.demo.model.Expenses;
import com.control.money.demo.model.Result;
import com.control.money.demo.repository.ExpensesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;
    private final RestTemplate restTemplate;


    public ExpensesService(ExpensesRepository expensesRepository, RestTemplate restClient) {
        this.expensesRepository = expensesRepository;
        this.restTemplate = restClient;
    }

    public List<Expenses> findAll() {return expensesRepository.findAll();}

    public Expenses save(Expenses expenses) {return expensesRepository.save(expenses);}

    public List<Expenses> deleteByDate(Date date) {return expensesRepository.deleteByDate(date);}

    public double getTotal(String base) {
        double total = 0;
        List<Expenses> expenses = findAll();

        for(Expenses e : expenses) {
            String url_str = "https://api.exchangerate.host/convert?from=" + e.getCurrency() + "&to=" + base;
            Result result = restTemplate.getForObject(url_str,Result.class);
            total += result.getResult() * e.getAmount();
        }
        return total;
    }

    public long count() {return expensesRepository.count();}
}
