package ru.tinkoff.edu.java.bot.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.dto.api.LinkUpdateRequest;

@RestController
@RequestMapping("/updates")
public class UpdateController {
    @PostMapping
    public void updateLink(@RequestBody LinkUpdateRequest request) {
    }

}
