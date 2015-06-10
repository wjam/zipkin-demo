package com.github.wjam.recommendations;

import com.github.kristofa.brave.ClientTracer;
import com.github.kristofa.brave.EndPointSubmitter;
import com.github.kristofa.brave.FixedSampleRateTraceFilter;
import com.github.kristofa.brave.ServerSpanThreadBinder;
import com.github.kristofa.brave.ServerTracer;
import com.github.kristofa.brave.ServletHandlerInterceptor;
import com.github.kristofa.brave.SpanCollector;
import com.github.kristofa.brave.TraceFilters;
import com.github.kristofa.brave.mysql.MySQLStatementInterceptorManagementBean;
import com.github.kristofa.brave.zipkin.ZipkinSpanCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.github.wjam.recommendations", "com.github.kristofa.brave"})
@EnableJpaRepositories
public class Application {

    @Autowired
    private ClientTracer clientTracer;

    @Autowired
    private ServerTracer serverTracer;

    @Autowired
    private EndPointSubmitter endPointSubmitter;

    @Autowired
    private ServerSpanThreadBinder serverThreadBinder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HandlerInterceptor handlerInterceptor() {
        return new ServletHandlerInterceptor(serverTracer, serverThreadBinder, endPointSubmitter) {
            @Override
            protected String getServiceName(final HttpServletRequest request) {
                return "recommendations";
            }
        };
    }

    @Bean
    public SpanCollector spanCollector() {
        return new ZipkinSpanCollector("localhost", 9410);
    }

    @Bean
    public TraceFilters traceFilters() {
        return new TraceFilters(Collections.singletonList(new FixedSampleRateTraceFilter(1)));
    }

    @Bean
    public MySQLStatementInterceptorManagementBean braveMySQL() {
        return new MySQLStatementInterceptorManagementBean(clientTracer);
    }

    @Bean
    public WebMvcConfigurerAdapter configure() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(final InterceptorRegistry registry) {
                registry.addInterceptor(handlerInterceptor());
            }
        };
    }
}
