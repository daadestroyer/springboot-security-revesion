package com.springbootsecurityrevesion.springbootsecurityrevesion.Repo;

import com.springbootsecurityrevesion.springbootsecurityrevesion.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByUserEmail(String email);
}
