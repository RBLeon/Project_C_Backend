package nl.CrsX.service;

import nl.CrsX.model.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    Car get(long id);

    List<Car> list();

    void update(long id, Car car);

    void delete(long id);

}
