package com.amiti.cloud.platform.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * Created by ramchalasani on 11/1/16.
 */
@Configuration
public class AppConfig {

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }


}
