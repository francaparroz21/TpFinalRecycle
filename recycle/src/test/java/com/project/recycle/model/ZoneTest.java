package com.project.recycle.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    @Test
    void getZoneID() {
        Zone zone = new Zone();
        zone.setZoneID(1L);
        assertEquals(1L, zone.getZoneID());
    }

    @Test
    void setZoneID() {
        Zone zone = new Zone();
        zone.setZoneID(1L);
        assertEquals(1L, zone.getZoneID());
    }

    @Test
    void getLongitude() {
        Zone zone = new Zone();
        zone.setLongitude("3743483");
        assertEquals("3743483", zone.getLongitude());
    }

    @Test
    void setLongitude() {
        Zone zone = new Zone();
        zone.setLongitude("3743483");
        assertEquals("3743483", zone.getLongitude());
    }

    @Test
    void getLatitude() {
        Zone zone = new Zone();
        zone.setLatitude("3743483");
        assertEquals("3743483", zone.getLatitude());
    }

    @Test
    void setLatitude() {
        Zone zone = new Zone();
        zone.setLatitude("3743483");
        assertEquals("3743483", zone.getLatitude());
    }

    @Test
    void getClassification() {
        Zone zone = new Zone();
        zone.setClassification(Classification.GLASS);
        assertEquals("GLASS", zone.getClassification().toString());
    }

    @Test
    void setClassification() {
        Zone zone = new Zone();
        zone.setClassification(Classification.GLASS);
        assertEquals("GLASS", zone.getClassification().toString());
    }

    @Test
    void getUsedCapacityPercentage() {
        Zone zone = new Zone();
        zone.setUsedCapacityPercentage(78);
        assertEquals(78, zone.getUsedCapacityPercentage());
    }

    @Test
    void setUsedCapacityPercentage() {
        Zone zone = new Zone();
        zone.setUsedCapacityPercentage(78);
        assertEquals(78, zone.getUsedCapacityPercentage());
    }

    @Test
    void getSupervisorsID() {
        Zone zone = new Zone();
        zone.setSupervisorsID(List.of(1L,3L));
        assertEquals(List.of(1L,3L), zone.getSupervisorsID());
    }

    @Test
    void setSupervisorsID() {
        Zone zone = new Zone();
        zone.setSupervisorsID(List.of(1L,3L));
        assertEquals(List.of(1L,3L), zone.getSupervisorsID());
    }

    @Test
    void getReports() {
        Zone zone = new Zone();
        zone.setReports(List.of(new Report(), new Report()));
        assertEquals(2, zone.getReports().size());
    }

    @Test
    void setReports() {
        Zone zone = new Zone();
        zone.setReports(List.of(new Report(), new Report()));
        assertEquals(2, zone.getReports().size());
    }
}