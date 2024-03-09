package Factory;

import java.util.List;

public interface Factory {
    public List<Car> getCars(CarType carType);
}
