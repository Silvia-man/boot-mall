package com.damo.bootmall.controller;

import java.util.HashMap;
import com.damo.bootmall.bean.Admin;
import com.damo.bootmall.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value(value = "damo advance")
    private String title;

    @Value(value = "${damo.project}")
    private String project;

    @Value(value = "${damo.team}")
    private String[] team;

    @Value(value = "${damo.version}")
    private String version;

    @Value(value = "${damo.unknown:default}")
    private String unknown;

    @Value(value = "#{admin.name}")
    @Bean
    public Admin admin() {
        return new Admin("man");
    }

    @RequestMapping
    public String index() {
        logger.info("this is a info log");
        logger.debug("this is a debug log");
        logger.error("this is a error log");
        return "What up";
    }

    @RequestMapping("/team")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("project", project);
        map.put("team", team);
        map.put("version", version);
        map.put("author", name);
        map.put("admin", admin());
        return map;
    }

    @RequestMapping("/{id}/{name}/{price}")
    public Product getProduct(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable Double price
    ) {
        return new Product(id, name, price);
    }
}
