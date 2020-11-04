package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.TransactionsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SassTransactionRepository extends JpaRepository<TransactionsData, Long> {
    List<TransactionsData> findAllByStatus(String status);
    TransactionsData findAllByTransactionId(Long transactionId);
}
