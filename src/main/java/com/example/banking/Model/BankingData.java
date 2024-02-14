package com.example.banking.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "bank_details")
public class BankingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AccNum;
    private String name;
    private Double balance;
}
