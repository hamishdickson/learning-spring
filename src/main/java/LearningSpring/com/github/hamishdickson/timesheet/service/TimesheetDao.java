package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Timesheet;

/**
 * DAO for timesheet
 */
public interface TimesheetDao extends GenericDao<Timesheet, Long> {
    // no additional business logic atm
}
