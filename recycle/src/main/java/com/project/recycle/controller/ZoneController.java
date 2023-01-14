package com.project.recycle.controller;

import com.project.recycle.model.*;
import com.project.recycle.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping
    public ResponseEntity<Zone> addZone(@RequestBody Zone zone){
        return new ResponseEntity<>(zoneService.addZone(zone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteZone(@PathVariable("id") Long id){
        return ResponseEntity.ok(zoneService.deleteZone(id));
    }

    @GetMapping
    public ResponseEntity<List<Zone>> getAllZones(){
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZoneID(@PathVariable("id") Long id){
        return ResponseEntity.ok(zoneService.getZoneID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable("id") Long id, @RequestBody Zone zone){
        return ResponseEntity.ok(zoneService.updateZone(id, zone));
    }
}
