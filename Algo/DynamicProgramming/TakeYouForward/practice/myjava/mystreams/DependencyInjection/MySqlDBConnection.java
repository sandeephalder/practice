package myjava.mystreams.DependencyInjection;

public class MySqlDBConnection implements Connection{
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL DB");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL DB");
    }
}
