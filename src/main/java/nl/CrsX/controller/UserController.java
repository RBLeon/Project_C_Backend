package nl.CrsX.controller;

import nl.CrsX.model.User;
import nl.CrsX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //get all Users
    @GetMapping("/api/getUsers")
    public ResponseEntity<List<User>> getUser(){
        List<User> list = userService.list();
        return ResponseEntity.ok().body(list);
    }


    //get 1 user
    @GetMapping("/api/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam(name = "id") int id){
        User retrievedUser = userService.get(id);
        return retrievedUser;
    }

    //Add user to the database
    @PostMapping("/api/addUser")
    @ResponseBody
    public String addUser(@RequestBody User user){
        boolean sameUsername = false;
        boolean sameEmail = false;
        for (User userFromList: userService.list()) {
            if(user.getUserName().equals(userFromList.getUserName())){
                sameUsername = true;
            }
            if(user.getEmail().equals(userFromList.getEmail())){
                sameEmail = true;
            }
        }
        if (sameUsername){
            return "Username already exists";
        }else if(sameEmail){
            return "Email already exists";
        }
        else{
            userService.save(user);
            return user.getFirstName() + " " + user.getLastName() + " has been added";
        }
    }

    //Log a user in the database
    @GetMapping("/api/checkLogin")
    @ResponseBody
    public User LoginUser(@RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password){
        User retrievedUser = userService.GetUserByUsername(userName);
        if(retrievedUser.getUserName() == null){
            return new User();
        }
        if(BCrypt.checkpw(password, retrievedUser.getPassword())){
            return retrievedUser;
        }else{
            return new User();
        }
    }

    //delete data from database
    @DeleteMapping(value = "/api/deleteUser")
    @ResponseBody
    public String DeleteUser(@RequestParam(name = "id") int id){
        userService.delete(id);
        return "User has been deleted.";
    }

    //Update data from single user in database
    @PutMapping(value = "/api/updateUser")
    @ResponseBody
    public String UpdateUser(@RequestParam(name = "id") int id, @RequestBody User user){
        userService.update(id, user);
        return "User has been updated.";
    }
}
