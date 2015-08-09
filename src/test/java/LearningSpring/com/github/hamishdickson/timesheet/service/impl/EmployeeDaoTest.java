package LearningSpring.com.github.hamishdickson.timesheet.service.impl;

import LearningSpring.com.github.hamishdickson.timesheet.domain.Employee;
import LearningSpring.com.github.hamishdickson.timesheet.service.GenericDao;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeeDaoTest extends TestCase {
    private GenericDao<Employee, Long> employeeDao = new InMemoryDao<Employee, Long>();

    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            Employee e = new Employee("Mike" + i, "IT");
            employeeDao.add(e);
        }
    }

    @Test
    public void testAdd() {
        int oldSize = employeeDao.list().size();
        Employee e = new Employee("Bob", "IT");
        employeeDao.add(e);

        int newSize = employeeDao.list().size();
        assertFalse(oldSize == newSize);
    }

    @Test
    public void testRemove() {
        int oldSize = employeeDao.list().size();
        Employee e = employeeDao.find(1L);
        employeeDao.remove(e);

        int newSize = employeeDao.list().size();

        assertFalse(oldSize == newSize);
    }

    @Test
    public void testUpdate() {
        // needs a real implementation
    }

    @Test
    public void testList() {
        List<Employee> list = employeeDao.list();
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

}