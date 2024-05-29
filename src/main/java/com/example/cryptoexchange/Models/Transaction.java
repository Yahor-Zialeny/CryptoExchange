package com.example.cryptoexchange.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String exchangeFromCurrency;
    private double amountSell;
    private double amountBuy;
    private String iban;
    private Date createdAt = new Date();
}
