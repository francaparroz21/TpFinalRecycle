package com.project.recycle.repository;

import com.project.recycle.model.Report;
import com.project.recycle.model.ReportStatus;
import com.project.recycle.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, PagingAndSortingRepository<Report, Long> {
    Optional<Report> findById(Long id);

    List<Report> findByZone(Long zoneId);

    Optional<List<Report>> findByStatus(ReportStatus status);
    List<Report> findAll();

}