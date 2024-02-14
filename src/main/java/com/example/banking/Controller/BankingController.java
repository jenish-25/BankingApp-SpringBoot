package com.example.banking.Controller;

import com.example.banking.Model.BankingData;
import com.example.banking.Service.BankingService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bank")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @PostMapping("open")
    public BankingData openAccount(@RequestBody BankingData bankingData){
        return bankingService.openAccount(bankingData);
    }

    @GetMapping("getAllDetails")
    public List<BankingData> getAllDetails(){
        return bankingService.getAllDetails();
    }

    @GetMapping("getById/{AccNum}")
    public Optional<BankingData> getById(@PathVariable Long AccNum ){
      return   bankingService.getById(AccNum);
    }

    @PutMapping("withdraw")
    public BankingData withdraw(@RequestParam long AccNum,@RequestParam Double amount){
        return bankingService.withdraw(AccNum,amount);
    }

    @PutMapping("deposit")
    public BankingData Deposite(@RequestParam Long AccNum,@RequestParam Double deposit){
        return bankingService.deposite(AccNum,deposit);
    }

    @PutMapping("transfer")
    public BankingData Transfer(@RequestParam Long AccNum1,@RequestParam Long AccNum2, @RequestParam Double money){
        return bankingService.Transfer(AccNum1,AccNum2,money);
    }

    @DeleteMapping("delet")
    public String deletAccount(@RequestParam Long AccNum){
        return bankingService.deletAccount(AccNum);
    }
}
