package nl.CrsX.dao;

import nl.CrsX.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<Reservation> getReservationByUserId(long id) {
        List<Reservation> reservationList = this.list();
        List<Reservation> newReservationList = new ArrayList<>();
        for (Reservation reservation: reservationList) {
            if(reservation.getUserId() == id){
                newReservationList.add(reservation);
            }
        }
        return newReservationList;
    }

    @Override
    public List<Reservation> getReservationByCarId(long id) {
        List<Reservation> reservationList = this.list();
        List<Reservation> newReservationList = new ArrayList<>();
        for (Reservation reservation: reservationList) {
            if(reservation.getCarId() == id){
                newReservationList.add(reservation);
            }
        }
        return newReservationList;
    }

    @Override
    public List<Reservation> list() {
        return (List<Reservation>) sessionFactory.getCurrentSession().createQuery("from Reservation").list();
    }

    @Override
    public void update(long id, Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation2 = session.byId(Reservation.class).load(id);
        reservation2.setStartDate(reservation.getStartDate());
        reservation2.setEndDate(reservation.getEndDate());
        reservation2.setBestuurders(reservation.getBestuurders());
        reservation2.setCarId(reservation.getCarId());
        reservation2.setUserId(reservation.getUserId());
        reservation2.setDropoff(reservation.getDropoff());
        reservation2.setKinderstoel(reservation.isKinderstoel());
        reservation2.setVolgetankt(reservation.isVolgetankt());
        reservation2.setNavigatie(reservation.isNavigatie());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Reservation reservation = sessionFactory.getCurrentSession().byId(Reservation.class).load(id);
        sessionFactory.getCurrentSession().delete(reservation);
    }
}
