package nl.CrsX.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("http://localhost:4200")
public class TitleController {

    @GetMapping("/pageTitles/{id}")
    public String getPageTitle(@PathVariable Integer id){
        return "titleRepository.findById(id).get().getTitle()" + id;
    }
}
