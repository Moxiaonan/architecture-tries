package org.mxn.architecture.tries.sm.biz;

import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;
import org.mxn.architecture.tries.sm.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloBiz {
    @Autowired
    HelloMapper helloMapper;
    public String hello(String name){
        User hello = helloMapper.hello();
        return name + ",i m " + hello.toString();
    }

    public List<StarResume> stars(){
        return helloMapper.stars();
    }
}
