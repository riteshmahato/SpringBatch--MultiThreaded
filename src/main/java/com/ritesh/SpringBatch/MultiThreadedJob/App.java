package com.ritesh.SpringBatch.MultiThreadedJob;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  Debit Card SIG Settlement Processor
 */
public class App 
{
	
	private static BatchStatus batchStatus;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("SIGSettleJob.xml");
			
        	final JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
        	
			final Job job = (Job) applicationContext.getBean("importProducts");
			System.out.println("batch context running job " + job);
			
			final JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder()
			.addLong("timestamp", System.currentTimeMillis())
			.toJobParameters()
		);
			batchStatus = jobExecution.getStatus();
		} catch (Exception e) {
			System.out.println("Exception thrown in batch context" + e.getMessage());
			throw new RuntimeException(e);
		}
		
        System.out.println("batch context finished running job: " + batchStatus);
    }
}
