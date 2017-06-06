package cn.com.yxb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
// 该配置默认启动application.properties文件的spring.datasource.*属性并且自动配置但数据源
//@SpringBootApplication
// 该配置启动自动配置的多数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("cn.com.yxb.springboot")
@EnableScheduling
public class MyApplication {


    public static void main(String[] args) {

        SpringApplication sbl = new SpringApplication(MyApplication.class);
        sbl.run(args);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
    }
}
