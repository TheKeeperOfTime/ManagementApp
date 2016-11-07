package org.elevenfifty.managementapp.repository;

import org.elevenfifty.managementapp.beans.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
