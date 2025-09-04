package com.akoydev.ebanking_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akoydev.ebanking_backend.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
