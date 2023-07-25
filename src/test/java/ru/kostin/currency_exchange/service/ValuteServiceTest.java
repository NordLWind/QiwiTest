package ru.kostin.currency_exchange.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.kostin.currency_exchange.converter.DateConverter;
import ru.kostin.currency_exchange.converter.ValuteToDtoConverter;
import ru.kostin.currency_exchange.exception.NoValCodeException;
import ru.kostin.currency_exchange.repository.ValutesRepo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
@ContextConfiguration(classes = {ValuteService.class, ValuteToDtoConverter.class})
class ValuteServiceTest {

    @MockBean
    ValutesRepo repo;

    @MockBean
    DateConverter dateConverter;

    @Autowired
    ValuteService subj;

    @Test
    void getValCourseForDate_wrongDate() {
        doThrow(IllegalArgumentException.class).when(dateConverter).convert("wrong");
        assertThrows(IllegalArgumentException.class, () -> subj.getValCourseForDate("USD", "wrong"));
    }

    @Test
    void getValCourseForDate_nullCode() {
        assertThrows(NoValCodeException.class, () -> subj.getValCourseForDate(null, "2020-01-01"));
    }
}