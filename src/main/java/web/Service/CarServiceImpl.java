package web.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.CarDAO;
import web.Model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarDAO carDAO;

//    public CarServiceImpl(@Autowired CarDAO carDAO) {
//        this.carDAO = carDAO;
//    }

    @Override
    public List<Car> getCarsList(int count) {
        List<Car> allCar = carDAO.getAllCar();
        if (count > 5) return allCar;
        return allCar.stream().limit(count).collect(Collectors.toList());
    }
}

