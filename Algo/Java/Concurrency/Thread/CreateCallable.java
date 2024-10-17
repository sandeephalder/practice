package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CreateCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        
        try{
            Thread.sleep(10);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return "Hi I am Sandeep"+Thread.currentThread().getName();

    }

    CreateCallable(){

    }

    public static void main(String[] args) {
        CreateCallable createCallable = new CreateCallable();
        ExecutorService executer = Executors.newCachedThreadPool();
        FutureTask[] results = new FutureTask[10];
        for(int i=0;i<10;i++) results[i]=(FutureTask<String>) executer.submit(createCallable);
        executer.shutdown();
        while(!executer.isTerminated()) {
            for(int i=0;i<10;i++){
                if(results[i].isDone())
                {
                    try{
                        System.out.println(results[i].get().toString());
                    }
                    catch(ExecutionException  | InterruptedException   e){
                        e.printStackTrace();
                    }
                }
                
            }
        } 
        
        
      
    }
    
}
