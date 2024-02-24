package com.springbootsecurityrevesion.Controller;


import com.springbootsecurityrevesion.Dto.UserDto;
import com.springbootsecurityrevesion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/testing")
    public String testing() {
        return "hello guys!";
    }

    @PostMapping("/register-user/{isAdmin}")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto, @PathVariable Boolean isAdmin) {
        UserDto savedUserDto = this.userService.registerUser(userDto, isAdmin);
        return new ResponseEntity<>(savedUserDto, HttpStatus.OK);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser() {
        List<UserDto> allUser = this.userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/get-user-by-id/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("delete-user-by-id/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable int userId){
        String message = this.userService.deleteUserById(userId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
