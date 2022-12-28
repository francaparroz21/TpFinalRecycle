package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.repository.SupervisorRepository;
import com.project.recycle.service.SupervisorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class SupervisorControllerTest {
    @Autowired
    SupervisorRepository supervisorRepository;
    @Autowired
    SupervisorService supervisorService;

    @Test
    void add_supervisor(){
        Supervisor supervisor = new Supervisor("Valentino", "Giannico",
                "valen@gmail.com", "Alberdi", List.of("jsids", "djfidjfd"));
        Supervisor new_supervisor = supervisorService.add_supervisor(supervisor);
        Supervisor verSiExiste = supervisorRepository.findByEmail(new_supervisor.getEmail());
        Assertions.assertNotNull(verSiExiste);
    }

    @Test
    void delete_supervisor(){
        Supervisor supervisor = new Supervisor("Valentino", "Giannico",
                "valen@gmail.com", "Alberdi", List.of("jsids", "djfidjfd"));
        Supervisor new_supervisor_created = supervisorService.add_supervisor(supervisor);
        supervisorService.delete_supervisor(new_supervisor_created.getId());
        Assertions.assertNull(supervisorRepository.findByEmail(new_supervisor_created.getEmail()));
    }

    @Test
    void view_supervisors(){
        List<Supervisor> list_supervisors = new ArrayList<>(List.of(new Supervisor("Valentino", "Giannico",
                "valen@gmail.com", "Alberdi", List.of("jsids", "djfidjfd")),
                new Supervisor("Jorge", "Lopez",
                "jorge@gmail.com", "Guemes", List.of("jfdkfd", "eiwueiw"))));

        List<Supervisor> list_saved = supervisorRepository.saveAll(list_supervisors);
        List<Supervisor> list_repository = supervisorRepository.findAll();

        Assertions.assertEquals(list_saved.size(), list_repository.size());
    }

}