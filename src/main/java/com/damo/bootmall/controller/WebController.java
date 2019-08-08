package com.damo.bootmall.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @RequestMapping
    public String index(ModelMap map) {
        logger.info("web controller - freemarker");
        map.put("title", "FIRST BLOOD");
        return "index";
    }
}
