package com.project.recycle.service;

import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    public Zone addZone(Zone zone){
        return zoneRepository.save(zone);
    }

    public String deleteZone(Long id){
        zoneRepository.deleteById(id);
        return "zone removed";
    }

    public List<Zone> getAllZones(){
        return zoneRepository.findAll();
    }

    public Zone getZoneID(Long id){
        return zoneRepository.findById(id).get();
    }

    public Zone updateZone(Long id, Zone zone){
        Zone zoneSearch = zoneRepository.findById(id).get();
        if(zone.getClassification() != null){
            zoneSearch.setClassification(zone.getClassification());
        }
        if(zone.getUsedCapacityPercentage() != 0){
            zoneSearch.setUsedCapacityPercentage(zone.getUsedCapacityPercentage());
        }
        return zoneRepository.save(zoneSearch);
    }
}
