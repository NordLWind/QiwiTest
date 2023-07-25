package ru.kostin.currency_exchange.utils;

public interface RequestParser<T> {
    T parseRequest(String request);
}
