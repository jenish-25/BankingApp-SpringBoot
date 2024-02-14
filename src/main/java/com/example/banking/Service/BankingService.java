package com.example.banking.Service;

import com.example.banking.Model.BankingData;
import com.example.banking.Repository.BankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankingService {

    @Autowired
    BankingRepository bankingRepository;
    public BankingData openAccount(BankingData bankingData) {
        return bankingRepository.save(bankingData);
    }

    public List<BankingData> getAllDetails() {
        return bankingRepository.findAll();
    }

    public Optional<BankingData> getById(Long AccNum) {
        return bankingRepository.findById(AccNum);
    }

    public BankingData withdraw(Long AccNum,Double amount) {
        try {
            BankingData bankingData = bankingRepository.findById(AccNum).get();
            if (bankingData.getBalance() < amount) {
                throw new RuntimeException("not money");
            } else {
                bankingData.setBalance(bankingData.getBalance() - amount);
            }
            return bankingRepository.save(bankingData);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Processing Withdrawal");
        }
    }

    public BankingData deposite(Long AccNum, Double deposit) {
        try {
            BankingData bankingData = bankingRepository.findById(AccNum).get();
            double newBalance = bankingData.getBalance() + deposit;
            bankingData.setBalance(newBalance);
            return bankingRepository.save(bankingData);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Processing Deposit");
        }
    }

    public BankingData Transfer(Long accNum1, Long accNum2, Double money) {
        BankingData bankingData1=bankingRepository.findById(accNum1).get();
        BankingData bankingData2=bankingRepository.findById(accNum2).get();

        if(bankingData1.getBalance()>= money){
            withdraw(bankingData1.getAccNum(),money);
            deposite(bankingData2.getAccNum(),money);
        }
        else {
            System.out.println("Not enough balance");
        }
        return bankingData1;
    }
    public String deletAccount(Long AccNum) {
        BankingData bankingData=bankingRepository.findById(AccNum).get();
        bankingRepository.delete(bankingData);
        return "Delet Account number " + AccNum + " successFully";
    }
}
