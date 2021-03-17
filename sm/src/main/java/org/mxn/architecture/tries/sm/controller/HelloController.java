package org.mxn.architecture.tries.sm.controller;

import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.mxn.architecture.tries.sm.entity.StarResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final String defaultWife = "none";
    @Autowired
    HelloBiz helloBiz;

//    @Autowired
//    WaybillClient waybillClient;

    @Value("${mxn.wife:"+defaultWife+"}")
    private String wife;


    @GetMapping("/{name}")
    @ResponseBody
    @PermitAll
    public String hello(@PathVariable("name") String name){
        return helloBiz.hello(name);
    }

    @GetMapping("/stars")
    @ResponseBody
    @PermitAll
    public List<StarResume> stars(){
        return helloBiz.stars();
    }

    @GetMapping("/wife")
    @ResponseBody
    @PermitAll
    public String wife(){
        return wife;
    }

//    @GetMapping("/feign-test")
//    public Result<List<LogisticsDetailItemResponse>> getFeign(){
//        return waybillClient.getLogisticsByDeliveryWaybillNo("JDVC05795779572","JDL");
//    }
}
