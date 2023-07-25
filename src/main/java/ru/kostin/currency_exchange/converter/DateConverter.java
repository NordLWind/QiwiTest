package ru.kostin.currency_exchange.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, String> {
    @Override
    public String convert(String source) {
        String[] parts = source.split("-");
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
}
