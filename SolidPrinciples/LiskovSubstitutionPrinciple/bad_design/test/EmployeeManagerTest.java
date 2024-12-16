import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class EmployeeManagerTest {
    private EmployeeManager employeeManager;

    @Test
    public void testContractEmployee(){
        employeeManager = new EmployeeManager(new ContractEmployee());
        float minimumSalary = employeeManager.getMinimumSalary();
        assertEquals(10000.00, minimumSalary, 5);
        assertThrows(UnsupportedOperationException.class, () -> {
            employeeManager.calculateBonus(minimumSalary);
        });
    }

    @Test
    public void testPermanentEmployee(){
        employeeManager = new EmployeeManager(new PermanentEmployee());
        float minimumSalary = employeeManager.getMinimumSalary();
        assertEquals(15000, minimumSalary, 5);
        float calculateBonus = employeeManager.calculateBonus(minimumSalary);
        assertEquals(calculateBonus,minimumSalary * 0.8,5);
    }

    @Test
    public void testTemporaryEmployee(){
        employeeManager = new EmployeeManager(new TemporaryEmployee());
        float minimumSalary = employeeManager.getMinimumSalary();
        assertEquals(12000, minimumSalary, 5);
        float calculateBonus = employeeManager.calculateBonus(minimumSalary);
        assertEquals(calculateBonus,minimumSalary * 0.6,5);
    }
}
