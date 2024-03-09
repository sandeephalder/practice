package Thread;

class CreatingThread extends Thread{

    private static final int THREAD_COUNT =10;
public static void main(String[] args) {

    CreatingThread thread = new CreatingThread();
        thread.setPriority(10);
        thread.setName("Thread 1");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception is :"+e.toString());
            }
        });
        thread.start();
        try {
            //thread.join();
            thread.join(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   System.out.println("Thread Finished");
}

CreatingThread(){

 }
@Override
public void run(){
    int a= 10/0;
    System.out.println("\nThreadID: "+currentThread().getId());
   System.out.println("ThreadName: "+currentThread().getName());
    System.out.println("ThreadState: "+currentThread().getState());
    System.out.println("ThreadPriority: "+currentThread().getPriority());
    
}
}