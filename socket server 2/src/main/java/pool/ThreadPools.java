package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    private static ExecutorService es = null;

    public static ExecutorService getThreadPool() {
        if (es == null) {
            es = Executors.newFixedThreadPool(100);
        }

        return es;
    }

}
