package cn.com.yxb.springboot.scheduled;

import cn.com.yxb.springboot.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2017/6/6.
 *
 * @author bin
 */
@Component
public class DynamicScheduledTask implements SchedulingConfigurer {

    @Autowired
    private UserService userService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static String DEFAULT_CRON = "0 0/1 * * * ?";
    private String cron = DEFAULT_CRON;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                if (!cron.equals(DEFAULT_CRON)) {
                    DEFAULT_CRON = cron;
                    System.out.println("---time1+++" + dateFormat.format(new Date()));
                } else {
                    System.out.println("---time2+++" + dateFormat.format(new Date()));
                }


            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
