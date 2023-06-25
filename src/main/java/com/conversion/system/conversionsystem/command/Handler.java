package com.conversion.system.conversionsystem.command;

import com.conversion.system.conversionsystem.service.ConversionConvertorService;

// NOT USING THIS PATTERN RIGHT NOW
// WANTED TO IMPLIMENT command patter for nested IF-ELSE
public interface Handler {
	ConversionConvertorService apply();
}
