package com.akoydev.ebanking_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akoydev.ebanking_backend.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
    @Query("SELECT c FROM Customer c WHERE c.name LIKE :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);



    //("SELECT c FROM Customer c WHERE c.name LIKE %?1%")
    // List<Customer> findByNameContains(String keyword);
    // This query searches for customers whose names contain the keyword
    // The % wildcard allows for any characters before or after the keyword
    // Example: If keyword is "John", it will match "John Doe", "Doe John", etc.
    // If you want to search by other fields, you can modify the query
    // accordingly, e.g., searching by email or phone number.
    // You can also use Spring Data JPA's method naming conventions to achieve similar results.
    
}
