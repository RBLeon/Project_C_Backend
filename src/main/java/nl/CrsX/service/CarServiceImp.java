package nl.CrsX.service;

import nl.CrsX.dao.CarDao;
import nl.CrsX.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public long save(Car car) {
        return 0;
    }

    @Override
    public Car get(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Car> list() {

        return carDao.list();
    }

    @Override
    public void update(long id, Car car) {

    }

    @Override
    public void delete(long id) {

    }
}
