package com.project.recycle.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupervisorTest {

    @Test
    void getSupervisorID() {
        Supervisor supervisor = new Supervisor();
        supervisor.setSupervisorID(1L);
        assertEquals(1L, supervisor.getSupervisorID());
    }

    @Test
    void setSupervisorID() {
        Supervisor supervisor = new Supervisor();
        supervisor.setSupervisorID(1L);
        assertEquals(1L, supervisor.getSupervisorID());
    }

    @Test
    void getFirstName() {
        Supervisor supervisor = new Supervisor();
        supervisor.setFirstName("Jorge");
        assertEquals("Jorge", supervisor.getFirstName());
    }

    @Test
    void setFirstName() {
        Supervisor supervisor = new Supervisor();
        supervisor.setFirstName("Jorge");
        assertEquals("Jorge", supervisor.getFirstName());
    }

    @Test
    void getLastName() {
        Supervisor supervisor = new Supervisor();
        supervisor.setLastName("Lopez");
        assertEquals("Lopez", supervisor.getLastName());
    }

    @Test
    void setLastName() {
        Supervisor supervisor = new Supervisor();
        supervisor.setLastName("Lopez");
        assertEquals("Lopez", supervisor.getLastName());
    }

    @Test
    void getEmail() {
        Supervisor supervisor = new Supervisor();
        supervisor.setEmail("jorge@gmail.com");
        assertEquals("jorge@gmail.com", supervisor.getEmail());
    }

    @Test
    void setEmail() {
        Supervisor supervisor = new Supervisor();
        supervisor.setEmail("jorge@gmail.com");
        assertEquals("jorge@gmail.com", supervisor.getEmail());
    }

    @Test
    void getZoneInSupervision() {
        Supervisor supervisor = new Supervisor();
        supervisor.setZoneInSupervision(new Zone());
        assertEquals(new Zone().getZoneID(), supervisor.getZoneInSupervision().getZoneID());
    }

    @Test
    void setZoneInSupervision() {
        Supervisor supervisor = new Supervisor();
        supervisor.setZoneInSupervision(new Zone());
        assertEquals(new Zone().getZoneID(), supervisor.getZoneInSupervision().getZoneID());
    }

    @Test
    void getReports() {
        Supervisor supervisor = new Supervisor();
        supervisor.setReports(List.of("The containers are broken"));
        assertEquals(List.of("The containers are broken"), supervisor.getReports());
    }

    @Test
    void setReports() {
        Supervisor supervisor = new Supervisor();
        supervisor.setReports(List.of("The containers are broken"));
        assertEquals(List.of("The containers are broken"), supervisor.getReports());
    }
}