package com.alan.curso.springboot_webapp.controllers;

import com.alan.curso.springboot_webapp.dto.ParamDto;
import com.alan.curso.springboot_webapp.dto.ParamDtoMix;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola mundo", name = "mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message != null ? message : "Sin datos");
        return param;
    }

    @GetMapping("/bar")
    public ParamDtoMix bar(@RequestParam() String text, @RequestParam Integer code) {
        ParamDtoMix params = new ParamDtoMix();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamDtoMix request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {

        }
        ParamDtoMix params = new ParamDtoMix();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
}
