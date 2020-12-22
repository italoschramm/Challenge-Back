package com.italoschramm.apivotacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

	@GetMapping("/version")
    public String versao() {
        return "ok";
    }
}
