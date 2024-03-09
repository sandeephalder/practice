package myjava.mystreams.DependencyInjection;

public class PGDbConnection implements Connection{

    @Override
    public void connect() {
        System.out.println("Connecting to PG DB");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PG DB");
    }
    
    
}
