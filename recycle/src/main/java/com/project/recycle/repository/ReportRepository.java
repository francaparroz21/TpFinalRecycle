package com.project.recycle.repository;

import com.project.recycle.model.Report;
import com.project.recycle.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, PagingAndSortingRepository<Report, Long> {
    Optional<Report> findById(Long id);

    List<Report> findByDate(LocalDate Date);

    Optional<List<Report>> findByStatus(Status status);

    List<Report> findByZone(String zone);

    List<Report> findAll();

}