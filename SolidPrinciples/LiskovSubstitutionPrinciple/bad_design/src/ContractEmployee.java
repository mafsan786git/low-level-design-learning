public class ContractEmployee implements IEmployee {
    @Override
    public float getMinimumSalary() {
        return 10000;

    }

    @Override
    public float calculateBonus(float salary) {
        throw new UnsupportedOperationException("No implementation available");
    }
}
