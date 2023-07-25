package ru.kostin.currency_exchange.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kostin.currency_exchange.entity.ValutesDto;

@Repository
@RequiredArgsConstructor
public class ValutesRepoImpl implements ValutesRepo {
    private final ExtApiClient<ValutesDto> client;

    @Override
    public ValutesDto getValutesForDate(String date) {
        return client.getValFromExtApi("?date_req=" + date);
    }
}
