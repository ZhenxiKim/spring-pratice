package com.example.mongomultitemplate.controller;

import com.example.mongomultitemplate.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;
    public void getData() {
        testService.getData();
    }
}
