package com.akoydev.ebanking_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akoydev.ebanking_backend.entities.BankAccount;
import com.akoydev.ebanking_backend.entities.CurrentAccount;
import com.akoydev.ebanking_backend.entities.SavingAccount;
import com.akoydev.ebanking_backend.repositories.BankAccountRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BankService {
    
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("233e171c-ddf8-4a8b-92a5-e267dc405911").orElse(null);
        if(bankAccount!=null){
			System.out.println("********************************");
			System.out.println(bankAccount.getId());
			System.out.println(bankAccount.getBalance());
			System.out.println(bankAccount.getStatus());
			System.out.println(bankAccount.getCreatedAt());
			System.out.println(bankAccount.getCustomer().getName());

			if(bankAccount instanceof CurrentAccount){
				System.out.println("Over Draft=>"+((CurrentAccount)bankAccount).getOverDraft());
			} else if(bankAccount instanceof SavingAccount){
				System.out.println("Rate=>"+((SavingAccount)bankAccount).getInterestRate());
			}

			bankAccount.getAccountOperations().forEach(op->{
				System.out.println(op.getType()+"\t"+op.getOperationDate()+"\t"+op.getAmount());
			});
        }
    }

}
