package com.linyf.demo.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrosController {
    @GetMapping("/cros1")
    @ResponseBody
    public String getCros() {
        return "hello getCros1";
    }

    @PutMapping("/cros1")
    @ResponseBody
    public String putCros() {
        return "hello putCros1";
    }
}
