package com.project.recycle.controller;

import com.project.recycle.model.Classification;
import com.project.recycle.service.ZoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZoneControllerTest {

    @InjectMocks
    ZoneController zoneController;

    @Mock
    ZoneService zoneService;

    @Test
    void addZone() {
        Zone zone = new Zone("23123124", "42434324", Classification.GLASS, 89, List.of(1L,3L));
        when(zoneService.addZone(zone)).thenReturn(zone);

        Zone new_zone = zoneController.addZone(zone);

        assertEquals(new_zone, zone);
    }

    @Test
    void deleteZone() {
        Zone zone = new Zone("23123124", "42434324", Classification.GLASS, 89, List.of(1L,3L));
        when(zoneService.deleteZone(zone.getZoneID())).thenReturn("zone removed");

        String new_zone = zoneService.deleteZone(zone.getZoneID());

        assertEquals(new_zone, "zone removed");
    }

    @Test
    void getViewAll() {
        when(zoneService.getAllZones()).thenReturn(
                List.of(new Zone("7373843", "4837483", Classification.GLASS, 56, List.of(2L,7L)),
                        new Zone("7373843", "4837483", Classification.GLASS, 56, List.of(1L,3L))));
        List<Zone> zones = zoneController.getAllZones();

        Assertions.assertNotNull(zones);
        Assertions.assertEquals(zones.size(), 2);
    }

    @Test
    void getZoneID() {
        Zone new_zone = new Zone(1L,"7373843", "4837483", Classification.GLASS, 56, List.of(2L,7L));
        when(zoneService.getZoneID(1L)).thenReturn(new_zone);
        Zone zone = zoneController.getZoneID(1L);

        assertNotNull(zone);
        assertEquals(new_zone, zone);
    }
}