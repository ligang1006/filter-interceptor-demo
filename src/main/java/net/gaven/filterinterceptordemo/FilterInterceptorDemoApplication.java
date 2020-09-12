package net.gaven.filterinterceptordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("net.gaven.filterinterceptordemo.filter")
public class FilterInterceptorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorDemoApplication.class, args);
    }

}
