package com.alan.curso.springboot_webapp.controllers;

import com.alan.curso.springboot_webapp.dto.ParamDto;
import com.alan.curso.springboot_webapp.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    //    @Value("${config.message}")
//    private String message;
    @Value("${config.listOfValue}")
    private List<String> listOfValue;
    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listOfValue}'.toUpperCase.split(',') }")
    private List<String> valueList;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{ ${config.valuesMap}.product}")
    private String product;
    @Value("#{ ${config.valuesMap}.price}")
    private String price;

    @Value("#{ '${config.listOfValue}'}")
    private String valueString;


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValue", listOfValue);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valueMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
}
