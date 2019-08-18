package com.damo.bootmall.component;

import com.damo.bootmall.controller.ProductController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisComponent {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private StringRedisTemplate template;

    public void set(String key, String value) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        if(!this.template.hasKey(key)) {
            ops.set(key, value);
            logger.info(key + " set succeed");
        } else {
            logger.info(key + " already exist");
        }
    }


    public <T> void set(String key, T value) throws JsonProcessingException {
        ValueOperations<String , String> ops = this.template.opsForValue();
        ObjectMapper mapper = new ObjectMapper();
        if (!this.template.hasKey(key)) {
            String str = mapper.writeValueAsString(value);
            ops.set(key, str);
            logger.info(key + " set succeed");

        } else {
            logger.info(key + "already exist");
        }
    }

    public <T> T get(String key, Class<T> clazz) throws IOException {
        String str = this.template.opsForValue().get(key);
        T obj = null;
        if(str != null) {
            ObjectMapper mapper = new ObjectMapper();
            obj = mapper.readValue(str,clazz);
        }
        return obj;
    }

    public void del(String key) {
        this.template.delete(key);
    }
}