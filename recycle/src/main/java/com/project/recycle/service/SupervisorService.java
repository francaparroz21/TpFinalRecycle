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

    public Supervisor add_supervisor(Supervisor supervisor){
        return supervisorRepository.save(supervisor);
    }

    public void delete_supervisor(Long id){
        supervisorRepository.deleteById(id);
    }

    public List<Supervisor> get_supervisors(){
        return supervisorRepository.findAll();
    }
    public Supervisor get_supervisor(Long id){
        return supervisorRepository.findById(id).get();
    }

}
