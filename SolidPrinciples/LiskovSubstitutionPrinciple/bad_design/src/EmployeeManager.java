public class EmployeeManager {
    private IEmployee employee;

    public EmployeeManager(IEmployee employee) {
        this.employee = employee;
    }

    public float getMinimumSalary() {
        return employee.getMinimumSalary();
    }

    public float calculateBonus(float salary) {
        return employee.calculateBonus(salary);
    }
}
