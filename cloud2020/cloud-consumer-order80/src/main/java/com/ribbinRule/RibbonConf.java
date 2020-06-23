package com.ribbinRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbonConf
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/23 22:57
 * @Version 1.0
 **/
@Configuration
public class RibbonConf {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
