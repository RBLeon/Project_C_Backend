package nl.CrsX.controller;

import nl.CrsX.model.Reservation;
import nl.CrsX.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //Get all the reservations
    @GetMapping("/api/getReservations")
    public ResponseEntity<List<Reservation>> getReservations(){
        List<Reservation> list = reservationService.list();
        return ResponseEntity.ok().body(list);
    }

    //Get 1 Reservation
    @GetMapping("/api/getReservationById")
    @ResponseBody
    public Reservation getReservationById(@RequestParam(name = "id") int id){
        return reservationService.get(id);
    }

    //Add a Reservation
    @PostMapping("/api/addReservation")
    @ResponseBody
    public String AddReservation(@RequestBody Reservation reservation){
        Reservation addedReservation = reservationService.save(reservation);
        return "Reservation has been added";
    }

    //Delete a Reservation
    @DeleteMapping("/api/deleteReservation")
    @ResponseBody
    public String DeleteReservation(@RequestParam int id){
        reservationService.delete(id);
        return "Reservation has been deleted";
    }

    //Update a Reservation
    @DeleteMapping("/api/updateReservation")
    @ResponseBody
    public String UpdateReservation(@RequestParam int id, @RequestBody Reservation reservation){
        reservationService.update(id, reservation);
        return "Reservation has been updated";
    }
}
