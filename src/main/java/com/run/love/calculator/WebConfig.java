package com.run.love.calculator;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
//        registry.addResourceHandler("/admin/**").addResourceLocations("/");
    }

}
