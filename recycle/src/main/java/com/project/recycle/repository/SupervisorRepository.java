package com.project.recycle.repository;

import com.project.recycle.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    Supervisor findByEmail(String email);

    List<Supervisor> findByZoneInSupervision(Zone zone);
}
