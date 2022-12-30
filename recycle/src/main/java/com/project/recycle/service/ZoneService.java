package com.project.recycle.service;

import com.project.recycle.model.Zone;
import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    public Zone addZone(Zone zone){
        return zoneRepository.save(zone);
    }
}
