import org.junit.Test;
import singleton.EagerSingletonDesignPattern;
import singleton.LazySingletonDesignPattern;

import static org.junit.Assert.assertEquals;

public class SingletonTest {


    @Test
    public void testEagerSingleton(){
        EagerSingletonDesignPattern instance1 = EagerSingletonDesignPattern.getInstance();
        EagerSingletonDesignPattern instance2 = EagerSingletonDesignPattern.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void testLazySingleton(){
        LazySingletonDesignPattern instance1 = LazySingletonDesignPattern.getInstance();
        LazySingletonDesignPattern instance2 = LazySingletonDesignPattern.getInstance();
        assertEquals(instance1, instance2);

    }
}
