package com.akoydev.ebanking_backend.services;

import java.util.List;

import com.akoydev.ebanking_backend.dtos.AccountHistoryDTO;
import com.akoydev.ebanking_backend.dtos.AccountOperationDTO;
import com.akoydev.ebanking_backend.dtos.BankAccountDTO;
import com.akoydev.ebanking_backend.dtos.CurrentBankAccountDTO;
import com.akoydev.ebanking_backend.dtos.CustomerDTO;
import com.akoydev.ebanking_backend.dtos.SavingBankAccountDTO;
import com.akoydev.ebanking_backend.exceptions.BalanceNotSufficientException;
import com.akoydev.ebanking_backend.exceptions.BankAccountNotFoundException;
import com.akoydev.ebanking_backend.exceptions.CustomerNotFoundException;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccountDTO> bankAccountList();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<AccountOperationDTO> accountHistory(String accountId);
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
    List<CustomerDTO> searchCustomers(String keyword);

}
