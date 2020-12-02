package nl.CrsX.controller;

import nl.CrsX.model.Image;
import nl.CrsX.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService imageService;

    //Get all the Images
    @GetMapping("/api/Image")
    public ResponseEntity<List<Image>> getImages(){
        List<Image> list = imageService.list();
        return ResponseEntity.ok().body(list);
    }

    //Add an Image
    @PostMapping("/api/addImage")
    @ResponseBody
    public Image AddImage(@RequestParam("MyFile") MultipartFile image) throws IOException {
        System.out.println(image);
        Image img = new Image(image.getOriginalFilename(), image.getContentType(), image.getBytes());

        final Image savedImage = imageService.save(img);

        return savedImage;
    }

    //Delete a Image
    @DeleteMapping("/api/deleteImage")
    @ResponseBody
    public String DeleteImage(@RequestParam int id){
        imageService.delete(id);
        return "Image has been deleted";
    }

    //Update a Image
    @DeleteMapping("/api/updateImage")
    @ResponseBody
    public String UpdateImage(@RequestParam int id, @RequestBody Image image){
        imageService.update(id, image);
        return "Image has been updated";
    }
}
