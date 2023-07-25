package ru.kostin.currency_exchange.converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DateConverter.class})
class DateConverterTest {

    @Autowired
    DateConverter subj;

    @Test
    void convert_ok() {
        assertEquals("01/02/1964", subj.convert("1964-02-01"));
    }

    @Test
    void convert_wrongDate() {
        assertThrows(IllegalArgumentException.class, () -> subj.convert("not-a-date"));
    }
}