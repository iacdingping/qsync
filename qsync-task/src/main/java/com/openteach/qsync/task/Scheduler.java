package com.openteach.qsync.task;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.openteach.qsync.api.JkfClient;
import com.openteach.qsync.service.declare.AssembleService;
import com.openteach.qsync.task.impl.MultiThreadTaskConsumer;
import com.openteach.qsync.task.impl.SingleThreadTaskGenerator;

/**
 * 
 * @author rqq
 *
 */
@Service
@Lazy(false)
public class Scheduler {

	@Resource
	private AssembleService assembleService;
	
	@Resource
	private JkfClient jkfClient;
	
	@Value("${sync.task.consumer.thread.count}")
	private int consumerThreadCount = MultiThreadTaskConsumer.DEFAULT_THREAD_COUNT;
	
	/**
	 * storage
	 */
	@Resource
	private TaskStorage storage;
	
	@Value("${sync.task.generator.retry.period}")
	private int generatorRetryPeriod = SingleThreadTaskGenerator.DEFAULT_RETRY_PERIOD;
	
	@Value("${sync.task.consumer.retry.period}")
	private int consumerRetryPeriod = MultiThreadTaskConsumer.DEFAULT_RETRY_PERIOD;
	
	/**
	 * generator
	 */
	private TaskGenerator generator;
	
	/**
	 * consumer
	 */
	private TaskConsumer consumer;

	@PostConstruct
	public void initialize() {
		// 
		this.generator = new SingleThreadTaskGenerator();
		((SingleThreadTaskGenerator)this.generator).setRetryPeriod(generatorRetryPeriod);
		((SingleThreadTaskGenerator)this.generator).setAssembleService(this.assembleService);
		((SingleThreadTaskGenerator)this.generator).setStorage(this.storage);
		this.generator.initialize();
		
		//
		this.consumer = new MultiThreadTaskConsumer();
		((MultiThreadTaskConsumer)this.consumer).setRetryPeriod(this.consumerRetryPeriod);
		((MultiThreadTaskConsumer)this.consumer).setThreadCount(this.consumerThreadCount);
		((MultiThreadTaskConsumer)this.consumer).setJkfClient(this.jkfClient);
		((MultiThreadTaskConsumer)this.consumer).setStorage(this.storage);
		this.consumer.initialize();
		
		this.generator.start();
		this.consumer.start();
	}

	@PreDestroy
	public void shutdown() {
		this.generator.shutdown();
		this.consumer.shutdown();
	}
}
