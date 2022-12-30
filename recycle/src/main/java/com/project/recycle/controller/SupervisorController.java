package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.service.SupervisorService;
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

    @PostMapping
    public ResponseEntity<Supervisor> addSupervisor(@RequestBody Supervisor addSupervisor){
        return new ResponseEntity<>(supervisorService.addSupervisor(addSupervisor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupervisor(@PathVariable("id") Long id){
        supervisorService.deleteSupervisor(id);
        return ResponseEntity.ok(supervisorService.deleteSupervisor(id));
    }

    @GetMapping
    public ResponseEntity<List<Supervisor>> getSupervisors(){
        return ResponseEntity.ok(supervisorService.getSupervisors());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Supervisor> getSupervisor(@PathVariable("email") String email){
        return ResponseEntity.ok(supervisorService.getSupervisor(email));
    }

}
