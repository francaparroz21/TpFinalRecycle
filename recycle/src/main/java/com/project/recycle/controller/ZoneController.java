package com.project.recycle.controller;

import com.project.recycle.model.Zone;
import com.project.recycle.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping
    public Zone addZone(@RequestBody Zone zone){
        return zoneService.addZone(zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable("id") Long id){
        zoneService.deleteZone(id);
    }
}
