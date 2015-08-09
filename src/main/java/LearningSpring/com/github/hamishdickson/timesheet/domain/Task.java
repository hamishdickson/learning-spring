package LearningSpring.com.github.hamishdickson.timesheet.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_employee",
        joinColumns = {@JoinColumn(name = "task_id")},
        inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> assignedEmployees = new ArrayList<Employee>();

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    private String desciption;
    boolean completed;

    public Task() {
    }

    public Task(String description, Manager manager, Employee... employees) {
        this.desciption = description;
        this.manager = manager;
        assignedEmployees.addAll(Arrays.asList(employees));
        this.completed = false;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
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

    public Long getId() {
        return id;
    }

    public String getDesciption() {
        return desciption;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (completed != task.completed) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (assignedEmployees != null ? !assignedEmployees.equals(task.assignedEmployees) : task.assignedEmployees != null)
            return false;
        if (manager != null ? !manager.equals(task.manager) : task.manager != null) return false;
        return !(desciption != null ? !desciption.equals(task.desciption) : task.desciption != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (assignedEmployees != null ? assignedEmployees.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (desciption != null ? desciption.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", assignedEmployees=" + assignedEmployees +
                ", manager=" + manager +
                ", desciption='" + desciption + '\'' +
                ", completed=" + completed +
                '}';
    }
}
