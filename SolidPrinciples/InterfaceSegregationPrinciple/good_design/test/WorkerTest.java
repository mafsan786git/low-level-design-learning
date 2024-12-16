import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkerTest {

    @Test
    public void testHumanWorker(){
        HumanWorker worker = new HumanWorker();
        assertEquals("Human is working", worker.work());
        assertEquals("Human is sleeping", worker.sleep());
    }

    @Test
    public void testRobotWorker(){
        RobotWorker worker = new RobotWorker();
        assertEquals("Robot is working", worker.work());
    }


}
