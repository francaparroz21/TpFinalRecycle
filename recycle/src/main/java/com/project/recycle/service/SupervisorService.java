package com.project.recycle.service;

import com.project.recycle.model.Supervisor;
import com.project.recycle.repository.SupervisorRepository;
import com.project.recycle.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    ZoneRepository zoneRepository;

    public List<Supervisor> getSupervisors(){
        return supervisorRepository.findAll();
    }
    public Supervisor getSupervisorEmail(String email){
        return supervisorRepository.findByEmail(email);
    }

    public Supervisor getSupervisorID(Long id){
        return supervisorRepository.findById(id).get();
    }

    public Supervisor addSupervisor(Supervisor supervisor){
        Supervisor supervisorSaved = supervisorRepository.save(supervisor);
        try {
            Zone zone = zoneRepository.findById(supervisor.getZoneInSupervision().getZoneID()).get();
            List<Long> listSupervisors = zone.getSupervisorsID();
            listSupervisors.add(supervisorSaved.getSupervisorID());
            zone.setSupervisorsID(listSupervisors);
            zoneRepository.save(zone);
        }catch (Exception e){}
        return supervisorRepository.save(supervisorSaved);
    }

    public String deleteSupervisor(Long id){
        supervisorRepository.deleteById(id);
        return "Supervisor deleted successfully";
    }



}
