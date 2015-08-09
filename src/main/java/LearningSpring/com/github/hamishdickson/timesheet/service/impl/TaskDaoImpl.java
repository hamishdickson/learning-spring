package LearningSpring.com.github.hamishdickson.timesheet.service.impl;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Task;
import LearningSpring.com.github.hamishdickson.timesheet.service.TaskDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends HibernateDao<Task, Long> implements TaskDao {

    public boolean removeTask(Task task) {
        Query taskQuery = currentSession().createQuery(
                "from Timesheet t where t.task.id = :id");
        taskQuery.setParameter("id", task.getId());

        // task mustn't be assigned to no timesheet
        if (!taskQuery.list().isEmpty()) {
            return false;
        }

        // ok, remove as usual
        remove(task);
        return true;
    }

    @Override
    public List<Task> list() {
        return currentSession().createCriteria(Task.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
