package myjava.AsyncJava17;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterPatternDemo {
    public static void main (String[] args) {
        try {
            new ExecuterPatternDemo();
        } catch (URISyntaxException | IOException | InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    ExecuterPatternDemo() throws URISyntaxException, IOException, InterruptedException, ExecutionException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);  
        String result="";
        Future<String> future = executorService.submit(()-> getResult());
        System.out.println("Result =========> "+future.get());
        System.out.println("Completed");
    }

    private String getResult() throws URISyntaxException, IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                .uri(new URI("https://postman-echo.com/get"))
                                .GET()
                                .build();

                                HttpResponse<String> response =
                                client.send(request, BodyHandlers.ofString());
                            
                      
        return response.body();
    }
}
