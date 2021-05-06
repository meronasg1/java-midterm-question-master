package design;

import java.util.Scanner;

public class EmployeeInfo extends AbstractEmployee {

    /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
     * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
     * then inherit that abstract class into EmployeeInfo class.Once you done with designing EmployeeInfo class,
     * go to FortuneEmployee class to apply all the fields and attributes.
     *
     * Important: YOU MUST USE the
     * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
     * Use all kind of keywords(super,this,static,final........)
     * Implement Nested class.
     * Use Exception Handling.
     *
     */

    /*
     * declare few static and final fields and some non-static fields
     */
    static String companyName;

    /*
     * You must implement the logic for below 2 methods and
     * following 2 methods are prototype as well for other methods need to be design,
     * as you will come up with the new ideas.
     */
    private int startingSalary;
    private String department;
    private int performance;

    /*
     * you must have multiple constructor.
     * Must implement below constructor.
     */
    public EmployeeInfo(int employeeId) {
        super(employeeId);

    }

    public EmployeeInfo(String name, int employeeId) {
        super(employeeId, name);

    }

    /*
     * This methods should calculate Employee bonus based on salary and performance.
     * Then it will return the total yearly bonus. So you need to implement the logic.
     * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
     * You can set arbitrary number for performance.
     * So you probably need to send 2 arguments.
     * Performance is graded 1-5, 1 being the worst and 5 being the best
     */
    public static int calculateEmployeeBonus(int salary, int performance) {
        int bonus = 0;
        switch (performance) {
            case 1:
                bonus = (salary * 2) / 100;
                break;
            case 2:
                bonus = (salary * 5) / 100;
                break;
            case 3:
                bonus = (salary * 6) / 100;
                break;
            case 4:
                bonus = (salary * 8) / 100;
                break;
            case 5:
                bonus = (salary * 10) / 100;
                break;
        }
        return bonus;
    }

    /*
     * This methods should calculate Employee Pension based on salary and numbers of years with the company.
     * Then it will return the total pension. So you need to implement the logic.
     * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
     *
     */
    public static int calculateEmployeePension(int salary, int numberOfYears) {
        int total;
        //Calculate pension
        total = (5 * numberOfYears * salary) / 100;
        return total;
    }

    private static int getNumberOfYearsWithCompany() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter start date in format (example: May,2015): ");
        String joiningDate = sc.nextLine();
        System.out.println("Please enter today's date in format (example: August,2017): ");
        String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);
        //implement numbers of year from above two dates
        int numberOfYears = calculateNumberOfYearsBetween(convertedJoiningDate, convertedTodaysDate);
        return numberOfYears;
    }

    /*
     * This method calculates the number of months between two dates given in the format 01/2015
     */
    private static int calculateNumberOfYearsBetween(String startDate, String endDate) {
        String[] startMonthYear = startDate.split("/");
        String[] endMonthYear = endDate.split("/");
        int startYear = Integer.parseInt(startMonthYear[1]);
        int startMonth = Integer.parseInt(startMonthYear[0]);
        int endYear = Integer.parseInt(endMonthYear[1]);
        int endMonth = Integer.parseInt(endMonthYear[0]);
        int differenceInNumberOfYears = endYear - startYear;
        int differenceInNumberOfMonths = endMonth - startMonth;
        int numberOfMonths = (differenceInNumberOfYears * 12) + differenceInNumberOfMonths;
        int numberOfYears = numberOfMonths / 12;
        return numberOfYears;
    }

    @Override
    public void assignDepartment() {
        String department;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the department name you want to assign employee " + employeeName() + " to");
        department = sc.nextLine();
        this.department = department;
    }

    @Override
    public void assignPerformance() {
        int performance;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the performance of employee " + employeeName() + " Possible values are 1-5 with 1 being the worst and 5 being the best");
        performance = sc.nextInt();
        this.performance = performance;
    }

    @Override
    public void assignStartingSalary() {
        int startingSalary;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the starting salary for " + employeeName());
        startingSalary = sc.nextInt();
        this.startingSalary = startingSalary;
    }

    @Override
    public int calculateSalary(int numberOfYears) {
        return startingSalary + (2 * numberOfYears * startingSalary) / 100;
    }

    @Override
    public void benefitLayout() {
        int numberOfYearsWithCompany = getNumberOfYearsWithCompany();
        int salary = calculateSalary(numberOfYearsWithCompany);
        System.out.println("Benefit Layout for Employee " + employeeName());
        System.out.println("Department: " + this.department);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + EmployeeInfo.calculateEmployeeBonus(salary, this.performance));
        System.out.println("Pension: " + EmployeeInfo.calculateEmployeePension(salary, numberOfYearsWithCompany));

    }

    private static class DateConversion {

        public DateConversion(Months months) {
        }

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);
            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }

        public static int whichMonth(String givenMonth) {
            Months months = Months.valueOf(givenMonth);
            int date = 0;
            switch (months) {
                case January:
                    date = 1;
                    break;
                case February:
                    date = 2;
                    break;
                case March:
                    date = 3;
                    break;
                case April:
                    date = 4;
                    break;
                case May:
                    date = 5;
                    break;
                case June:
                    date = 6;
                    break;
                case July:
                    date = 1;
                    break;
                case August:
                    date = 1;
                    break;
                case September:
                    date = 1;
                    break;
                case October:
                    date = 1;
                    break;
                case November:
                    date = 1;
                    break;
                case December:
                    date = 1;
                    break;
                default:
                    date = 0;
                    break;
            }
            return date;

        }
    }
}
