package com.eh.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String username) {
        String ticketName = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return username + " 购买了" + ticketName;
    }
}
