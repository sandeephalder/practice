package Factory;

import java.util.ArrayList;
import java.util.List;

public class TataFactory implements Factory{

    @Override
    public List<Car> getCars(CarType carType) {
        List<Car> electricList = new ArrayList<>();
        List<Car> petrolList = new ArrayList<>();
        petrolList.add(new Nexon());
        electricList.add(new NexonElectric());
        if(carType ==CarType.ELECTRIC) return electricList;
        else return petrolList;
    }
    
}
