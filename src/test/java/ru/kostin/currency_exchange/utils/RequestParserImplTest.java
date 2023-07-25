package ru.kostin.currency_exchange.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.kostin.currency_exchange.exception.BadRequestException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {RequestParserImpl.class})
class RequestParserImplTest {

    @Autowired
    RequestParserImpl subj;

    @Test
    void parseRequest_ok() {
        assertEquals("1964-01-01", subj.parseRequest("currency_rates --code=USD --date=1964-01-01").getDate());
        assertEquals("USD", subj.parseRequest("currency_rates --code=USD --date=1964-01-01").getValuteCode());
    }

    @Test
    void parseRequest_wrongCommand() {
        assertThrows(BadRequestException.class, () -> subj.parseRequest("wrong:)"));
    }
}