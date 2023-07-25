package ru.kostin.currency_exchange.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kostin.currency_exchange.dto.ValuteDto;
import ru.kostin.currency_exchange.entity.Valute;

@Component
public class ValuteToDtoConverter implements Converter<Valute, ValuteDto> {

    @Override
    public ValuteDto convert(Valute source) {
        return new ValuteDto()
                .setValue(source.getVal())
                .setName(source.getName())
                .setCode(source.getCharCode());
    }
}
