package com.elearning.ai;

import com.elearning.ai.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class CourseAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseAiApplication.class, args);
    }

}
