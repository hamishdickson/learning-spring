package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Task;

/**
 * DAO of task
 */
public interface TaskDao extends GenericDao<Task, Long> {
    boolean removeTask(Task task);
}
