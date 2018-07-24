package com.cg.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.wallet.beans.Customer;



public interface Dao extends JpaRepository<Customer, String> {

}
