package cn.com.yxb.springboot.controller;

import cn.com.yxb.springboot.scheduled.DynamicScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String updateDynamicScheduledTask(HttpServletRequest request, HttpServletResponse response) {

        // 从零秒零分钟开始，每三分钟执行一次  "0 0/3 * * * ?"
        String cron = request.getParameter("cron");

        dynamicScheduledTask.setCron(cron);

        return "success";

    }
}
