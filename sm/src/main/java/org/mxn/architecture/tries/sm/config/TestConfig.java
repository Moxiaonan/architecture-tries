package org.mxn.architecture.tries.sm.config;

import org.mxn.architecture.tries.sm.entity.Champion;
import org.mxn.architecture.tries.sm.entity.Girl;
import org.mxn.architecture.tries.sm.model.PlaysOff;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/9
 */
@Configuration
public class TestConfig {
    @Bean
    public PlaysOff<List<Girl>> listGirlPo(){
        return new PlaysOff<>();
    }
    @Bean
    public PlaysOff<Champion> championPo(){
        return new PlaysOff<>();
    }
}
