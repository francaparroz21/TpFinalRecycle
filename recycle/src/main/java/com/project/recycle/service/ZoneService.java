package com.project.recycle.service;

import com.project.recycle.model.Zone;
import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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

    public List<String> getAllCoords(){
        List<Zone> allZones = zoneRepository.findAll();
        List<String> allCoords = new ArrayList<>();
        for(Zone element: allZones){
            allCoords.add("Longitude: "+element.getLongitude()+" / Latitude: "+element.getLatitude());
        }
        return allCoords;
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
