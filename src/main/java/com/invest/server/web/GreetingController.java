package com.invest.server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 초기 컨트롤러 테스트 용
 * @version 0.1
 * @author Jeon Jihoon
 */

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "Greeting! Server";
    }
}
