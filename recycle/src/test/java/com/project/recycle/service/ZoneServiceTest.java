package com.project.recycle.service;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.ZoneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZoneServiceTest {

    @InjectMocks
    ZoneService zoneService;

    @Mock
    ZoneRepository zoneRepository;

    @Test
    void addZone() {
        Zone zone = new Zone("23123124", "42434324", Classification.GLASS, 89, List.of(1L,3L));
        when(zoneRepository.save(zone)).thenReturn(zone);

        Zone new_zone = zoneService.addZone(zone);

        assertEquals(new_zone, zone);
    }

    @Test
    void deleteZone(){
        Zone expected = new Zone(1L,"23123124", "42434324", Classification.GLASS, 89, List.of(1L,3L));
        when(zoneRepository.findById(1L)).thenReturn(Optional.of(expected)).thenReturn(null);
        String zone_deleted = zoneService.deleteZone(1L);
        Mockito.verify(zoneRepository, Mockito.times(1)).deleteById(1L);
        assertEquals(zone_deleted, "zone removed");
    }

    @Test
    void getViewAll() {
        when(zoneRepository.findAll()).thenReturn(
                List.of(new Zone("7373843", "4837483", Classification.GLASS, 56, List.of(2L,7L)),
                        new Zone("7373843", "4837483", Classification.GLASS, 56, List.of(1L,3L))));
        List<Zone> zones = zoneService.getAllZones();

        Assertions.assertNotNull(zones);
        Assertions.assertEquals(zones.size(), 2);
    }

    @Test
    void getZoneID() {
        Zone new_zone = new Zone(1L,"7373843", "4837483", Classification.GLASS, 56, List.of(2L,7L));
        when(zoneRepository.findById(1L)).thenReturn(Optional.of(new_zone));
        Zone zone = zoneService.getZoneID(1L);

        assertNotNull(zone);
        assertEquals(new_zone, zone);
    }


}