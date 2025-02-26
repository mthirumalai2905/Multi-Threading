class MyThread extends Thread {
   @Override
   public void run(){
    for(int i = 1; i <= 20; i++){
        System.out.println(Thread.currentThread().getName() + "-" + i);
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
    } 
   }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        
        t1.start();
        t2.start();
    }
}
