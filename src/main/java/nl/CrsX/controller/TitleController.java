package nl.CrsX.controller;

import nl.CrsX.model.Car;
import nl.CrsX.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
public class TitleController {

    @GetMapping("/pageTitles/{id}")
    public String getPageTitle(@PathVariable Integer id){
        return "titleRepository.findById(id).get().getTitle()" + id;
    }

    @Autowired
    private CarService carService;

    //Get all the books
    @GetMapping("/api/Car")
    public ResponseEntity<List<Car>> list(){
        List<Car> list = carService.list();
        return ResponseEntity.ok().body(list);
    }
}