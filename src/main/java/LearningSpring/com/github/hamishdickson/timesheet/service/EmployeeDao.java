package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Employee;

/**
 * Dao of employee
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {
    boolean removeEmployee(Employee employee);
}
