package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Employee;
import LearningSpring.com.github.hamishdickson.timesheet.domain.Manager;
import LearningSpring.com.github.hamishdickson.timesheet.domain.Task;

import java.util.List;

/**
 * Defines business operations
 */

public interface TimesheetService {

    /**
     * @return Finds the busiest task (with the most of employees)
     * Returns (null) when tasks are empty
     */
    Task busiestTask();

    /**
     * Finds all the tasks for an employee
     */
    List<Task> tasksForEmployee(Employee employee);

    /**
     * Finds all the tasks for a manager
     */
    List<Task> tasksForManager(Manager manager);
}
