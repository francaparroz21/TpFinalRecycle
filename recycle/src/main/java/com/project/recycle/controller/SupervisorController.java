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
    public ResponseEntity<Supervisor> add_supervisor(@RequestBody Supervisor addSupervisor){
        return new ResponseEntity<>(supervisorService.add_supervisor(addSupervisor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete_supervisor(@PathVariable("id") Long id){
        supervisorService.delete_supervisor(id);
        return ResponseEntity.ok("Supervisor deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Supervisor>> get_supervisors(){
        return ResponseEntity.ok(supervisorService.get_supervisors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supervisor> get_supervisor(@PathVariable("id") Long id){
        return ResponseEntity.ok(supervisorService.get_supervisor(id));
    }
}
