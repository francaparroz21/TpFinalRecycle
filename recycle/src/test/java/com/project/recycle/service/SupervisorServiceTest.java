package com.project.recycle.service;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Supervisor;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.SupervisorRepository;
import com.project.recycle.repository.ZoneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class SupervisorServiceTest {
    @Mock
    ZoneRepository zoneRepository;
    @Mock
    SupervisorRepository supervisorRepository;
    @InjectMocks
    SupervisorService supervisorService;
    @Test
    void add_supervisor(){
        Zone zone = new Zone(1L,"545454", "w3343434", Classification.GLASS, 76, null);
        Supervisor supervisor = new Supervisor("Valentino", "Giannico",
                "valen@gmail.com", zone, null);
        when(supervisorRepository.save(supervisor)).thenReturn(supervisor);
        Supervisor new_supervisor = supervisorService.addSupervisor(supervisor);
        Assertions.assertEquals(new_supervisor.getEmail(), supervisor.getEmail());
    }

    @Test
    void delete_supervisor(){
        Supervisor supervisor = new Supervisor(1L, "Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null);
        when(supervisorRepository.findById(1L)).thenReturn(Optional.of(supervisor));
        String result = supervisorService.deleteSupervisor(2L);
        Assertions.assertEquals(result, "Supervisor deleted successfully");
    }

    @Test
    void get_supervisors(){
        when(supervisorRepository.findAll()).thenReturn(List.of(
                new Supervisor("Valentino", "Giannico",
                        "valen@gmail.com", new Zone(), null),
                new Supervisor("Jorge", "Lopez",
                        "jorge@gmail.com", new Zone(), null)));
        List<Supervisor> supervisors = supervisorService.getSupervisors();
        Assertions.assertNotNull(supervisors);
        Assertions.assertEquals(supervisors.size(), 2);
    }

    @Test
    void getSupervisorEmail() {
        when(supervisorRepository.findByEmail("valen@gmail.com")).thenReturn(new Supervisor(1L, "Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null));
        Supervisor getSupervisor = supervisorService.getSupervisorEmail("valen@gmail.com");
        Assertions.assertNotNull(getSupervisor);
    }

    @Test
    void getSupervisorID() {
        when(supervisorRepository.findById(1L)).thenReturn(Optional.of(new Supervisor(1L, "Valentino", "Giannico",
                "valen@gmail.com", new Zone(), null)));
        Supervisor getSupervisor = supervisorService.getSupervisorID(1L);
        Assertions.assertNotNull(getSupervisor);
    }
}