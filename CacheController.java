package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @RequestMapping("/ping")
    public String ping() {
        return "Service is healthy!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cache/add")
    public String add(@RequestBody Cache.KeyValue<String, String> keyValue) {
        return cacheService.add(keyValue.key, keyValue.value);
    }
}
