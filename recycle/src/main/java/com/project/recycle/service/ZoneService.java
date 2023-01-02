package com.project.recycle.service;

import com.project.recycle.model.Supervisor;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.SupervisorRepository;
import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    SupervisorRepository supervisorRepository;

    public Zone addZone(Zone zone){
        return zoneRepository.save(zone);
    }
    public Zone getZoneID(Long id){
        return zoneRepository.findById(id).get();
    }

    public List<Zone> getZones(){
        return zoneRepository.findAll();
    }
}
