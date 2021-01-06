package nl.CrsX.dao;

import nl.CrsX.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationDaoImp implements ReservationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Reservation save(Reservation reservation) {
        sessionFactory.getCurrentSession().save(reservation);
        return reservation;
    }

    @Override
    public Reservation get(long id) {
        return sessionFactory.getCurrentSession().get(Reservation.class, id);
    }

    @Override
    public List<Reservation> list() {
        return (List<Reservation>) sessionFactory.getCurrentSession().createQuery("from Reservation").list();
    }

    @Override
    public void update(long id, Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation2 = session.byId(Reservation.class).load(id);
        reservation2.setBeginDate(reservation.getBeginDate());
        reservation2.setEndDate(reservation.getEndDate());

        session.flush();
    }

    @Override
    public void delete(long id) {
        Reservation reservation = sessionFactory.getCurrentSession().byId(Reservation.class).load(id);
        sessionFactory.getCurrentSession().delete(reservation);
    }
}
