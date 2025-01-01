package abstracts;

import interfaces.Engine;
import interfaces.Tyre;

public interface VehicleFactory {
    Engine createEngine();
    Tyre createTyre();
}
