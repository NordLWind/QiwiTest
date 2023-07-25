package ru.kostin.currency_exchange.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "valute")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Valute {

    @XmlElement(name = "NumCode")
    private String numCode;

    @XmlElement(name = "CharCode")
    private String charCode;

    @XmlElement(name = "Nominal")
    private String nom;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    private String val;
}
