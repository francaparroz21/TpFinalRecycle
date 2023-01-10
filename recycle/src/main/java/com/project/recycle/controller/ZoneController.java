package com.project.recycle.controller;

import com.project.recycle.repository.ZoneRepository;
import com.project.recycle.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @Autowired
    ZoneRepository zoneRepository;

    @PostMapping
    public Zone addZone(@RequestBody Zone zone){
        return zoneService.addZone(zone);
    }

    @DeleteMapping("/{id}")
    public String deleteZone(@PathVariable("id") Long id){
        return zoneService.deleteZone(id);
    }

    @GetMapping
    public List<Zone> getAllZones(){
        return zoneService.getAllZones();
    }

    @GetMapping("/{id}")
    public Zone getZoneID(@PathVariable("id") Long id){
        return  zoneService.getZoneID(id);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable("id") Long id, @RequestBody Zone zone){
        return zoneService.updateZone(id, zone);
    }
}
