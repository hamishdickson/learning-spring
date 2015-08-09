package LearningSpring.com.github.hamishdickson.timesheet.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    private List<Employee> assignedEmployees = new ArrayList<Employee>();
    private Manager manager;
    private boolean completed;
    private String desciption;

    public Task(String description, Manager manager, Employee... employees) {
        this.desciption = description;
        this.manager = manager;
        assignedEmployees.addAll(Arrays.asList(employees));
        this.completed = false;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public Manager getManager() {
        return manager;
    }

    public void addEmployee(Employee employee) {
        this.assignedEmployees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.assignedEmployees.remove(employee);
    }

    public void completeTask() {
        this.completed = true;
    }
}
