package Factory;

class Main{
    public static void main(String[] args) {
        FactoryBuilder.getFactory(FactoryType.TATA).getCars(CarType.ELECTRIC).get(0).getCarName();
    }
}

