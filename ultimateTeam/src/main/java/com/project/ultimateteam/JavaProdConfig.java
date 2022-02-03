package com.project.ultimateteam;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.annotation.PostConstruct;


@Profile("prod")
@Configuration
public class JavaProdConfig {
    @PostConstruct
    public void test(){
        System.out.println("Loading production profile");
    }
}
