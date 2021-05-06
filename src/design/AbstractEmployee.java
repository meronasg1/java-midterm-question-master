package design;

public abstract class AbstractEmployee implements Employee {

    private int employeeId;
    private String employeeName;

    public AbstractEmployee(int employeeId) {
        this.employeeId = employeeId;
    }

    public AbstractEmployee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int employeeId() {
        return employeeId;
    }
    public String employeeName() {
        return employeeName;
    }
}
