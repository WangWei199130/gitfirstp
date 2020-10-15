项目备注
# 你好
[DEBUG] 2020-10-01 03:02:33,831 method:org.quartz.impl.jdbcjobstore.JobStoreSupport$MisfireHandler.manage(JobStoreSupport.java:3995)
MisfireHandler: scanning for misfires...
[DEBUG] 2020-10-01 03:02:33,952 method:org.quartz.impl.jdbcjobstore.JobStoreSupport.doRecoverMisfires(JobStoreSupport.java:3244)
Found 0 triggers that missed their scheduled fire-time.
[DEBUG] 2020-10-01 03:02:55,831 method:org.quartz.impl.jdbcjobstore.DBSemaphore.obtainLock(DBSemaphore.java:107)
Lock 'TRIGGER_ACCESS' is desired by: quartzScheduler_QuartzSchedulerThread
[DEBUG] 2020-10-01 03:02:55,831 method:org.quartz.impl.jdbcjobstore.StdRowLockSemaphore.executeSQL(StdRowLockSemaphore.java:92)
Lock 'TRIGGER_ACCESS' is being obtained: quartzScheduler_QuartzSchedulerThread
[DEBUG] 2020-10-01 03:02:55,872 method:org.quartz.impl.jdbcjobstore.DBSemaphore.obtainLock(DBSemaphore.java:116)
Lock 'TRIGGER_ACCESS' given to: quartzScheduler_QuartzSchedulerThread
[DEBUG] 2020-10-01 03:02:55,994 method:org.quartz.impl.jdbcjobstore.DBSemaphore.releaseLock(DBSemaphore.java:141)
Lock 'TRIGGER_ACCESS' returned by: quartzScheduler_QuartzSchedulerThread
[DEBUG] 2020-10-01 03:02:56,034 method:org.quartz.core.QuartzSchedulerThread.run(QuartzSchedulerThread.java:291)
batch acquisition of 0 triggers