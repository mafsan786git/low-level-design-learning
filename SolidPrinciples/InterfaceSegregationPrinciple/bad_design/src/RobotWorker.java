public class RobotWorker implements IWorker {
    @Override
    public String work() {
        return "Robot is working";
    }

    @Override
    public String sleep() {
        throw new UnsupportedOperationException("Robot cannot sleep");
    }
}
