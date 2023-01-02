package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.model.Zone;
import com.project.recycle.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping
    public Zone addZone(@RequestBody Zone zone){
        return zoneService.addZone(zone);
    }

    @GetMapping("/{id}")
    public Zone getZoneID(@PathVariable("id") Long id){
        return zoneService.getZoneID(id);
    }

    @GetMapping
    public List<Zone> getZones(){
        return zoneService.getZones();
    }
}
