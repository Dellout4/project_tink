package ru.tinkoff.edu.java.bot.logic.utils;

import java.net.URI;
import ru.tinkoff.edu.java.bot.exceptions.InvalidLinkException;

public class LinkValidation {
    private LinkValidation() {}

    public static URI validate(String link) throws InvalidLinkException {
        try {
            return URI.create(link);
        } catch (Exception e) {
            throw new InvalidLinkException("Введенная строка не является ссылкой");
        }
    }
}
