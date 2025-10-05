package com.ofss.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// Here, Bank is the entity class and Integer is the data type
// of the primary key
@Repository
public interface BankRepository extends CrudRepository<Bank, Integer>{

}
