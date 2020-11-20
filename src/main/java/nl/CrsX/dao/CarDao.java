package nl.CrsX.dao;

import java.util.List;

import nl.CrsX.model.Car;

public interface CarDao {

    Car save(Car car);

    Car get(long id);

    List<Car> list();

    void update(long id, Car car);

    void delete(long id);


}
