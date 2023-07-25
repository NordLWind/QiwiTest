package ru.kostin.currency_exchange.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ValuteDto {
    private String code;
    private String name;
    private String value;
}
