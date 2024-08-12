package org.factoriaf5.zootopia.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ProfileTest {

    @Mock
    private User user;

    @Mock
    private Species species;

    @InjectMocks
    private Profile profile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        profile = new Profile("test@example.com", "123 Main St", user, species);
    }

    @Test
    void testGetId() {
        profile.setId(1L);
        assertEquals(1L, profile.getId());
    }

    @Test
    void testGetEmail() {
        assertEquals("test@example.com", profile.getEmail());
    }

    @Test
    void testSetEmail() {
        profile.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", profile.getEmail());
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Main St", profile.getAddress());
    }

    @Test
    void testSetAddress() {
        profile.setAddress("456 Another St");
        assertEquals("456 Another St", profile.getAddress());
    }

    @Test
    void testGetSpecie() {
        assertEquals(species, profile.getSpecie());
    }

    @Test
    void testSetSpecie() {
        Species newSpecies = mock(Species.class);
        profile.setSpecie(newSpecies);
        assertEquals(newSpecies, profile.getSpecie());
    }

}
