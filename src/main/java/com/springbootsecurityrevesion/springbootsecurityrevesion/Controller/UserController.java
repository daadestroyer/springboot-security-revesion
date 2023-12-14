package com.springbootsecurityrevesion.springbootsecurityrevesion.Controller;


import com.springbootsecurityrevesion.springbootsecurityrevesion.Dto.RoleDto;
import com.springbootsecurityrevesion.springbootsecurityrevesion.Dto.UserDto;
import com.springbootsecurityrevesion.springbootsecurityrevesion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

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
        UserDto savedUserDto = this.userService.registerUser(userDto,isAdmin);
        return new ResponseEntity<>(savedUserDto,HttpStatus.OK);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser(){
        List<UserDto> allUser = this.userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    @GetMapping("/get-user-by-id/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto user = this.userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
