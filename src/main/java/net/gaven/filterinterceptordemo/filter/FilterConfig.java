package net.gaven.filterinterceptordemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description: Filter configuration
 * @author: lee
 * @create: 2020-09-12 16:12
 **/
@Component
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        //设置Filter的名字，必须设置
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }
}
