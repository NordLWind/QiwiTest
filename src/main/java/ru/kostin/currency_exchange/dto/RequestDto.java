package ru.kostin.currency_exchange.dto;

import lombok.Data;

@Data
public class RequestDto {
    private String valuteCode;
    private String date;
}
