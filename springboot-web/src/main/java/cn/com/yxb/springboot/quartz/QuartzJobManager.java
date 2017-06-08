package cn.com.yxb.springboot.quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 * Created on 2017/6/7.
 *
 * @author bin
 */
public class QuartzJobManager {

    private static String DEFAULT_GROUP_NAME = "DEFAULT_GROUP_NAME";
    private static String DEFAULT_TRIGGER_NAME = "DEFAULT_TRIGGER_NAME";


    public static void addJob(Scheduler sched, String jobName, Class cls, String time) {
        try {
            JobDetail jobDetail = new JobDetailImpl(jobName, DEFAULT_GROUP_NAME, cls);// 任务名，任务组，任务执行类

            // 触发器
            CronTrigger trigger = new CronTriggerImpl(jobName, DEFAULT_TRIGGER_NAME);// 触发器名,触发器组
//            trigger.setCronExpression(time);// 触发器时间设定
            sched.scheduleJob(jobDetail, trigger);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
