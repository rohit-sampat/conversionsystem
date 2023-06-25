package com.conversion.system.conversionsystem.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.conversion.system.conversionsystem.util.ConversionFormulaConstValue;

@Service
public class WeightServiceImpl implements ConversionConvertorService {

	/**
     * This method is used to convert weight from Imperial (pound) into Metric (kilogram)
     *
     * input param pound Value a weight in Imperial unit (pound)
     * return a Metric unit (kilogram) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round(fromValue / ConversionFormulaConstValue.weightVal, ConversionFormulaConstValue.roundOf);
    }

    /**
     * This function is used to convert weight from Metric (kilogram) into Metric (pound)
     *
     * input param kilogram Value a temperature in Imperial unit (kilogram)
     * return a Metric unit (pound) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round(fromValue * ConversionFormulaConstValue.weightVal, ConversionFormulaConstValue.roundOf);
    }
}
