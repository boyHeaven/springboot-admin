package cn.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2017/5/22.
 *
 * @author bin
 */

@Configuration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);

    }

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setBanner(new MyBanner());
        springApplication.run(args);
    }
}
