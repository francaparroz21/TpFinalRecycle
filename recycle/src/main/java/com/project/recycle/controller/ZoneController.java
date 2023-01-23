package com.project.recycle.controller;

import com.project.recycle.model.*;
import com.project.recycle.service.ZoneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping
    @ApiOperation(value = "create a zone", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Zone> addZone(@RequestBody Zone zone){
        return new ResponseEntity<>(zoneService.addZone(zone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete a zone", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<String> deleteZone(@PathVariable("id") Long id){
        return ResponseEntity.ok(zoneService.deleteZone(id));
    }

    @GetMapping("/coords")
    @ApiOperation(value = "get a zone by coords", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<String>> getAllCoords(){
        return ResponseEntity.ok(zoneService.getAllCoords());
    }

    @GetMapping("/distance/{zone1}/{zone2}")
    @ApiOperation(value = "get the distance between two zones", authorizations = {@Authorization(value = "JWT")})
    public String distanceBetweenTwoZone(@PathVariable Long zone1, @PathVariable Long zone2){
        return zoneService.distanceBetweenTwoZones(zone1, zone2);
    }
    @GetMapping
    @ApiOperation(value = "get all zones", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<Zone>> getAllZones(){
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get zones by ID", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Zone> getZoneID(@PathVariable("id") Long id){
        return ResponseEntity.ok(zoneService.getZoneID(id));
    }

    @PutMapping("/{id}/{idSupervisor}")
    @ApiOperation(value = "update a zone", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Object> updateZone(@PathVariable("id") Long id,
                                             @PathVariable("idSupervisor") Long supervisorId, @RequestBody Zone zone){
        return ResponseEntity.ok(zoneService.updateZone(id, zone, supervisorId));
    }

    @GetMapping("/completed")
    @ApiOperation(value = "get fullfiled zones", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<String>> zonesComplete(){
        return ResponseEntity.ok(zoneService.zonesComplete());
    }

}
