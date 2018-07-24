package cn.tk.config;

import cn.tk.quartz.ScheduleTask;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author : itw_xieyy
 * @date : Created in 2018/7/23
 * @description :
 */
@Configuration
public class QuartzConfiguration {
    /**
     * job
     * @param scheduleTask
     * @return
     */
    @Bean
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(ScheduleTask scheduleTask) {
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        //是否支持异步执行
        jobDetailFactoryBean.setConcurrent(false);
//        jobDetailFactoryBean.setName("task_one");
//        jobDetailFactoryBean.setGroup("group_one");
        //定时任务目标类
        jobDetailFactoryBean.setTargetObject(scheduleTask);
        //定时任务目标方法
        jobDetailFactoryBean.setTargetMethod("sayHello");
        return jobDetailFactoryBean;
    }

    /**
     * 调度器
     * @param methodInvokingJobDetailFactoryBean
     * @return
     */
    @Bean
    public CronTriggerFactoryBean cronTrigger(MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/5 * * * * ?");
        cronTriggerFactoryBean.setName("trigger_one");
        return cronTriggerFactoryBean;
    }

    /**
     * 触发器
     * @param cronTrigger
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronTrigger) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //是否覆盖已经存在的job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延迟执行
        schedulerFactoryBean.setStartupDelay(1);
        schedulerFactoryBean.setTriggers(cronTrigger);
        return schedulerFactoryBean;
    }

}
