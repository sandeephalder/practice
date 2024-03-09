package myjava.mystreams.DependencyInjection;

public class RunDataBase {
    public static void main(String[] args) {
        new DBConnection(new MySqlDBConnection());
        new DBConnection(new PGDbConnection());
    }
}
