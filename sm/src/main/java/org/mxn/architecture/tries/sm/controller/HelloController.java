package org.mxn.architecture.tries.sm.controller;

import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloBiz helloBiz;
    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name){
        return helloBiz.hello(name);
    }
}
