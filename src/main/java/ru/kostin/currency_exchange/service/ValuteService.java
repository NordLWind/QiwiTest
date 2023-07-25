package ru.kostin.currency_exchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.kostin.currency_exchange.converter.DateConverter;
import ru.kostin.currency_exchange.dto.ValuteDto;
import ru.kostin.currency_exchange.entity.Valute;
import ru.kostin.currency_exchange.entity.ValutesDto;
import ru.kostin.currency_exchange.exception.ItemNotExistException;
import ru.kostin.currency_exchange.exception.NoValCodeException;
import ru.kostin.currency_exchange.repository.ValutesRepo;

@Service
@RequiredArgsConstructor
public class ValuteService {
    private final ValutesRepo repo;
    private final Converter<Valute, ValuteDto> converter;
    private final DateConverter dateConverter;

    public ValuteDto getValCourseForDate(String code, String date) {
        if (code == null) {
            throw new NoValCodeException();
        }
        ValutesDto valutes = repo.getValutesForDate(dateConverter.convert(date));
        for (Valute v : valutes.getCurrencies()) {
            if (v.getCharCode().equals(code)) {
                return converter.convert(v);
            }
        }
        throw new ItemNotExistException();
    }
}
