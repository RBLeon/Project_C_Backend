package nl.CrsX.service;

import nl.CrsX.dao.CarDao;
import nl.CrsX.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImp implements CarService {


    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public Car save(Car car) {
        return carDao.save(car);
    }

    @Override
    @Transactional
    public Car get(long id) {
        return carDao.get(id);
    }

    @Override
    @Transactional
    public List<Car> list() {
        return carDao.list();
    }

    @Override
    @Transactional
    public void update(long id, Car car) {
        carDao.update(id, car);
    }

    @Override
    @Transactional
    public void delete(long id) {
        carDao.delete(id);
    }
}
