package cn.com.yxb.springboot.controller;

import cn.com.yxb.springboot.task.DynamicScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/6/6.
 *
 * @author bin
 */
@RestController
public class TaskController {

    @Autowired
    DynamicScheduledTask dynamicScheduledTask;


    @RequestMapping("/updateDynamicScheduledTask")
    @ResponseBody
    public String updateDynamicScheduledTask() {
        String cron = "0 0/3 * * * ?";

        dynamicScheduledTask.setCron(cron);
        return "success";

    }
}
