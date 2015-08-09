package LearningSpring.com.github.hamishdickson.timesheet.domain;


import javax.persistence.*;

@Entity
@Table(name = "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee who;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private Integer hours;

    public Timesheet() {
    }

    public Timesheet(Employee who, Task task, Integer hours) {
        this.who = who;
        this.task = task;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public Employee getWho() {
        return who;
    }

    public Task getTask() {
        return task;
    }

    public Integer getHours() {
        return hours;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWho(Employee who) {
        this.who = who;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * manager can alter hours after task is completed
     */
    public void alterHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Timesheet [" +
                "who=" + who +
                ", task=" + task +
                ", hours=" + hours +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timesheet timesheet = (Timesheet) o;

        if (id != null ? !id.equals(timesheet.id) : timesheet.id != null) return false;
        if (who != null ? !who.equals(timesheet.who) : timesheet.who != null) return false;
        if (task != null ? !task.equals(timesheet.task) : timesheet.task != null) return false;
        return !(hours != null ? !hours.equals(timesheet.hours) : timesheet.hours != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (who != null ? who.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        return result;
    }
}
