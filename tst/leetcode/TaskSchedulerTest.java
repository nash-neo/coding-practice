package leetcode;

import org.junit.Test;

public class TaskSchedulerTest {

    private TaskScheduler ts = new TaskScheduler();

    @Test
    public void test() {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(ts.leastInterval(tasks, 2));
    }
}
