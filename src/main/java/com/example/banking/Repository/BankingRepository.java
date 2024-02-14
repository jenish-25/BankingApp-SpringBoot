package com.example.banking.Repository;

import com.example.banking.Model.BankingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<BankingData,Long> {

}
