package ru.kostin.currency_exchange.utils;

import org.springframework.stereotype.Component;
import ru.kostin.currency_exchange.dto.RequestDto;
import ru.kostin.currency_exchange.exception.BadRequestException;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestParserImpl implements RequestParser<RequestDto> {

    @Override
    public RequestDto parseRequest(String request) {

        if (!request.startsWith("currency_rates")) {
            throw new BadRequestException();
        }

        RequestDto res = new RequestDto();
        Map<String, String> attribs = new HashMap<>();

        getAttribs(request, attribs);

        for (Map.Entry<String, String> entry : attribs.entrySet()) {
            if (entry.getKey().equals("code")) {
                res.setValuteCode(entry.getValue().trim());
            } else if (entry.getKey().equals("date")) {
                res.setDate(entry.getValue().trim());
            }
        }
        return res;
    }

    private void getAttribs(String request, Map<String, String> map) {
        for (String s : request.substring(request.indexOf("--") + 2).split("--")) {
            map.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1));
        }
    }
}
