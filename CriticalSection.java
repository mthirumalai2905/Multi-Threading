class SharedResource {
    synchronized void printNumbers() { // makes sure that in this critical section one thread acquires it and releases the lock once the job is finished
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class MyThread extends Thread {
    SharedResource resource;

    MyThread(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        resource.printNumbers();
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        
        MyThread t1 = new MyThread(obj);
        MyThread t2 = new MyThread(obj);
        
        t1.start();
        t2.start();
    }
}
