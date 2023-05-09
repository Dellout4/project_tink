package ru.tinkoff.edu.java.link_parser.parsers;

import java.util.Optional;
import ru.tinkoff.edu.java.link_parser.responses.BaseParseResponse;

public sealed abstract class BaseParser implements Parser permits GitHubParser, StackOverflowParser {
    private Parser successor;

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    protected BaseParseResponse nextParse(Optional<String> url) {
        return successor != null ? successor.parseUrl(url) : null;
    }
}
