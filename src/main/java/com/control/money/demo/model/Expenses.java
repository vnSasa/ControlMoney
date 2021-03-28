package com.control.money.demo.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private double amount;
    private String currency;
    private String product;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Expenses() {

    }

    public Expenses(Date date,
                    double amount,
                    String currency,
                    String product) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}

    public String getProduct() {return product;}
    public void setProduct(String product) {this.product = product;}

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", date=" + date +
                ",amount=" + amount +
                ",currency=" + currency +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return Double.compare(expenses.amount, amount) == 0 &&
                Objects.equals(id, expenses.id) &&
                Objects.equals(date, expenses.date) &&
                Objects.equals(currency, expenses.currency) &&
                Objects.equals(product, expenses.product);
    }

    @Override
    public int hashCode() {return Objects.hash(id, date, amount, currency,product);
    }

}
