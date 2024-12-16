public class HumanWorker implements IWorker {
    @Override
    public String work() {
        return "Human is working";
    }

    @Override
    public String sleep() {
        return "Human is sleeping";
    }
}
