package cn.com.yxb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
@SpringBootApplication
@ComponentScan("cn.com.yxb.springboot")
public class MyApplication {


    public static void main(String[] args) {
        SpringApplication sbl = new SpringApplication(MyApplication.class);
        sbl.run(args);
    }
}
