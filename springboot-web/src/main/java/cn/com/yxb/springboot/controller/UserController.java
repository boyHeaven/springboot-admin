package cn.com.yxb.springboot.controller;

import cn.com.yxb.springboot.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin(@RequestParam(value = "name") String name,
                            @RequestParam(value = "password") String password) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        logger.info("enter login controller date --> [{}] name --> [{}]  password ---> [{}]",
                simpleDateFormat.format(new Date()), name, password);

        System.out.println("++++++++++++++name: " + name);
        System.out.println("++++++++++++++password: " + password);

        try {
            boolean flag = userService.userLogin(name, password);
            if (flag) {
                return "恭喜您，登录成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "对不起登录失败";

    }
}
