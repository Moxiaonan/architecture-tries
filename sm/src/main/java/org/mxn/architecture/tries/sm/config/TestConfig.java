package org.mxn.architecture.tries.sm.config;

import org.mxn.architecture.tries.sm.entity.Champion;
import org.mxn.architecture.tries.sm.model.NetsManager;
import org.mxn.architecture.tries.sm.model.PlaysOff;
import org.mxn.architecture.tries.sm.util.SqlPrintInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/9
 */
@Configuration
public class TestConfig {
    @Bean
    public PlaysOff listGirlPo(){
        return new PlaysOff<>();
    }

    @Bean
    public NetsManager netsManagerOrigin(){
        return new NetsManager();
    }

    @Bean
    public NetsManager<Champion> netsManagerChampion(){
        new NetsManager<Champion>();
        return new NetsManager<Champion>();
    }

    @Bean
    public SqlPrintInterceptor createSqlPrintInterceptor(){
        return new SqlPrintInterceptor();
    }
}
