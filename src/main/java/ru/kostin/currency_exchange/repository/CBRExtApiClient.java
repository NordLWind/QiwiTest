package ru.kostin.currency_exchange.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kostin.currency_exchange.entity.ValutesDto;

@Component
public class CBRExtApiClient implements ExtApiClient<ValutesDto> {
    private static final String URL = "http://www.cbr.ru/scripts/XML_daily.asp";

    @Override
    public ValutesDto getValFromExtApi(String params) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(URL + "?" + params, ValutesDto.class);
    }
}
