import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private  IEmployee employee;
    private IEmployeeBonus employeeBonus;

    @Test
    public void testTemporaryEmployee() {
        employee = new TemporaryEmployee();
        float minimumSalary = employee.getMinimumSalary();
        assertEquals(12000, minimumSalary,5);
        employeeBonus = new TemporaryEmployee();
        float calculateBonus = employeeBonus.calculateBonus(minimumSalary);
        assertEquals(calculateBonus, minimumSalary*0.06,5);

    }

    @Test
    public void testPermanentEmployee() {
        employee = new PermanentEmployee();
        float minimumSalary = employee.getMinimumSalary();
        assertEquals(15000, minimumSalary,5);

        employeeBonus = new PermanentEmployee();
        float calculateBonus = employeeBonus.calculateBonus(minimumSalary);
        assertEquals(calculateBonus, minimumSalary*0.08,5);
    }

    @Test
    public void testContractEmployee() {
        employee = new ContractEmployee();
        assertEquals(10000, employee.getMinimumSalary(),5);
    }
}
