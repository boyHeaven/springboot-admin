package cn.com.yxb.springboot.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Created on 2017/5/22.
 *
 * @author bin
 */
public class MyBanner implements Banner {
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//        out.print(environment.get);
    }


}
