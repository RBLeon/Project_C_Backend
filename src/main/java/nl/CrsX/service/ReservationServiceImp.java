package nl.CrsX.service;
import nl.CrsX.dao.ReservationDao;
import nl.CrsX.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    @Transactional
    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    @Transactional
    public Reservation get(long id) {
        return reservationDao.get(id);
    }

    @Override
    @Transactional
    public List<Reservation> list() {
        return reservationDao.list();
    }

    @Override
    @Transactional
    public void update(long id, Reservation reservation) {
        reservationDao.update(id, reservation);
    }

    @Override
    @Transactional
    public void delete(long id) {
        reservationDao.delete(id);
    }
}
