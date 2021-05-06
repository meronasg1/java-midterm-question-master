package design;

public interface Employee {

	/*Employee is an Interface which contains multiple unimplemented methods.Again few methods
	has been declared in below. you need to brainstorm to add more methods to meet the business requirements.
	*/
    //please read the following method and understand the business requirements of these following methods
    //and then implement these in a concrete class.

    //employeeId() will return employee id.
    int employeeId();

    //employeeName() will return employee name
    String employeeName();

    //assignDepartment() will assign employee to departments
    void assignDepartment();

    //will assign a performance value from 1 to 5
    public void assignPerformance();

    //will assign the starting salary for the employee
    public void assignStartingSalary();

    //calculate employee salary. Salary is calculated as starting salary + 2% for each year the employee was with the company
    int calculateSalary(int numberOfYears);

    //employee benefit
    void benefitLayout();

}
