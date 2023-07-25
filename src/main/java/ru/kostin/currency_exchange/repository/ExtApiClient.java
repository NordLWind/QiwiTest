package ru.kostin.currency_exchange.repository;

import org.springframework.stereotype.Component;

@Component
public interface ExtApiClient<T> {
    T getValFromExtApi(String params);
}
