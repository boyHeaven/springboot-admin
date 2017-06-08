package cn.com.yxb.springboot.quartz1;

import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的添加任务.
 * <p>
 * Created on 2017/6/7.
 *
 * @author bin
 */
@Service
public class AddJob {

    public void execute(String jobId, String jobGroup, String jobName,
                        String cronExpression, String jobDesc) throws Exception {

        QuartzConfig QuartzConfig = new QuartzConfig();

        Scheduler scheduler = QuartzConfig.scheduler();
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>() {
            private static final long serialVersionUID = 2596601829579886713L;

            {
                ScheduleJob job = new ScheduleJob();
                job.setJobId(jobId);
                job.setJobGroup(jobGroup);
                job.setJobName(jobName);
                job.setJobStatus("1");
                job.setCronExpression(cronExpression);
                job.setDesc(jobDesc);
                this.add(job);


            }
        };
        for (ScheduleJob job : jobList) {
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            //不存在，创建一个
            if (trigger == null) {
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(job.getJobName(), job.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);

                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());

                //按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());

                //按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                        .withSchedule(scheduleBuilder).build();

                //按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        }
    }
}
