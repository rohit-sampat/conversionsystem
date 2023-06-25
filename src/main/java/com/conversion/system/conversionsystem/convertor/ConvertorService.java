package com.conversion.system.conversionsystem.convertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversion.system.conversionsystem.service.ConversionConvertorService;

@Service
public class ConvertorService {

    private final ConvertorFactory convertorFactory;

    public ConvertorService(final ConvertorFactory convertorFactory) {
        this.convertorFactory = convertorFactory;
    }

    /**
     * input param - measurement(eg temperature), toSystem (converted to imperial or metric) & inputVal - number of units to convert
     *
     * return the equivalent value of the converted unit of measurement
     *
     * throw RuntimeException if not Imperial nor Metric has been requested for
     */
    public ResponseEntity<String> convert(final String measurement, final String toSystem, final Double inputValue)
            throws IllegalArgumentException {
        Double convertedValue;
        HttpStatus status;

        if (inputValue != null && measurement != null && toSystem != null) {

            try {
                ConversionConvertorService convertor = this.getConvertor(measurement);

                switch (this.getSystemToConvertInto(toSystem)) {
                    case METRIC:
                        convertedValue = convertor.convertToMetric(inputValue);
                        break;
                    case IMPERIAL:
                        convertedValue = convertor.convertToImperial(inputValue);
                        break;
                    default:
                        throw new RuntimeException("Unknown Unit Type, the accepted inputs are "  +
                                SystemType.METRIC.name() + " and " + SystemType.IMPERIAL.name());
                }

                status = HttpStatus.OK;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        } else {
            convertedValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(String.valueOf(convertedValue), status);
    }

    private ConversionConvertorService getConvertor(final String measurement) {
        ConversionConvertorService convertor;

        try {
            convertor = convertorFactory.getConvertor(ConversionType.valueOf(measurement.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("You may only specify a known measurement such as: [" +
                    Arrays.stream(ConversionType.values()).map(ConversionType::name)
                            .collect(Collectors.joining(", ")) + "]");
        }

        return convertor;
    }

    private SystemType getSystemToConvertInto(final String system) throws IllegalArgumentException {
        SystemType systemType;

        try {
            systemType = SystemType.valueOf(system.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("You may only specify a known system such as [" +
                    SystemType.METRIC.name() + "] or [" + SystemType.IMPERIAL.name() + "]");
        }

        return systemType;
    }

    public ResponseEntity<List<String>> getMeasurements() {
        return new ResponseEntity<>(Arrays.stream(ConversionType.values()).map(ConversionType::name).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getSiUnits() {
        return new ResponseEntity<>(Arrays.stream(SystemType.values()).map(SystemType::name).collect(Collectors.toList()), HttpStatus.OK);
    }
}
