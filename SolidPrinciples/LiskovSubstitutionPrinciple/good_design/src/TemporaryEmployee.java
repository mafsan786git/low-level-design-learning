public class TemporaryEmployee implements IEmployee,IEmployeeBonus{
    @Override
    public float getMinimumSalary() {
        return 12000;
    }

    @Override
    public float calculateBonus(float salary) {
        return (float) (salary * 0.06);
    }
}
