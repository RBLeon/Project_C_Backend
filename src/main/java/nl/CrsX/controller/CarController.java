package nl.CrsX.controller;

import nl.CrsX.model.Car;
import nl.CrsX.model.User;
import nl.CrsX.service.CarService;
import nl.CrsX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CarController {

    @Autowired
    private CarService carService;

    //Get all the cars
    @GetMapping("/api/getCars")
    public ResponseEntity<List<Car>> getCars(){
        List<Car> list = carService.list();
        return ResponseEntity.ok().body(list);
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
    @DeleteMapping("/api/updateCar")
    @ResponseBody
    public String UpdateCar(@RequestParam int id, @RequestBody Car car){
        carService.update(id, car);
        return "Car has been updated";
    }


}