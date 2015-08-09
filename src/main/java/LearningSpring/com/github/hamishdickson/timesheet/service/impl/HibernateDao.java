package LearningSpring.com.github.hamishdickson.timesheet.service.impl;

import LearningSpring.com.github.hamishdickson.timesheet.service.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Basic Dao operations dependent on hibernate
 */

// this bit means stuff will run within a transaction
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class HibernateDao<E, K extends Serializable> implements GenericDao<E, K> {
    private SessionFactory sessionFactory;
    protected Class<? extends E> daoType;

    public HibernateDao() {
        daoType = (Class<E>) ((ParameterizedType)
            getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(E entity) {
        currentSession().save(entity);
    }

    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void remove(E entity) {
        currentSession().delete(entity);
    }

    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }

    public List<E> list() {
        return currentSession().createCriteria(daoType).list();
    }
}