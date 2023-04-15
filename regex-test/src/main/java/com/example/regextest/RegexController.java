package com.example.regextest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegexController {

    private RegexService regexService;

    public RegexController(RegexService regexService) {
        this.regexService = regexService;
    }

    @GetMapping(path = "/start")
    public void startRegexTest() {
        regexService.startTest();
    }
}
