package myjava.mystreams.CreationalPattern.Singleton;

public class TestSingleSton {
    public static void main(String[] args) {
       new TestSingleSton();
    }

    TestSingleSton(){
        SingletonOld so1 = SingletonOld.build();
        SingletonOld so2 = SingletonOld.build();

        System.out.println(" SingletonOld ==> "+(so1==so2));

        SingletonEnum se1 = SingletonEnum.build();
        SingletonEnum se2 = SingletonEnum.build();

        System.out.println(" SingletonEnum ==> "+(se1==se2));


    }
}
