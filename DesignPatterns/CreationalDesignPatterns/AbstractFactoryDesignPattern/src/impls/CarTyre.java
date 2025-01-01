package impls;

import interfaces.Tyre;

public class CarTyre implements Tyre {
    @Override
    public void manufacture() {
        System.out.println("Manufacturing tire for a car.");
    }
}
