package ru.kostin.currency_exchange.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DateConverter implements Converter<String, String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    @Override
    public String convert(String source) {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        format.setLenient(true);
        try {
            format.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        String[] parts = source.split("-");
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
}
