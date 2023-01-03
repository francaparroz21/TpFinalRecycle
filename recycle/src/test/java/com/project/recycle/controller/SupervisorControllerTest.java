package com.project.recycle.controller;

import com.project.recycle.model.Supervisor;
import com.project.recycle.service.SupervisorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SupervisorControllerTest {

    @Mock
    SupervisorService supervisorService;

    @InjectMocks
    SupervisorController supervisorController;

    @Test
    void add_supervisor() {
        Supervisor supervisor = new Supervisor("Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null);
        when(supervisorService.addSupervisor(supervisor)).thenReturn(supervisor);

        ResponseEntity<Supervisor> addSupervisor = supervisorController.addSupervisor(supervisor);

        assertEquals(supervisor, addSupervisor.getBody());
    }

    @Test
    void delete_supervisor() {
        Supervisor supervisor = new Supervisor(1L, "Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null);
        when(supervisorService.getSupervisorEmail("valen@gmail.com")).thenReturn(supervisor);
        HttpStatusCode messageDeleted = supervisorController.deleteSupervisor(1L).getStatusCode();

        assertEquals(messageDeleted, HttpStatusCode.valueOf(200));
    }

    @Test
    void get_supervisors(){
        when(supervisorService.getSupervisors()).thenReturn(List.of(
                new Supervisor("Valentino", "Giannico",
                        "valen@gmail.com", new Zone(), null),
                new Supervisor("Jorge", "Lopez",
                        "jorge@gmail.com", new Zone(), null)));
        ResponseEntity<List<Supervisor>> supervisors = supervisorController.getSupervisors();

        Assertions.assertNotNull(supervisors);
        Assertions.assertEquals(supervisors.getBody().size(), 2);
    }

    @Test
    void get_supervisor(){
        when(supervisorService.getSupervisorEmail("valen@gmail.com")).thenReturn(new Supervisor(1L, "Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null));
        ResponseEntity<Supervisor> getSupervisor = supervisorController.getSupervisorEmail("valen@gmail.com");

        Assertions.assertNotNull(getSupervisor);
    }
}