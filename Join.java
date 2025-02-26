class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }
}

public class JoinExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread: " + mainThread.getName());

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();  // t1 starts
        try {
            t1.join();  // Main thread waits for t1 to finish
        } catch (InterruptedException ignored) {}

        t2.start();  // After t1 finishes, t2 starts

        try {
            t2.join();  // Main thread waits for t2 to finish
        } catch (InterruptedException ignored) {}

        System.out.println("Main thread finished.");
    }
}
// There are 3 threads here 1 is the main thread and the rest two are the t1 and t2
// When the program is initiated the main thread runs t1 runs paralled to it 
// When we do t1.join() The Main thread waits for t1 to finish and begins once t1 is finished 
// Similary for t2 thread if we are using join method 
