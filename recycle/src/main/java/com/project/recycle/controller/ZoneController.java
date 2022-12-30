package com.project.recycle.controller;

import com.project.recycle.model.Zone;
import com.project.recycle.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping
    public Zone addZone(){
        Zone zone = new Zone("120.7784","-75.8978",null,79, List.of(1L,2l));
        return zoneService.addZone(zone);
    }
}
