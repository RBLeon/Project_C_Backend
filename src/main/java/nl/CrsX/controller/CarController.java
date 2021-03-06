package nl.CrsX.controller;

import nl.CrsX.model.Car;
import nl.CrsX.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.io.File;
//import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    //Get all the Cars
    @GetMapping("/api/getCars")
    public ResponseEntity<List<Car>> getCars(){
        List<Car> list = carService.list();
        return ResponseEntity.ok().body(list);
    }

    //Get 1 car
    @GetMapping("/api/getCarById")
    @ResponseBody
    public Car getCarById(@RequestParam(name = "id") int id){
        return carService.get(id);
    }

    //Add a car
    @PostMapping("/api/addCar")
    @ResponseBody
    public String AddCar(@RequestBody Car car){
        Car addedCar = carService.save(car);
        return "Car has been added";
    }

    //Delete a car
    @DeleteMapping("/api/deleteCar")
    @ResponseBody
    public String DeleteCar(@RequestParam int id){
        carService.delete(id);
        return "Car has been deleted";
    }
    //Update a car
    @PutMapping("/api/updateCar")
    @ResponseBody
    public String UpdateCar(@RequestParam int id, @RequestBody Car car){
        carService.update(id, car);
        return "Car has been updated";
    }

}