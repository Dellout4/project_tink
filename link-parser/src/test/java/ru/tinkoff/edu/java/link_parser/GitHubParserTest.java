package ru.tinkoff.edu.java.link_parser;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.tinkoff.edu.java.link_parser.parsers.GitHubParser;
import ru.tinkoff.edu.java.link_parser.parsers.ParseChain;
import ru.tinkoff.edu.java.link_parser.parsers.Parser;
import ru.tinkoff.edu.java.link_parser.parsers.StackOverflowParser;
import ru.tinkoff.edu.java.link_parser.responses.GitHubParseResponse;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class GitHubParserTest {
    @ParameterizedTest(name = "{index} - {0} is a bad link")
    @NullAndEmptySource
    void linkIsNullOrEmpty_Null(String link) {
        // given

        // when
        GitHubParseResponse response = (GitHubParseResponse) new GeneralParseLink().start(link);

        // then
        assertNull(response);
    }

    @ParameterizedTest(name = "{index} - {0} is a bad link")
    @ValueSource(strings = {
        "https://github.com//project_tink/pull/3",
        "https://githb.com/Name/project_tink/pull/3",
        "https://githb.com",
        "https://githb.com/Name",
        "https://githb.com/Name/",
        "https://githb.com/Name//"
    })
    void invalidLink_Null(String link) {
        // given

        // when
        GitHubParseResponse response = (GitHubParseResponse) new GeneralParseLink().start(link);

        // then
        assertNull(response);
    }

    @ParameterizedTest(name = "{index} - {0} is a valid link")
    @ValueSource(strings = {
        "https://github.com/Dellout4/project_tink/pull/3",
        "https://github.com/Dellout4/project_tink/",
        "https://github.com/Dellout4/project_tink",
    })
    void validLink_OK(String link) {
        // given

        // when
        GitHubParseResponse response = (GitHubParseResponse) new GeneralParseLink().start(link);

        // then
        assertAll(
            () -> assertEquals(response.repo(), "project_tink"),
            () -> assertEquals(response.user(), "Dellout4")
        );
    }

    @ParameterizedTest()
    @ValueSource(strings = {
        "https://github.com/sanyarnd/tinkoff-java-course-2022",
        "https://github.com/sanyarnd/tinkoff-java-course-2022/blob/main/04/pom.xml",
    })
    void changeParserChain_OK(String link) {
        // given
        Parser parseChain = ParseChain.chain(new StackOverflowParser(), new GitHubParser());

        // when
        GitHubParseResponse response = (GitHubParseResponse) parseChain.parseUrl(Optional.ofNullable(link));

        // then
        assertAll(
            () -> assertEquals(response.user(), "sanyarnd"),
            () -> assertEquals(response.repo(), "tinkoff-java-course-2022")
        );
    }
}
