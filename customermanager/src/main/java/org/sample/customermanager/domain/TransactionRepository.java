package org.sample.customermanager.domain;


import org.springframework.data.repository.CrudRepository;

/**
 * 특정고객관리 TransactionRepository
 * @author 이승호
 * @version 1.0
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
