package com.project.recycle.service;

import com.project.recycle.model.Supervisor;
import com.project.recycle.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    public Supervisor addSupervisor(Supervisor supervisor){
        return supervisorRepository.save(supervisor);
    }

    public String deleteSupervisor(Long id){
        supervisorRepository.deleteById(id);
        return "Supervisor deleted successfully";
    }

    public List<Supervisor> getSupervisors(){
        return supervisorRepository.findAll();
    }
    public Supervisor getSupervisor(String email){
        return supervisorRepository.findByEmail(email);
    }

}
