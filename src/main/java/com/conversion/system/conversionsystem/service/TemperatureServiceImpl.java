package com.conversion.system.conversionsystem.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.conversion.system.conversionsystem.util.ConversionFormulaConstValue;

@Service
public class TemperatureServiceImpl implements ConversionConvertorService {

	//°C = [°F - 32] × (5/9)  I.E (32°F − 32) × 5/9 = °C
	// 32 Fahrenheit = 0 degree Celsius
    /**
     * This function is used to convert temperature from Imperial (Fahrenheit) into Metric (Celsius)
     *
     * input param fahrenheitValue a temperature in Imperial unit (Fahrenheit)
     * return a Metric unit (Celsius) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double fahrenheitValue) {
    	//Math.toRadians(fahrenheitValue);
    	//Math.floorDiv((fahrenheitValue - ConversionFormulaConstValue.temperatueConstVal), ConversionFormulaConstValue.temperatureVal);
        return Precision.round((fahrenheitValue - ConversionFormulaConstValue.temperatueConstVal) / ConversionFormulaConstValue.temperatureVal, 
        		ConversionFormulaConstValue.roundOf);
    }

    /**
     * This function is used to convert temperature from Metric (Celsius)
     * into Imperial (Fahrenheit)
     *
     * input param celsiusValue a temperature in Metric unit (Celsius)
     * return an Imperial unit (Fahrenheit) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double celsiusValue) {
        return Precision.round((celsiusValue * ConversionFormulaConstValue.temperatureVal) + ConversionFormulaConstValue.temperatueConstVal, 
        		ConversionFormulaConstValue.roundOf);
    }
}
