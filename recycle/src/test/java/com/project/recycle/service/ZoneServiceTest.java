package com.project.recycle.service;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.ZoneRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
}