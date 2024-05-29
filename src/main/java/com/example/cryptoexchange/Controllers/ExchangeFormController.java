package com.example.cryptoexchange.Controllers;

import com.example.cryptoexchange.Models.Transaction;
import com.example.cryptoexchange.Repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/ExchangeForm")
public class ExchangeFormController {
    private final String WalletBTC = "bc1qjuapk9knla5m7jwztm9v3zuuh2g4uzzy8cty5q";
    private final String WalletETH = "0xe8B0F57F8C96784b7b0DcB61C42Bd87B3CCC4B3e";
    private final String WalletUSDT = "TThfzq5ciAP2edwZfrZ7NZQAkj78yugN7R (TRC-20)";
    private final TransactionRepo transactionRepo;
    private Transaction currentTransaction;
    @Autowired
    public ExchangeFormController(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }
    @GetMapping
    public String exhangeForm() {
        return "exchangeForm";
    }

    @ModelAttribute(name = "transaction")
    public Transaction transaction() {return new Transaction();}
    @PostMapping
    public String processTransaction(@ModelAttribute Transaction transaction){
        if(transaction.getExchangeFromCurrency().equals("")){
            transaction.setExchangeFromCurrency("USDT");
        }
        currentTransaction = transaction;
        transactionRepo.save(transaction);
        return "redirect:/ExchangeForm/successfulRequest";
    }
    @GetMapping("/successfulRequest")
    public String successfulRequest(Model model) {
        double amount = currentTransaction.getAmountSell();
        model.addAttribute("amount", amount);
        String wallet = WalletUSDT;
        String currency = "USDT";
        double usd = currentTransaction.getAmountBuy();
        if(currentTransaction.getExchangeFromCurrency().equals("BTC")){
            wallet = WalletBTC;
            currency = "BTC";
        }
        else if(currentTransaction.getExchangeFromCurrency().equals("ETH")){
            wallet = WalletETH;
            currency = "ETH";
        }
        model.addAttribute("wallet", wallet);
        model.addAttribute("currency", currency);
        model.addAttribute("usd", usd);
        return "successfulRequest";
    }
}
