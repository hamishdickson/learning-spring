package LearningSpring.com.github.hamishdickson.timesheet.service;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Timesheet;

import java.util.List;

/**
 * DAO for timesheet
 */
public interface TimesheetDao extends GenericDao<Timesheet, Long> {
    List<Timesheet> list();
}
