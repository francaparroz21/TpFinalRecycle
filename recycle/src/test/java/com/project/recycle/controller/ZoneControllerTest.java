package com.project.recycle.controller;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Zone;
import com.project.recycle.service.ZoneService;
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
}