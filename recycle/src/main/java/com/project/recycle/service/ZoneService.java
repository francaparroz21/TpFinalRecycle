package com.project.recycle.service;

import com.project.recycle.model.Zone;
import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
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

    public Object updateZone(Long id, Zone zone, Long supervisorId){
        Zone zoneSearch = zoneRepository.findById(id).get();

        if(zoneSearch.getSupervisorsID().contains(supervisorId)){
            if(zone.getLatitude() != null){
                zoneSearch.setLatitude(zone.getLatitude());
            }
            if(zone.getLongitude() != null){
                zoneSearch.setLongitude(zone.getLongitude());
            }
            if(zone.getClassification() != null){
                zoneSearch.setClassification(zone.getClassification());
            }
            if(zone.getZoneStatus() != null){
                zoneSearch.setZoneStatus(zone.getZoneStatus());
            }
            if(zone.getUsedCapacityPercentage() != 0){
                if(zone.getUsedCapacityPercentage() == 100){
                    zoneSearch.setFullFillDate(new Date());
                }
                zoneSearch.setUsedCapacityPercentage(zone.getUsedCapacityPercentage());
            }
            if(zone.getReports() != null){
                zoneSearch.setReports(zone.getReports());
            }
            return zoneRepository.save(zoneSearch);
        }

        return "Error: La zona no contiene ese supervisor ";
    }
}
