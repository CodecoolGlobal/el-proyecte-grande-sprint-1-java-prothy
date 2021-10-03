package com.codecool.javapeno.erp.repositories;

import com.codecool.javapeno.erp.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository("holidayRepository")
public interface HolidayRepository extends JpaRepository<Holiday, UUID> {
    List<Holiday> findAllByUserId(UUID id);

    @Query(value = """
    SELECT *
    FROM holiday
    WHERE user_id = ?1
    AND (date_from, date_to) OVERLAPS (?2, ?3)
        """, nativeQuery = true)
    List<Holiday> findAllByUserIdBetween(UUID user_id, LocalDate dateFrom, LocalDate dateTo);
}