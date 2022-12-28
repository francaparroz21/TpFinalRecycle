package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    SupervisorService supervisorService;

    @PostMapping
    public Supervisor add_supervisor(@RequestBody Supervisor addSupervisor){
        return supervisorService.add_supervisor(addSupervisor);
    }

    @DeleteMapping("/{id}")
    public String delete_supervisor(@PathVariable("id") Long id){
        supervisorService.delete_supervisor(id);
        return "Supervisor deleted successfully";
    }

    @GetMapping
    public List<Supervisor> view_supervisors(){
        return supervisorService.view_supervisors();
    }
}
