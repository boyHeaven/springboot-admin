package cn.com.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/5/22.
 *
 * @author bin
 */
@RestController
@RequestMapping(value = "/springboot")
public class HelloController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name;
    }
}
