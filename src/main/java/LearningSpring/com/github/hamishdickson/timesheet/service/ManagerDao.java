package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Manager;

/**
 * DAO of manager
 */
public interface ManagerDao extends GenericDao<Manager, Long> {
    boolean removeManager(Manager manager);
}
