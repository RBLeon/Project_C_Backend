package nl.CrsX.controller;

import nl.CrsX.model.Image;
import nl.CrsX.service.ImageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

//    //Get all the Images
//    @GetMapping("/api/Images")
//    public ResponseEntity<List<Image>> getImages(){
//        List<Image> list = imageService.list();
//        return ResponseEntity.ok().body(list);
//    }
    @GetMapping(value = "/api/getImageByPath", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<String> returnImage(@RequestParam(name = "path") String path) throws IOException{
//        var image = this.getClass().getResource(path);
//        InputStream in = ServletContext.class.getResourceAsStream("/");
//        return IOUtils.toByteArray(imageFile.);
        String imagePath = System.getProperty("user.dir")+ "/src/main/resources/images/" + path;

        File imageFile = new File(imagePath);

        String encodedString = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(imageFile));
        return ResponseEntity.ok(encodedString);
//        return FileUtils.readFileToByteArray(imageFile);
    }

    //Add an Image
    @PostMapping("/api/addImage")
    @ResponseBody
    public String AddImage(@RequestParam("MyFile") MultipartFile image) throws IOException {
        //Get the path for the image to store
        String path = System.getProperty("user.dir")+ "/src/main/resources/images/" + image.getOriginalFilename();

        //Check if the file is empty
        if (!image.isEmpty()){
            try{
                image.transferTo(new File(path));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        //return the path
        return image.getOriginalFilename();
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
