package learns.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by gaurav on 6/10/17.
 */
public class SimpleTriggerExample {
    public static void main(String[] args) throws SchedulerException {
        //create job: you need to provide job name and jobClass
        JobDetail job = new JobDetail();
        job.setName("SimpleTriggeredQuartsJob");
        job.setJobClass(FirstJob.class);

        //create a trigger that can be used for nay job, need to provide the triggerName
        SimpleTrigger trigger = new SimpleTrigger();
        trigger.setName("TriggerForSimpleTriggeredQuartsJob");
        //when to trigger after scheduling
        trigger.setStartTime(new Date(System.currentTimeMillis() + 3000));
        //how many times to trigger
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);

        //every new job will be triggered after this interval, irrespective of previous job is completed or not
        trigger.setRepeatInterval(30000);
        //scheduler to schedule trigger
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        //provide a job and the trigger for the job
        scheduler.scheduleJob(job, trigger);


    }
}
