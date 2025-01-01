package abstracts;
import impls.MotorCycleEngine;
import impls.MotorCycleTyre;
import interfaces.Engine;
import interfaces.Tyre;

public class MotorCycleFactory implements VehicleFactory{
    @Override
    public Engine createEngine() {
        return new MotorCycleEngine();
    }

    @Override
    public Tyre createTyre() {
        return new MotorCycleTyre();
    }
}
