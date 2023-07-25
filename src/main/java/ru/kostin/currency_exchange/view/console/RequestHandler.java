package ru.kostin.currency_exchange.view.console;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostin.currency_exchange.dto.RequestDto;
import ru.kostin.currency_exchange.dto.ValuteDto;
import ru.kostin.currency_exchange.exception.BadRequestException;
import ru.kostin.currency_exchange.exception.ItemNotExistException;
import ru.kostin.currency_exchange.exception.NoValCodeException;
import ru.kostin.currency_exchange.service.ValuteService;
import ru.kostin.currency_exchange.utils.RequestParser;

@Service
@RequiredArgsConstructor
public class RequestHandler {
    private final ValuteService service;
    private final RequestParser<RequestDto> parser;

    public String handle(String request) {
        try {
            RequestDto requestDto = parser.parseRequest(request);
            ValuteDto valCourseForDate = service.getValCourseForDate(requestDto.getValuteCode(), requestDto.getDate());
            return valCourseForDate.getCode() + " (" + valCourseForDate.getName() + "): " + valCourseForDate.getValue();
        } catch (ItemNotExistException e) {
            return "no such valute!";
        } catch (BadRequestException e) {
            return "something wrong with request command!";
        } catch (NoValCodeException e) {
            return "no valute code mentioned!";
        }
    }
}
