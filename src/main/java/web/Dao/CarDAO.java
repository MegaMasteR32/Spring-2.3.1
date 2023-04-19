package web.Dao;

import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("2101", "red", 70));
        carList.add(new Car("BMW", "blue", 254));
        carList.add(new Car("JAC", "black", 150));
        carList.add(new Car("Nissan", "green", 1500));
        carList.add(new Car("PRIORA", "baclazhan", 80));
    }
    public List<Car> getAllCar() {
        return carList;
    }
}