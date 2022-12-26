package com.project.recycle.Service;

import com.project.recycle.Model.Supervisor;
import com.project.recycle.Repository.SupervisorRepository;
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

    public List<Supervisor> view_supervisors(){
        return supervisorRepository.findAll();
    }
}
