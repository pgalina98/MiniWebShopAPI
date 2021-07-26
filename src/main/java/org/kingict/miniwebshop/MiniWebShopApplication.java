package org.kingict.miniwebshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class MiniWebShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniWebShopApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterBean(){
        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", configuration);

        filterRegistrationBean.setFilter(new CorsFilter(source));
        filterRegistrationBean.setOrder(0);

        return filterRegistrationBean;
    }
}
