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

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    public String distanceBetweenTwoZones(Long zone1, Long zone2){
        Zone zone_1 = zoneRepository.findById(zone1).get();
        Zone zone_2 = zoneRepository.findById(zone2).get();


        final int radius = 6371;
        Double latDistance = toRad(Double.valueOf(zone_2.getLatitude())-Double.valueOf(zone_1.getLatitude()));
        Double lonDistance = toRad(Double.valueOf(zone_2.getLongitude())-Double.valueOf(zone_1.getLongitude()));
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(Double.valueOf(zone_1.getLatitude()))) * Math.cos(toRad(Double.valueOf(zone_2.getLatitude()))) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return "distance between zona "+zone1+" and zona "+zone2+" of "+radius * c + "km";
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
