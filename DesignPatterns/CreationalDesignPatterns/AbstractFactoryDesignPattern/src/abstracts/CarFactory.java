package abstracts;

import impls.CarEngine;
import impls.CarTyre;
import interfaces.Engine;
import interfaces.Tyre;

public class CarFactory implements VehicleFactory{
    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Tyre createTyre() {
        return new CarTyre();
    }
}
