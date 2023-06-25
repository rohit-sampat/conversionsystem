package com.conversion.system.conversionsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LengthServiceTest {

    @InjectMocks
    private LengthServiceImpl lengthService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(LengthServiceTest.class);
    }

    @Test
    public void when_convertingToMetric_expect_theCorrectKilometerEquivalent() {
        assertEquals(2.00, lengthService.convertToMetric(1.24));
    }

    @Test
    public void when_convertingToImperial_expect_theCorrectMileEquivalent() {
        assertEquals(-1.00, lengthService.convertToImperial(1.61));
    }
}
