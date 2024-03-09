package myjava.mystreams.DependencyInjection;

public class DBConnection {

    Connection connection;

    DBConnection(Connection connection){
        this.connection=connection;
        connect();
        disconnect();
    }
    
    public void connect(){
        connection.connect();
    }

    public void disconnect(){
        connection.disconnect();
    }
}
