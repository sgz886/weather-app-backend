package com.fiona.weatherapp.controller;

import org.apache.logging.log4j.util.Strings;
import java.util.Locale;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryCodeValidator implements ConstraintValidator<ISO3166CountryCode, String> {

    private static final Set<String> ISO_COUNTRY_CODES = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Strings.isNotEmpty(value) && ISO_COUNTRY_CODES.contains(value.toUpperCase());
    }
}
