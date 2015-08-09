package LearningSpring.com.github.hamishdickson.timesheet.service.impl;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Timesheet;
import LearningSpring.com.github.hamishdickson.timesheet.service.TimesheetDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("timesheetDao")
public class TimesheetDaoImpl extends HibernateDao<Timesheet, Long> implements TimesheetDao {
    public List<Timesheet> list() {
        return currentSession().createCriteria(Timesheet.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
