package ru.kostin.currency_exchange.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ValutesDto {
    @XmlElement(name = "Valute")
    private List<Valute> currencies;

    @XmlElement(name = "Date")
    private LocalDate date;
}
