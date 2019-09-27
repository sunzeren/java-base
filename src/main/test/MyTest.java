import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author by Sun, Date on 2019/9/9.
 * PS: Not easy to write code, please indicate.
 */
public class MyTest {
    private ExecutorService pool = Executors.newFixedThreadPool(3);

    @Test
    public void thread() {
        Thread thread = new Thread(() -> {
            System.out.println("is run imp");
        });
        thread.start();
        thread.run();
    }

}
