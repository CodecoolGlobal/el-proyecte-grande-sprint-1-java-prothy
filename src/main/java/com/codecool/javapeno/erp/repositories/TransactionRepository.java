package com.codecool.javapeno.erp.repositories;

import com.codecool.javapeno.erp.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findAllByUserId(@Param("id") UUID id, Pageable pageable);

    Transaction findTopByUserIdOrderByTimestampDesc(@Param("id") UUID id);

    List<Transaction> findAllByTimestampBetweenAndUserId(@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo, UUID userId);

    @Query("select t from Transaction t where year(t.timestamp) = :year and month(t.timestamp) = :month")
    List<Transaction> findAllByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Query("select t from Transaction t where year(t.timestamp) = :year")
    List<Transaction> findAllByYear(@Param("year") Integer year);
}
