package com.damo.bootmall.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("action", "hello");
        map.put("name", name);
        return map;
    }

    @RequestMapping("/divide/{d1}/{d2}")
    public String divide(@PathVariable Double d1, @PathVariable Double d2) throws Exception {

        if(d2 == 0) {
            throw new Exception("divide exception");
        } else {
            return Double.toString(d1/d2);
        }
    }
}
