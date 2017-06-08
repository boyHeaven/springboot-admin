package cn.com.yxb.springboot.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2017/6/7.
 *
 * @author bin
 */
public class WeatherQuartzJobExample implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("正在执行天气任务+++++" + sdf.format(new Date()));
    }
}
