package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.repository.ZoneRepository;
import com.project.recycle.service.SupervisorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    SupervisorService supervisorService;

    @Autowired
    ZoneRepository zoneRepository;

    @PostMapping
    @ApiOperation(value = "create a supervisor", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Supervisor> addSupervisor(@RequestBody Supervisor addSupervisor){
        return new ResponseEntity<>(supervisorService.addSupervisor(addSupervisor), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete a supervisor", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<String> deleteSupervisor(@PathVariable("id") Long id){
        supervisorService.deleteSupervisor(id);
        return ResponseEntity.ok(supervisorService.deleteSupervisor(id));
    }

    @GetMapping
    @ApiOperation(value = "get all supervisors", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<Supervisor>> getSupervisors(){
        return ResponseEntity.ok(supervisorService.getSupervisors());
    }

    @GetMapping("/email/{email}")
    @ApiOperation(value = "get supervisors by email", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Supervisor> getSupervisorEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(supervisorService.getSupervisorEmail(email));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get supervisors by id", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Supervisor> getSupervisorID(@PathVariable("id") Long id){
        return ResponseEntity.ok(supervisorService.getSupervisorID(id));
    }

}
