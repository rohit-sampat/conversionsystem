package com.conversion.system.conversionsystem.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conversion.system.conversionsystem.service.ConversionConvertorService;
import com.conversion.system.conversionsystem.service.LengthServiceImpl;
import com.conversion.system.conversionsystem.service.TemperatureServiceImpl;
import com.conversion.system.conversionsystem.service.WeightServiceImpl;

import static java.lang.String.format;

@Component
public class ConvertorFactory {

    private final TemperatureServiceImpl temperatureService;
    private final LengthServiceImpl lengthService;
    private final WeightServiceImpl weightService;

    @Autowired
    public ConvertorFactory(final TemperatureServiceImpl temperatureService,
                            final LengthServiceImpl lengthService,
                            final WeightServiceImpl weightService) {
        this.temperatureService = temperatureService;
        this.lengthService = lengthService;
        this.weightService = weightService;
    }

    /**
     * Input param type - the type of convertor required
     * return the correct convertor service (implementation is inside the service)
     *
     * throw RuntimeException which can occur if a type is being used without an appropriate Convertor being implemented
     */
    public ConversionConvertorService getConvertor(final ConversionType type) {
    	
    	if (ConversionType.TEMPERATURE.equals(type)) {
            return temperatureService;
        } else if (ConversionType.LENGTH.equals(type)) {
            return lengthService;
        }else if (ConversionType.WEIGHT.equals(type)) {
            return weightService;
        } else {
            throw new RuntimeException(format("Could not identify implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
