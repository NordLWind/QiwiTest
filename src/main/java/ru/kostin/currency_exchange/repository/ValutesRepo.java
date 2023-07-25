package ru.kostin.currency_exchange.repository;

import org.springframework.stereotype.Repository;
import ru.kostin.currency_exchange.entity.ValutesDto;

@Repository
public interface ValutesRepo {
    ValutesDto getValutesForDate(String date);
}
