package com.conversion.system.conversionsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TemperatureServiceTest {

    @InjectMocks
    private TemperatureServiceImpl temperatureService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(TemperatureServiceTest.class);
    }

    @Test
    public  void when_degreesInFahrenheitSpecified_expectConversionToCelsius() {
        assertEquals(32.0, temperatureService.convertToImperial(0.00));
    }

    @Test
    public  void when_degreesInCelsiusSpecified_expectConversionToFahrenheit() {
    	assertEquals(32.00, temperatureService.convertToMetric(89.60));
    }
}
