package com.project.recycle.repository;

import com.project.recycle.model.Report;
import com.project.recycle.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>, PagingAndSortingRepository<Zone, Long> {
    Optional<Zone> findById(Long id);

    List<Zone> findAll();

}