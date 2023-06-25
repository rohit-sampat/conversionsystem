package com.conversion.system.conversionsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeightServiceTest {

    @InjectMocks
    private WeightServiceImpl weightService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(WeightServiceTest.class);
    }
    @Test
    public void when_convertingAWeightInKilogram_expect_equivalentWeightInPound() {
        assertEquals(16.54, weightService.convertToImperial(7.5));
    }

    @Test
    public void when_convertingAWeightInPound_expect_equivalentWeightInKilogram() {
        assertEquals(5.53, weightService.convertToMetric(12.2));
    }

}
