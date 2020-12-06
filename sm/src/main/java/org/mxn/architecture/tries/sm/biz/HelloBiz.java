package org.mxn.architecture.tries.sm.biz;

import org.mxn.architecture.tries.sm.entity.Champion;
import org.mxn.architecture.tries.sm.entity.Girl;
import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;
import org.mxn.architecture.tries.sm.mapper.ChampionMapper;
import org.mxn.architecture.tries.sm.mapper.GirlMapper;
import org.mxn.architecture.tries.sm.mapper.HelloMapper;
import org.mxn.architecture.tries.sm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class HelloBiz {
    @Autowired
    HelloMapper helloMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GirlMapper girlMapper;

    @Autowired
    ChampionMapper championMapper;

    @Autowired
    TransactionTemplate transactionTemplate;

    public String hello(String name){
        User hello = helloMapper.hello();
        return name + ",i m " + hello.toString();
    }

    public List<StarResume> stars(){
        return helloMapper.stars();
    }

    public void codeTrans() throws Exception{
        int james = userMapper.insert(new User().setName("james"));
        transactionTemplate.executeWithoutResult(transactionStatus -> {
            try {
                girlMapper.insert(new Girl().setGirl("whore"));
                championMapper.insert(new Champion().setName("james").setYear("2020"));
                int i = 1 / 0;
            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
                throw e;
            }
        });
    }
}
