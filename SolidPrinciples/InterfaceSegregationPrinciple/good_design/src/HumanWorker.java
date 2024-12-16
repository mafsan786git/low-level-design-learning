public class HumanWorker implements ISleepable,IWorkable{
    @Override
    public String work() {
        return "Human is working";
    }

    @Override
    public String sleep() {
        return "Human is sleeping";
    }
}
