package com.conversion.system.conversionsystem.web;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversion.system.conversionsystem.convertor.ConvertorService;

@RestController
@RequestMapping(value = "/change")
public class ConversionResource {

    private final ConvertorService convertorService;

    @Autowired
    public ConversionResource(final ConvertorService convertorService) {
        this.convertorService = convertorService;
    }

    @RequestMapping(value = "/{measurement}/{toSystem}/{value}", method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<String> convert(@PathVariable final String measurement, @PathVariable final String toSystem, @PathVariable final Double value) {
    //	HttpRequest request = 
        return convertorService.convert(measurement, toSystem, value);
    }

}
