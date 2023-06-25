package com.conversion.system.conversionsystem.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.conversion.system.conversionsystem.util.ConversionFormulaConstValue;

@Service
public class LengthServiceImpl implements ConversionConvertorService {

    /**
     * This function is used to convert length from Imperial (Mile) into Metric (Kilometer)
     *
     * input param mileValue a length in Imperial unit (Mile)
     * return a Metric unit (Kilometer) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double mileValue) {
        return Precision.round(mileValue * ConversionFormulaConstValue.lengthVal, ConversionFormulaConstValue.roundOf);
    }

    /**
     * This function is used to convert length from Metric (Kilometer) into Imperial (Mile)
     * 
     * input param kilometerValue a length in Metric unit (Kilometer)
     * return an Imperial unit (Mile) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double kilometerValue) {
        return Precision.round(kilometerValue / ConversionFormulaConstValue.lengthVal, ConversionFormulaConstValue.roundOf);
    }
}