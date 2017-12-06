package com.mnsuk.castudio.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ibm.talent.jfst.norm.AbstractStringNormalizer;
import com.ibm.talent.jfst.norm.JFSTNormalizerException;

public class GetDateTime extends AbstractStringNormalizer {
    private static final String defaultDateFormat = "yyyy-MM-dd";
	@Override
	public String normalize(String arg0, String[] arg1) throws JFSTNormalizerException {
		String dateFormat = arg1.length == 1 ? arg1[0] : defaultDateFormat;
		DateTimeFormatter formatter;
		try {
			formatter = DateTimeFormatter.ofPattern(dateFormat);
		} catch (IllegalArgumentException e) {
			formatter = DateTimeFormatter.ofPattern(defaultDateFormat);
		}
		return LocalDateTime.now().format(formatter);
	}	
}
