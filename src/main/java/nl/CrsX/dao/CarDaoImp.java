package nl.CrsX.dao;

import java.util.List;

//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nl.CrsX.model.Car;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Car car) {
        sessionFactory.getCurrentSession().save(car);
        return car.getId();
    }

    @Override
    public Car get(long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public List<Car> list() {
        List<Car> list = sessionFactory.getCurrentSession().createQuery("from Car").list();
        return list;
    }

    @Override
    public void update(long id, Car car) {
        Session session = sessionFactory.getCurrentSession();
        Car car2 = session.byId(Car.class).load(id);
        car2.setBrand(car.getBrand());
        car2.setModel(car.getModel());
        car2.setLocation(car.getLocation());
        car2.setMileage(car.getMileage());
        car2.setCarAge(car.getCarAge());
        car2.setDoors(car.getDoors());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Car car = sessionFactory.getCurrentSession().byId(Car.class).load(id);
        sessionFactory.getCurrentSession().delete(car);
    }

}
