package nl.CrsX.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Reservation")
public class Reservation {
    @Id //tell hibernate this is a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long carId;
    private Long Bestuurders;
    private Long Price;
    private boolean Kinderstoel;
    private boolean Navigatie;
    private boolean Volgetankt;
    private Date startDate;
    private Date endDate;
    private String Dropoff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getBestuurders() {
        return Bestuurders;
    }

    public void setBestuurders(Long bestuurders) {
        Bestuurders = bestuurders;
    }

    public boolean isKinderstoel() {
        return Kinderstoel;
    }

    public void setKinderstoel(boolean kinderstoel) {
        Kinderstoel = kinderstoel;
    }

    public boolean isNavigatie() {
        return Navigatie;
    }

    public void setNavigatie(boolean navigatie) {
        Navigatie = navigatie;
    }

    public boolean isVolgetankt() {
        return Volgetankt;
    }

    public void setVolgetankt(boolean volgetankt) {
        Volgetankt = volgetankt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getDropoff() {
        return Dropoff;
    }

    public void setDropoff(String dropoff) {
        Dropoff = dropoff;
    }

    @Override
    public String toString() {
        return "StartDate:" + startDate + "" +
                "\n EndDate: " + endDate + "" +
                "\n carId: " + carId + "" +
                "\n userId: " + userId + "" +
                "\n Bestuurders: " + Bestuurders + "" +
                "\n Price: " + Price + "" +
                "\n Volgetankt: " + Volgetankt + "" +
                "\n Navigatie: " + Navigatie + "" +
                "\n Kinderstoel: " + Kinderstoel + "";
    }

}
