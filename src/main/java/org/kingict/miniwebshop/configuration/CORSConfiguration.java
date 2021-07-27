package org.kingict.miniwebshop.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfiguration {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterBean(){
        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        configuration.addAllowedHeader(CorsConfiguration.ALL);
        configuration.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", configuration);

        filterRegistrationBean.setFilter(new CorsFilter(source));
        filterRegistrationBean.setOrder(0);

        return filterRegistrationBean;
    }
}
