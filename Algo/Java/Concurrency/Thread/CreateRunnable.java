package Thread;

public class CreateRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println(" Runnable");
    }

    public static void main(String[] args) {
        CreateRunnable runnable =  new CreateRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    CreateRunnable(){

    }
    
}
