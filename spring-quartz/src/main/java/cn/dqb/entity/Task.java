package cn.dqb.entity;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @date 2019/11/21 12:08
 */
public class Task implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("xxx");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
    }
}
