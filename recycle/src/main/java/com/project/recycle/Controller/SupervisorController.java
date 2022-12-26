package com.project.recycle.Controller;

import com.project.recycle.Model.Supervisor;
import com.project.recycle.Service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/recycle/supervisor")
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
