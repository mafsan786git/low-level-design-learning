public class PermanentEmployee implements IEmployee {
    @Override
    public float getMinimumSalary() {
        return 15000;

    }

    @Override
    public float calculateBonus(float salary) {
        return (float) (salary * 0.8);
    }
}
