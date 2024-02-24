package com.springbootsecurityrevesion.Service;


import com.springbootsecurityrevesion.Constant.RoleConstant;
import com.springbootsecurityrevesion.Dto.UserDto;
import com.springbootsecurityrevesion.Model.Role;
import com.springbootsecurityrevesion.Repo.RoleRepo;
import com.springbootsecurityrevesion.Repo.UserRepo;
import com.springbootsecurityrevesion.Dto.RoleDto;
import com.springbootsecurityrevesion.Model.User;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepo roleRepo;

    public UserDto registerUser(UserDto userDto, Boolean isAdmin) {
        User user = this.modelMapper.map(userDto, User.class);

        Role role = this.roleRepo.findById(isAdmin == true ? RoleConstant.ADMIN_ROLE : RoleConstant.USER_ROLE).get();
        user.getRole().add(role);

        User savedUser = this.userRepo.save(user);
        UserDto savedUserDto = this.modelMapper.map(savedUser, UserDto.class);
        Set<Role> roleSet = savedUser.getRole();
        Set<RoleDto> roleDtoSet = roleSet.stream().map(rol -> this.modelMapper.map(rol, RoleDto.class)).collect(Collectors.toSet());
        savedUserDto.setRoles(roleDtoSet);

        System.out.println(savedUserDto);
        System.out.println("saved user dto -->" + savedUserDto);
        return savedUserDto;
    }

    public List<UserDto> getAllUser() {
        List<User> userList = this.userRepo.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> {
            Set<Role> role = user.getRole();
            UserDto userDto = this.modelMapper.map(user, UserDto.class);
            Set<RoleDto> roleDtoList = role.stream().map(r -> this.modelMapper.map(r, RoleDto.class)).collect(Collectors.toSet());
            userDto.setRoles(roleDtoList);
            return userDto;
        }).collect(Collectors.toList());
        return userDtoList;
    }


    public UserDto getUser(int id) {
        Optional<User> userOptional = this.userRepo.findById(id);
        User savedUser = userOptional.get();
        if (savedUser == null) {
            return null;
        }
        Set<Role> role = savedUser.getRole();
        Set<RoleDto> roleDtoSet = role.stream().map((rl) -> this.modelMapper.map(rl, RoleDto.class)).collect(Collectors.toSet());
        UserDto userDto = this.modelMapper.map(savedUser, UserDto.class);
        userDto.setRoles(roleDtoSet);

        return userDto;
    }

    @Transactional
    public String deleteUserById(int userId) {
        Optional<User> userOptional = this.userRepo.findById(userId);
        if(userOptional.isPresent() == false){
            return "User with id "+userId+" not found...";
        }
        User user = userOptional.get();
        user.getRole().clear();
        this.userRepo.delete(user);
        return "User with id "+userId+" deleted...";
    }
}
