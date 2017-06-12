package cn.com.yxb.springboot.quartz1;

/**
 * 具体的添加任务.
 * <p>
 * Created on 2017/6/7.
 *
 * @author bin
 */
public interface AddJobService {


    /**
     * Execute.
     *
     * @param jobId          the job id
     * @param jobGroup       the job group
     * @param jobName        the job name
     * @param cronExpression the cron expression
     * @param jobDesc        the job desc
     * @throws Exception the exception
     */
    public void execute(String jobId, String jobGroup, String jobName,
                        String cronExpression, String jobDesc) throws Exception;

}
