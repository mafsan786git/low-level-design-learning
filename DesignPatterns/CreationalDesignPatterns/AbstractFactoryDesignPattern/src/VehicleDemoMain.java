import abstracts.CarFactory;
import abstracts.MotorCycleFactory;
import abstracts.VehicleFactory;
import interfaces.Engine;
import interfaces.Tyre;

public class VehicleDemoMain {
    public static void main(String[] args) {
        //factory for car component
        VehicleFactory vehicleFactory = new CarFactory();
        Engine carEngine = vehicleFactory.createEngine();
        Tyre carTyre = vehicleFactory.createTyre();

        System.out.println("Car Factory:");
        carEngine.design();
        carTyre.manufacture();

        //factory for motorCycle component
        VehicleFactory motorCycleFactory = new MotorCycleFactory();
        Engine motorCycleFactoryEngine = motorCycleFactory.createEngine();
        Tyre motorCycleFactoryTyre = motorCycleFactory.createTyre();

        System.out.println("Car Factory:");
        motorCycleFactoryEngine.design();
        motorCycleFactoryTyre.manufacture();
    }
}
