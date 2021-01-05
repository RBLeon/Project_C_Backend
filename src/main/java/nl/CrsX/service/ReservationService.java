package nl.CrsX.service;
import nl.CrsX.model.Reservation;
import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation get(long id);

    List<Reservation> list();

    void update(long id, Reservation reservation);

    void delete(long id);
}
