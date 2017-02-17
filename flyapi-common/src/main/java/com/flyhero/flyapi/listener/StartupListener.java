package com.flyhero.flyapi.listener;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * spring启动后执行
 * 
 * @ClassName: StartupListener
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月17日 下午3:20:01
 *
 */
public class StartupListener implements
		ApplicationListener<ContextRefreshedEvent> {

/*	@Autowired
	private LogService logService;*/

/*	@Autowired
	private Scheduler scheduler;*/

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		
		if (arg0.getApplicationContext().getParent() == null) {// root
																// application
																// context
																// 没有parent，他就是老大.
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			System.out
					.println("=================监听spring的启动=====================");
			
			
			System.out.println("                          _ooOoo_");
			System.out.println("                         o8888888o");
			System.out.println("			 88  ·  88");
			System.out.println("			 (| -_- |)");
			System.out.println("			 O\\  =  /O	");
			System.out.println("	    	      ____/`---'\\____");
			System.out.println("	    	     .'  \\|     |//  `.");
			System.out.println("	            /  \\|||  :  |||//  \\");
			System.out.println("		   /  _||||| -:- |||||- \\");
			System.out.println("		  |   | \\\\  -   /// |   |");
			System.out.println("		  | \\_|  ''\\---/''  |   |");
			System.out.println("       		  \\  .-\\__  `-`  ___/-. /			");
			System.out.println("		___`. .'  /--.--\\  `. . __			");
			System.out.println("	    .'' '<  `.___\\_<|>_/___.'  >'''.		");
			System.out.println("	    | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |				");
			System.out.println("	    \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /	");
			System.out.println("	======`-.____`-.___\\_____/___.-`____.-'======		");
			System.out.println("			   `=---='										");
			System.out.println("       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 			");
			System.out.println("		        佛祖保佑       永无BUG");
			System.out.println("                           佛曰:    ");
	        System.out.println("		写字楼里写字间，写字间里程序员；    ");
	        System.out.println("		程序人员写程序，又拿程序换酒钱。    ");
	        System.out.println("		酒醒只在网上坐，酒醉还来网下眠；    ");
	        System.out.println("		酒醉酒醒日复日，网上网下年复年。    ");
	        System.out.println("		但愿老死电脑间，不愿鞠躬老板前；    ");
	        System.out.println("		奔驰宝马贵者趣，公交自行程序员。    ");
	        System.out.println("		别人笑我忒疯癫，我笑自己命太贱；    ");
	        System.out.println("		不见满街漂亮妹，哪个归得程序员？    ");
			
/*			ScheduleJob job = new ScheduleJob();
			job.setJobId("10001");
			job.setJobName("JobName");
			job.setJobGroup("dataWork");
			job.setJobStatus("1");
			job.setCronExpression("0/5 * * * * ?");
			job.setDesc("数据导入任务");
			job.setBeanClass("com.flyhero.flyapi.scheduler.MyJob");
			try {
				QuartzManager.addJob(scheduler,job);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SchedulerException e) {
				e.printStackTrace();
			}*/
			
/*			try {
				// 这里获取任务信息数据
				List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();

				for (int i = 0; i < 3; i++) {
					ScheduleJob job = new ScheduleJob();
					job.setJobId("10001" + i);
					job.setJobName("JobName_" + i);
					job.setJobGroup("dataWork");
					job.setJobStatus("1");
					job.setCronExpression("0/5 * * * * ?");
					job.setDesc("数据导入任务");
					System.out.println("==="+i);
					jobList.add(job);
				}

				for (ScheduleJob job : jobList) {
					System.out.println("==="+job.getDesc());
					TriggerKey triggerKey = TriggerKey.triggerKey(
							job.getJobName(), job.getJobGroup());

					// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
					CronTrigger trigger;

					trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

					// 不存在，创建一个
					if (null == trigger) {
						JobDetail jobDetail = JobBuilder
								.newJob(MyJob.class)
								.withIdentity(job.getJobName(),
										job.getJobGroup()).build();
						jobDetail.getJobDataMap().put("scheduleJob", job);

						// 表达式调度构建器
						CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
								.cronSchedule(job.getCronExpression());

						// 按新的cronExpression表达式构建一个新的trigger
						trigger = TriggerBuilder
								.newTrigger()
								.withIdentity(job.getJobName(),
										job.getJobGroup())
								.withSchedule(scheduleBuilder).build();
						 scheduler.scheduleJob(jobDetail, trigger);
						 System.out.println("即将启动任务");
						 scheduler.start();
					} else {
						// Trigger已存在，那么更新相应的定时设置
						// 表达式调度构建器
						CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
								.cronSchedule(job.getCronExpression());

						// 按新的cronExpression表达式重新构建trigger
						trigger = trigger.getTriggerBuilder()
								.withIdentity(triggerKey)
								.withSchedule(scheduleBuilder).build();

						// 按新的trigger重新设置job执行
						 scheduler.rescheduleJob(triggerKey, trigger);
					}
				}

			} catch (SchedulerException e) {
				e.printStackTrace();
			}
*/
		}

	}

}
