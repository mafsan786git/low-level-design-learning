import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class WorkerTest {
    private IWorker worker;

    @Test
    public void testHumanWork() {
        worker = new HumanWorker();
        String work = worker.work();
        String sleep = worker.sleep();
        assertEquals("Human is working", work);
        assertEquals("Human is sleeping",sleep);
    }

    @Test
    public void testRobotWork() {
        worker = new RobotWorker();
        String work = worker.work();
        assertEquals("Robot is working", work);
        assertThrows(UnsupportedOperationException.class, ()-> {
            worker.sleep();
        });
    }
}
