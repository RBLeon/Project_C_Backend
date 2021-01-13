package nl.CrsX.dao;

import nl.CrsX.model.Reservation;

import java.util.List;

public interface ReservationDao {

    Reservation save(Reservation reservation);

    Reservation get(long id);

    List<Reservation> getReservationByUserId(long id);

    List<Reservation> getReservationByCarId(long id);

    List<Reservation> list();

    void update(long id, Reservation reservation);

    void delete(long id);
}
